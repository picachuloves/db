package service;


import connection.DBConnection;
import model.ResRooms;
import repository.ResRoomsRepos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResRoomsService implements ResRoomsRepos {
    private Connection connection;
    @Override
    public void add(ResRooms resRooms) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO res_rooms values(?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, resRooms.getId_room());
            preparedStatement.setInt(2, resRooms.getId_reservation());

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
    public List<ResRooms> getAll() throws SQLException {
        connection = DBConnection.getConnection();
        List<ResRooms> list = new ArrayList<>();

        String sql = "SELECT * FROM res_rooms";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                ResRooms resRooms = new ResRooms();

                resRooms.setId_room(resultSet.getInt("id_room"));
                resRooms.setId_reservation(resultSet.getInt("id_reservation"));

                list.add(resRooms);
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
    public ResRooms getByIdRoom(Integer id) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM res_rooms WHERE id_room=?";

        ResRooms resRooms = new ResRooms();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resRooms.setId_room(resultSet.getInt("id_room"));
            resRooms.setId_reservation(resultSet.getInt("id_reservation"));

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
        return resRooms;
    }

    @Override
    public ResRooms getByIdReservation(Integer id) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM res_rooms WHERE id_reservation=?";

        ResRooms resRooms = new ResRooms();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resRooms.setId_room(resultSet.getInt("id_room"));
            resRooms.setId_reservation(resultSet.getInt("id_reservation"));

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
        return resRooms;
    }

    @Override
    public void updateByIdRoom(ResRooms resRooms) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE res_rooms SET id_reservation=? WHERE id_room=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, resRooms.getId_reservation());
            preparedStatement.setInt(2, resRooms.getId_room());

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
    public void updateByIdReservation(ResRooms resRooms) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE res_rooms SET id_room=? WHERE id_reservation=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, resRooms.getId_room());
            preparedStatement.setInt(2, resRooms.getId_reservation());

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
    public void removeByIdRoom(ResRooms resRooms) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM res_rooms WHERE id_room=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, resRooms.getId_room());

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
    public void removeByIdReservation(ResRooms resRooms) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM res_rooms WHERE id_reservation=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, resRooms.getId_reservation());

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
