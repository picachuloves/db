package service;


import connection.DBConnection;
import model.Contracts;
import repository.ContractsRepos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractsService implements ContractsRepos {
    private Connection connection;
    @Override
    public void add(Contracts contracts) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values(?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, contracts.getId_client());
            preparedStatement.setInt(2, contracts.getId_room());
            preparedStatement.setDate(3, contracts.getLiving_start());
            preparedStatement.setDate(4, contracts.getLiving_end());
            preparedStatement.setInt(5, contracts.getId_reservation());

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
    public List<Contracts> getAll() throws SQLException {
        connection = DBConnection.getConnection();
        List<Contracts> list = new ArrayList<>();

        String sql = "SELECT * FROM contracts";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Contracts contracts = new Contracts();

                contracts.setContract_number(resultSet.getInt("contract_number"));
                contracts.setId_client(resultSet.getInt("id_client"));
                contracts.setId_room(resultSet.getInt("id_room"));
                contracts.setLiving_start(resultSet.getDate("living_start"));
                contracts.setLiving_end(resultSet.getDate("living_end"));
                contracts.setId_reservation(resultSet.getInt("id_reservation"));

                list.add(contracts);
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
    public Contracts getByContractNumber(Integer id) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM contracts WHERE contract_number=?";

        Contracts contracts = new Contracts();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            contracts.setContract_number(resultSet.getInt("contract_number"));
            contracts.setId_client(resultSet.getInt("id_client"));
            contracts.setId_room(resultSet.getInt("id_room"));
            contracts.setLiving_start(resultSet.getDate("living_start"));
            contracts.setLiving_end(resultSet.getDate("living_end"));
            contracts.setId_reservation(resultSet.getInt("id_reservation"));

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
        return contracts;
    }

    @Override
    public void update(Contracts contracts) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE contracts SET id_client=?, id_room=?,living_start=?, living_end=?,id_reservation=? WHERE contract_number=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, contracts.getId_client());
            preparedStatement.setInt(2, contracts.getId_room());
            preparedStatement.setDate(3, contracts.getLiving_start());
            preparedStatement.setDate(4, contracts.getLiving_end());
            preparedStatement.setInt(5, contracts.getId_reservation());
            preparedStatement.setInt(6, contracts.getContract_number());

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
    public void remove(Contracts contracts) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM contracts WHERE contract_number=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, contracts.getContract_number());

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
