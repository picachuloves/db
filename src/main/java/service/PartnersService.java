package service;


import connection.DBConnection;
import model.Partners;
import repository.PartnersRepos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PartnersService implements PartnersRepos {
    private Connection connection;
    @Override
    public void add(Partners partners) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO partners(information, cooperation_date_start, cooperation_date_end) values(?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, partners.getInformation());
            preparedStatement.setDate(2, partners.getCooperation_date_start());
            preparedStatement.setDate(3, partners.getCooperation_date_end());

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
    public List<Partners> getAll() throws SQLException {
        connection = DBConnection.getConnection();
        List<Partners> list = new ArrayList<>();

        String sql = "SELECT * FROM partners";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Partners partners = new Partners();

                partners.setInformation(resultSet.getString("information"));
                partners.setCooperation_date_start(resultSet.getDate("cooperation_date_start"));
                partners.setCooperation_date_end(resultSet.getDate("cooperation_date_end"));
                list.add(partners);
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
    public Partners getByContractNumber(Integer number) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM partners WHERE id=?";

        Partners partners = new Partners();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, number);

            ResultSet resultSet = preparedStatement.executeQuery();

            partners.setContract_number(resultSet.getInt("contract_number"));
            partners.setInformation(resultSet.getString("information"));
            partners.setCooperation_date_start(resultSet.getDate("cooperation_date_start"));
            partners.setCooperation_date_end(resultSet.getDate("cooperation_date_end"));

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
        return partners;
    }

    @Override
    public void update(Partners partners) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE partners SET information=?, cooperation_date_start=?, cooperation_date_end=? WHERE contract_number=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, partners.getInformation());
            preparedStatement.setDate(2, partners.getCooperation_date_start());
            preparedStatement.setDate(3, partners.getCooperation_date_end());
            preparedStatement.setInt(4, partners.getContract_number());

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
    public void remove(Partners partners) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM partners WHERE contract_number=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, partners.getContract_number());

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
