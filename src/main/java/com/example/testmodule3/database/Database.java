package com.example.testmodule3.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    protected String jdbcUrl;
    protected String jdbcUserName;
    protected String jdbcPassword;
    public static  Database instance;

    public Database() {
        this.jdbcUrl = "jdbc:mysql://localhost:3306/testmodule3?useSSL=false";
        this.jdbcUserName = "root";
        this.jdbcPassword = "123456";
    }
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(jdbcUrl, jdbcUserName,jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage() + "Error");
        }
        return null;
    }
}
