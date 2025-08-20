package com.solvdinc.booking.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private static final int MAX_CONNECTIONS = 10;
    private final BlockingQueue<Connection> availableConnections;

    private static volatile ConnectionPool instance;

    private ConnectionPool() {
        availableConnections = new ArrayBlockingQueue<>(MAX_CONNECTIONS);
        try {
            for (int i = 1; i <= MAX_CONNECTIONS; i++) {
                availableConnections.put(new Connection(i));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Initialization interrupted", e);
        }
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws InterruptedException {
        Connection connection = availableConnections.take();
        System.out.println("Connection received " + connection.getId() +
                " | Available now: " + getAvailableConnectionsCount());
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            try {
                availableConnections.put(connection);
                System.out.println("Connection released " + connection.getId() +
                        " | Available now: " + getAvailableConnectionsCount());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Failed to release connection: " + e.getMessage());
            }
        }
    }

    public int getAvailableConnectionsCount() {
        return availableConnections.size();
    }
}
