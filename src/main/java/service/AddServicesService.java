package service;

import connection.DBConnection;
import model.AddServices;
import repository.AddServicesRepos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddServicesService implements AddServicesRepos {
    private Connection connection;
    @Override
    public void add(AddServices addServices) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO add_services(services, services_allowance, food, food_allowance, entertainments, entertainments_allowance) values(?,?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, addServices.getServices());
            preparedStatement.setBigDecimal(2, addServices.getServices_allowance());
            preparedStatement.setString(3, addServices.getFood());
            preparedStatement.setBigDecimal(4, addServices.getFood_allowance());
            preparedStatement.setString(5, addServices.getEntertainments());
            preparedStatement.setBigDecimal(6, addServices.getEntertainments_allowance());
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
    public List<AddServices> getAll() throws SQLException {
        connection = DBConnection.getConnection();
        List<AddServices> list = new ArrayList<>();

        String sql = "SELECT * FROM add_services";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                AddServices addServices = new AddServices();
                addServices.setId(resultSet.getInt("id"));
                addServices.setServices(resultSet.getString("services"));
                addServices.setServices_allowance(resultSet.getBigDecimal("services_allowance"));
                addServices.setFood(resultSet.getString("food"));
                addServices.setFood_allowance(resultSet.getBigDecimal("food_allowance"));
                addServices.setEntertainments(resultSet.getString("entertainments"));
                addServices.setEntertainments_allowance(resultSet.getBigDecimal("entertainments_allowance"));
                list.add(addServices);
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
    public AddServices getById(Integer id) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM add_services WHERE id=?";

        AddServices addServices = new AddServices();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                addServices.setId(resultSet.getInt("id"));
                addServices.setServices(resultSet.getString("services"));
                addServices.setServices_allowance(resultSet.getBigDecimal("services_allowance"));
                addServices.setFood(resultSet.getString("food"));
                addServices.setFood_allowance(resultSet.getBigDecimal("food_allowance"));
                addServices.setEntertainments(resultSet.getString("entertainments"));
                addServices.setEntertainments_allowance(resultSet.getBigDecimal("entertainments_allowance"));
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
        return addServices;
    }

    @Override
    //UPDATE BY ID
    public void update(AddServices addServices) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE add_services SET services=?, services_allowance=?, food=?, food_allowance=?, entertainments=?, entertainments_allowance=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, addServices.getServices());
            preparedStatement.setBigDecimal(2, addServices.getServices_allowance());
            preparedStatement.setString(3, addServices.getFood());
            preparedStatement.setBigDecimal(4, addServices.getFood_allowance());
            preparedStatement.setString(5, addServices.getEntertainments());
            preparedStatement.setBigDecimal(6, addServices.getEntertainments_allowance());
            preparedStatement.setInt(7, addServices.getId());

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
    //DELETE BY ID
    public void remove(AddServices addServices) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM add_services WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, addServices.getId());

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
