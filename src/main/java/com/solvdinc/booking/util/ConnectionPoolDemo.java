package com.solvdinc.booking.util;

public class ConnectionPoolDemo {
    public static void main(String[] args) {
        ConnectionPool pool = ConnectionPool.getInstance();

        for (int i = 1; i <= 11; i++) {
            final int taskId = i;
            new Thread(() -> {
                Connection conn = null;
                try {
                    System.out.println("Task " + taskId + " is trying to get a connection...");
                    conn = pool.getConnection();
                    System.out.println("Task " + taskId + " got connection " + conn.getId());

                    conn.execute("SELECT * FROM table_" + taskId);
                    Thread.sleep(1000L * (1 + (taskId % 3)));

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Task " + taskId + " was interrupted: " + e.getMessage());
                } finally {
                    if (conn != null) {
                        pool.releaseConnection(conn);
                        System.out.println("Task " + taskId + " released connection " + conn.getId());
                    }
                }
            }).start();
        }
    }
}
