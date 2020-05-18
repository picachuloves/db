package service;


import connection.DBConnection;
import model.Rooms;
import repository.RoomsRepos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomsService implements RoomsRepos {
    private Connection connection;
    @Override
    public void add(Rooms rooms) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO rooms(id_building, id_room_types) values(?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, rooms.getId_building());
            preparedStatement.setInt(2, rooms.getId_room_types());

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
    public List<Rooms> getAll() throws SQLException {
        connection = DBConnection.getConnection();
        List<Rooms> list = new ArrayList<>();

        String sql = "SELECT * FROM rooms";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Rooms rooms = new Rooms();

                rooms.setId_building(resultSet.getInt("id_building"));
                rooms.setId_room_types(resultSet.getInt("id_room_types"));

                list.add(rooms);
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
    public Rooms getById(Integer id) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM rooms WHERE id=?";

        Rooms rooms = new Rooms();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            rooms.setId_building(resultSet.getInt("id_building"));
            rooms.setId_room_types(resultSet.getInt("id_room_types"));

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
        return rooms;
    }

    @Override
    public void update(Rooms rooms) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE rooms SET id_building=?, id_room_types=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, rooms.getId_building());
            preparedStatement.setInt(2, rooms.getId_room_types());
            preparedStatement.setInt(3, rooms.getId());

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
    public void remove(Rooms rooms) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM rooms WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, rooms.getId());

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
