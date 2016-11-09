package com.johnremboo.utils;

import com.johnremboo.dao.BaseDao;
import com.johnremboo.dao.UserDao;
import com.johnremboo.model.User;

import java.sql.*;

public abstract class DbConnector {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/userDb";
    private static String name = "root";
    private static String password = "";
    private static boolean dbCreated = false;

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, name, password);

        if (!dbCreated)
            createDb(connection);

        return connection;
    }

    public static BaseDao<User> getUserDAO() throws ClassNotFoundException, SQLException {
        return new UserDao(getConnection());
    }

    private static void createDb(Connection connection) {
        try {
            DatabaseMetaData dbm = connection.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "user", null);
            if (!tables.next()) {
                String query = "CREATE TABLE `user` ( `id` BIGINT NOT NULL AUTO_INCREMENT , `name` VARCHAR(100) NOT NULL , " +
                               "`surname` VARCHAR(100) NOT NULL , `year` INT(4) NOT NULL , PRIMARY KEY (`id`));";
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbCreated = true;
    }
}