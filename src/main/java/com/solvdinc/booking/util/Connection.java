package com.solvdinc.booking.util;

public class Connection {

    private final int id;

    public Connection(int id) {
        this.id = id;
    }

    public void execute(String sql) {
        System.out.println("Connection " + id + " executing: " + sql);
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Connection other)) return false;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
