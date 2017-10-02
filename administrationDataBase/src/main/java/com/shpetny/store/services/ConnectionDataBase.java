package com.shpetny.store.services;


import org.apache.log4j.Logger;
import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
public class ConnectionDataBase {

    private static final Logger log = Logger.getLogger(ConnectionDataBase.class);

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:~/store";
    private static final String DB_USER = "eugene";
    private static final String DB_PASSWORD = "123";

    // TODO UPDATE THIS METHOD
    public static Connection getConnection() {
        JdbcConnectionPool cp;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            log.error(e);
        }
        cp = JdbcConnectionPool.create(DB_CONNECTION, DB_USER, DB_PASSWORD);
        try {
            return cp.getConnection();
        } catch (SQLException e) {
            log.error(e);
            e.printStackTrace();
        }
        return null;
    }
}
