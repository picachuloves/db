package service;


import connection.DBConnection;
import model.RoomTypes;
import repository.RoomTypesRepos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomTypesService implements RoomTypesRepos {
    private Connection connection = DBConnection.getConnection();
    @Override
    public void add(RoomTypes roomTypes) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price values(?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, roomTypes.getFloor());
            preparedStatement.setInt(2, roomTypes.getPeople_number());
            preparedStatement.setBigDecimal(3, roomTypes.getService_cost_per_day());
            preparedStatement.setBigDecimal(4, roomTypes.getMin_price());

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
    public List<RoomTypes> getAll() throws SQLException {
        List<RoomTypes> list = new ArrayList<>();

        String sql = "SELECT * FROM room_types";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                RoomTypes roomTypes = new RoomTypes();

                roomTypes.setId(resultSet.getInt("id"));
                roomTypes.setFloor(resultSet.getInt("floor"));
                roomTypes.setPeople_number(resultSet.getInt("people_number"));
                roomTypes.setService_cost_per_day(resultSet.getBigDecimal("service_cost_per_day"));
                roomTypes.setMin_price(resultSet.getBigDecimal("min_price"));

                list.add(roomTypes);
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
    public RoomTypes getById(Integer id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM room_types WHERE id=?";

        RoomTypes roomTypes = new RoomTypes();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            roomTypes.setId(resultSet.getInt("id"));
            roomTypes.setFloor(resultSet.getInt("floor"));
            roomTypes.setPeople_number(resultSet.getInt("people_number"));
            roomTypes.setService_cost_per_day(resultSet.getBigDecimal("service_cost_per_day"));
            roomTypes.setMin_price(resultSet.getBigDecimal("min_price"));

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
        return roomTypes;
    }

    @Override
    public void update(RoomTypes roomTypes) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE room_types SET floor=?, people_number=?, service_cost_per_day=?, min_price=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, roomTypes.getFloor());
            preparedStatement.setInt(2, roomTypes.getPeople_number());
            preparedStatement.setBigDecimal(3, roomTypes.getService_cost_per_day());
            preparedStatement.setBigDecimal(4, roomTypes.getMin_price());
            preparedStatement.setInt(5, roomTypes.getId());

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
    public void remove(RoomTypes roomTypes) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM room_types WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, roomTypes.getId());

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
