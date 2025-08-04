package com.solvdinc.booking.util;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static final int MAX_CONNECTIONS = 10;
    private final List<Connection> availableConnections = new ArrayList<>();
    private final List<Connection> usedConnections = new ArrayList<>();

    private static ConnectionPool instance;

    private ConnectionPool() {
        for (int i = 1; i <= MAX_CONNECTIONS; i++) {
            availableConnections.add(new Connection(i));
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public synchronized Connection getConnection() throws InterruptedException {
        while (availableConnections.isEmpty()) {
            System.out.println("No connection is available, please wait");
            wait();
        }
        Connection connection = availableConnections.remove(0); // исправлено для List
        usedConnections.add(connection);
        System.out.println("Connection's received " + connection.getId());
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        if (connection == null) {
            return;
        }
        if (usedConnections.remove(connection)) {
            availableConnections.add(connection);
            System.out.println("Connection's avaliable " + connection.getId());
            notifyAll();
        }
    }

    public static void main(String[] args) {
        ConnectionPool pool = ConnectionPool.getInstance();

        for (int i = 1; i <= 11; i++) {
            final int taskId = i;
            new Thread(() -> {
                Connection conn = null;
                try {
                    conn = pool.getConnection();
                    conn.execute("SELECT * FROM table_" + taskId);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                } finally {
                    if (conn != null) {
                        pool.releaseConnection(conn);
                    }
                }
            }).start();
        }
    }
}
