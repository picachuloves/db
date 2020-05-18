package service;

import connection.DBConnection;
import model.AddedServices;
import repository.AddedServicesRepos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddedServicesService implements AddedServicesRepos {
    private Connection connection;
    @Override
    public void add(AddedServices addedServices) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO added_services(bill_number, add_service, service_bill) values(?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, addedServices.getBill_number());
            preparedStatement.setString(2, addedServices.getAdd_service());
            preparedStatement.setBigDecimal(3, addedServices.getService_bill());

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
    public List<AddedServices> getAll() throws SQLException {
        connection = DBConnection.getConnection();
        List<AddedServices> list = new ArrayList<>();

        String sql = "SELECT * FROM added_services";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                AddedServices addedServices = new AddedServices();

                addedServices.setId(resultSet.getInt("id"));
                addedServices.setBill_number(resultSet.getInt("bill_number"));
                addedServices.setAdd_service(resultSet.getString("add_service"));
                addedServices.setService_bill(resultSet.getBigDecimal("service_bill"));

                list.add(addedServices);
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
    public AddedServices getById(Integer id) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM added_services WHERE id=?";

        AddedServices addedServices = new AddedServices();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            addedServices.setId(resultSet.getInt("id"));
            addedServices.setBill_number(resultSet.getInt("bill_number"));
            addedServices.setAdd_service(resultSet.getString("add_service"));
            addedServices.setService_bill(resultSet.getBigDecimal("service_bill"));

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
        return addedServices;
    }

    @Override
    public AddedServices getByBillNumber(Integer id) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM added_services WHERE bill_number=?";

        AddedServices addedServices = new AddedServices();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            addedServices.setId(resultSet.getInt("id"));
            addedServices.setBill_number(resultSet.getInt("bill_number"));
            addedServices.setAdd_service(resultSet.getString("add_service"));
            addedServices.setService_bill(resultSet.getBigDecimal("service_bill"));

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
        return addedServices;
    }

    @Override
    public void updateById(AddedServices addedServices) throws SQLException {
        connection = DBConnection.getConnection();

    }

    @Override
    public void updateByBillNumber(AddedServices addedServices) throws SQLException {
        connection = DBConnection.getConnection();

    }

    @Override
    public void removeById(AddedServices addedServices) throws SQLException {
        connection = DBConnection.getConnection();

    }

    @Override
    public void removeByBillNumber(AddedServices addedServices) throws SQLException {
        connection = DBConnection.getConnection();

    }
}
