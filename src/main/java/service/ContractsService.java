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
            if(contracts.getId_reservation()!=0)
            {
                preparedStatement.setInt(5, contracts.getId_reservation());
                createRes(contracts.getId_client(), contracts.getId_room(), contracts.getId_reservation());
            }else
            {
                preparedStatement.setNull(5, Types.INTEGER);
            }

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

    private void createRes(int id_client, int id_room, int id_reservation) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;

        String res_rooms = "INSERT INTO res_rooms values(?,?);";
        String res_clients = "INSERT INTO res_clients values(?,?);";
        try {
            connection.setAutoCommit(false);
            preparedStatement1 = connection.prepareStatement(res_rooms);
            preparedStatement1.setInt(1, id_room);
            preparedStatement1.setInt(2, id_reservation);


            int affectedRows = preparedStatement1.executeUpdate();

            if (affectedRows > 0) {
                preparedStatement2 = connection.prepareStatement(res_clients);
                preparedStatement2.setInt(1, id_client);
                preparedStatement2.setInt(2, id_reservation);
                preparedStatement2.executeUpdate();
            } else {
                connection.rollback();
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement1 != null) {
                preparedStatement1.close();
            }
            if (preparedStatement2 != null) {
                preparedStatement2.close();
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
            if(resultSet.next()) {
                contracts.setContract_number(resultSet.getInt("contract_number"));
                contracts.setId_client(resultSet.getInt("id_client"));
                contracts.setId_room(resultSet.getInt("id_room"));
                contracts.setLiving_start(resultSet.getDate("living_start"));
                contracts.setLiving_end(resultSet.getDate("living_end"));
                contracts.setId_reservation(resultSet.getInt("id_reservation"));
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

    public List<Contracts> getWillFreeByDate(Date date) throws SQLException{
        connection = DBConnection.getConnection();
        List<Contracts> list = new ArrayList<>();

        String sql = "select * from contracts where living_start<current_date and living_end>current_date and living_end<?;";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, date);

            ResultSet resultSet = preparedStatement.executeQuery();

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
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return list;
    }
}
