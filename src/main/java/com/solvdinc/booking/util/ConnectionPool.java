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
            System.out.println("All connections are busy. Waiting...");
            wait();
        }
        Connection connection = availableConnections.removeFirst();
        usedConnections.add(connection);
        System.out.println("Connection " + connection.getId() + " acquired.");
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        usedConnections.remove(connection);
        availableConnections.add(connection);
        System.out.println("Connection " + connection.getId() + " released.");
        notifyAll();
    }

    public static void main(String[] args) {
        ConnectionPool pool = ConnectionPool.getInstance();

        // Запустим 12 потоков, чтобы проверить блокировку
        for (int i = 1; i <= 12; i++) {
            final int taskId = i;
            new Thread(() -> {
                try {
                    Connection conn = pool.getConnection();
                    conn.execute("SELECT * FROM table_" + taskId);
                    Thread.sleep(2000);
                    pool.releaseConnection(conn);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
