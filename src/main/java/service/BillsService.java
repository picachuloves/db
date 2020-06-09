package service;


import connection.DBConnection;
import model.Bills;
import repository.BillsRepos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillsService implements BillsRepos {
    private Connection connection;
    @Override
    public void add(Bills bills) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO bills(id_contract, bill) values(?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, bills.getId_contract());
            preparedStatement.setBigDecimal(2, bills.getBill());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<Bills> getAll() throws SQLException {
        connection = DBConnection.getConnection();
        List<Bills> list = new ArrayList<>();

        String sql = "SELECT * FROM bills";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Bills bills = new Bills();

                bills.setBill_number(resultSet.getInt("bill_number"));
                bills.setId_contract(resultSet.getInt("id_contract"));
                bills.setBill(resultSet.getBigDecimal("bill"));

                list.add(bills);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return list;
    }

    @Override
    public Bills  getByBillNumber(Integer id) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM bills WHERE id=?";

        Bills bills = new Bills();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                bills.setBill_number(resultSet.getInt("bill_number"));
                bills.setId_contract(resultSet.getInt("id_contract"));
                bills.setBill(resultSet.getBigDecimal("bill"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return bills;
    }

    @Override
    public void update(Bills bills) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE bills SET id_contract=?, bill=? WHERE bill_number=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, bills.getId_contract());
            preparedStatement.setBigDecimal(2, bills.getBill());
            preparedStatement.setInt(3, bills.getBill_number());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void remove(Bills bills) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM bills WHERE bill_number=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, bills.getBill_number());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
