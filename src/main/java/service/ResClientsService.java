package service;

import connection.DBConnection;
import model.ResClients;
import repository.ResClientsRepos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResClientsService implements ResClientsRepos {
    private Connection connection;
    @Override
    public void add(ResClients resClients) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO res_clients values(?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, resClients.getId_client());
            preparedStatement.setInt(2, resClients.getId_reservation());

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
    public List<ResClients> getAll() throws SQLException {
        connection = DBConnection.getConnection();
        List<ResClients> list = new ArrayList<>();

        String sql = "SELECT * FROM res_clients";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                ResClients resClients = new ResClients();

                resClients.setId_client(resultSet.getInt("id_client"));
                resClients.setId_reservation(resultSet.getInt("id_reservation"));

                list.add(resClients);
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
    public ResClients getByIdClient(Integer id) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM res_clients WHERE id_client=?";

        ResClients resClients = new ResClients();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                resClients.setId_client(resultSet.getInt("id_client"));
                resClients.setId_reservation(resultSet.getInt("id_reservation"));
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
        return resClients;
    }

    @Override
    public ResClients getByIdReservation(Integer id) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM res_clients WHERE id_reservation=?";

        ResClients resClients = new ResClients();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                resClients.setId_client(resultSet.getInt("id_client"));
                resClients.setId_reservation(resultSet.getInt("id_reservation"));
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
        return resClients;
    }

    @Override
    public void updateByIdClient(ResClients resClients) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE res_clients SET id_reservation=? WHERE id_client=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, resClients.getId_reservation());
            preparedStatement.setInt(2, resClients.getId_client());

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
    public void updateByIdReservation(ResClients resClients) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE res_clients SET id_client=? WHERE id_reservation=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, resClients.getId_client());
            preparedStatement.setInt(2, resClients.getId_reservation());

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
    public void update(ResClients before, ResClients after) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE res_clients SET id_client=?, id_reservation=? WHERE id_reservation=? AND id_client=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, after.getId_client());
            preparedStatement.setInt(2, after.getId_reservation());
            preparedStatement.setInt(3, before.getId_reservation());
            preparedStatement.setInt(4, before.getId_client());
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
    public void removeByIdClient(ResClients resClients) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM res_clients WHERE id_client=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, resClients.getId_client());

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
    public void removeByIdReservation(ResClients resClients) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM res_clients WHERE id_reservation=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, resClients.getId_reservation());

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
    public void remove(ResClients resClients) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM res_clients WHERE id_reservation=?, id_client=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, resClients.getId_reservation());
            preparedStatement.setInt(1, resClients.getId_client());
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
