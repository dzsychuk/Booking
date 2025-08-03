package com.solvdinc.booking.util;

import java.util.ArrayList;
import java.util.List;

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
}
