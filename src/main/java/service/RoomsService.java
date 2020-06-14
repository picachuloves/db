package service;


import connection.DBConnection;
import model.Rooms;
import repository.RoomsRepos;

import java.math.BigDecimal;
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
                rooms.setId(resultSet.getInt("id"));
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
            if(resultSet.next()) {
                rooms.setId_building(resultSet.getInt("id_building"));
                rooms.setId_room_types(resultSet.getInt("id_room_types"));
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

    public List<Rooms> getFreeRooms() throws SQLException{
        connection = DBConnection.getConnection();
        List<Rooms> list = new ArrayList<>();

        String sql = "select * from rooms where rooms.id not in (select rooms.id from rooms inner join contracts on contracts.contract_number=rooms.id where living_start<current_date and living_end>current_date)";


        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Rooms rooms = new Rooms();
                rooms.setId(resultSet.getInt("id"));
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
    public List<Rooms> getFreeRooms(int people_number, BigDecimal service_cost_per_day, BigDecimal min_price) throws SQLException {
        connection = DBConnection.getConnection();
        List<Rooms> list = new ArrayList<>();

        String sql = "select * from rooms inner join room_types on rooms.id_room_types=room_types.id where rooms.id not in (select rooms.id from rooms inner join contracts on contracts.contract_number=rooms.id where living_start<current_date and living_end>current_date) and people_number>? and service_cost_per_day>? and min_price>?";


        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, people_number);
            preparedStatement.setBigDecimal(2, service_cost_per_day);
            preparedStatement.setBigDecimal(3, min_price);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Rooms rooms = new Rooms();
                rooms.setId(resultSet.getInt("id"));
                rooms.setId_building(resultSet.getInt("id_building"));
                rooms.setId_room_types(resultSet.getInt("id_room_types"));

                list.add(rooms);
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
    public int getReservedRoomsCount() throws SQLException {
        connection = DBConnection.getConnection();
        int count = 0;
        String sql = "select count(distinct id_room) from reservations inner join res_rooms on reservations.id=res_rooms.id_reservation";
        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                count = resultSet.getInt("count");
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
        return count;
    }
}
