package service;/*package JDBCtry.service;

import JDBCtry.DBConnection;
import JDBCtry.repository.BaseRepos;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseService implements BaseRepos {
    private DBConnection db;
    protected Connection connection;
    @Override
    public Connection getConnection() {
        connection = db.getConnection();
        return connection;
    }

    @Override
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            System.out.println("Ошибка закрытия SQL соединения!");
        }
    }

    @Override
    public void setDB(DBConnection db) {
        this.db = db;
    }
}*/
