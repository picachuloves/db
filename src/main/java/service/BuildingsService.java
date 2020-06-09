package service;


import connection.DBConnection;
import model.Buildings;
import repository.BuildingsRepos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuildingsService implements BuildingsRepos {
    private Connection connection;
    @Override
    public void add(Buildings buildings) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO buildings(stars_number, floors_number, rooms_per_floor_number, rooms_number, building_min_price, id_add_services) values(?,?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, buildings.getStars_number());
            preparedStatement.setInt(2, buildings.getFloors_number());
            preparedStatement.setInt(3, buildings.getRooms_number());
            preparedStatement.setInt(4, buildings.getRooms_per_floor_number());
            preparedStatement.setBigDecimal(5, buildings.getBuilding_min_price());
            preparedStatement.setInt(6, buildings.getId_add_services());

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
    public List<Buildings> getAll() throws SQLException {
        connection = DBConnection.getConnection();
        List<Buildings> list = new ArrayList<>();

        String sql = "SELECT * FROM buildings";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Buildings buildings = new Buildings();

                buildings.setId(resultSet.getInt("id"));
                buildings.setStars_number(resultSet.getInt("stars_number"));
                buildings.setFloors_number(resultSet.getInt("floors_number"));
                buildings.setRooms_number(resultSet.getInt("rooms_number"));
                buildings.setRooms_per_floor_number(resultSet.getInt("rooms_per_floor_number"));
                buildings.setBuilding_min_price(resultSet.getBigDecimal("building_min_price"));
                buildings.setId_add_services(resultSet.getInt("id_add_services"));

                list.add(buildings);
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
    public Buildings getById(Integer id) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM buildings WHERE id=?";

        Buildings buildings = new Buildings();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                buildings.setId(resultSet.getInt("id"));
                buildings.setStars_number(resultSet.getInt("stars_number"));
                buildings.setFloors_number(resultSet.getInt("floors_number"));
                buildings.setRooms_number(resultSet.getInt("rooms_number"));
                buildings.setRooms_per_floor_number(resultSet.getInt("rooms_per_floor_number"));
                buildings.setBuilding_min_price(resultSet.getBigDecimal("building_min_price"));
                buildings.setId_add_services(resultSet.getInt("id_add_services"));
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
        return buildings;
    }

    @Override
    public void update(Buildings buildings) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE buildings SET stars_number=?, floors_number=?, rooms_number=?, rooms_per_floor_number=?, building_min_price=?, id_add_services=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, buildings.getStars_number());
            preparedStatement.setInt(2, buildings.getFloors_number());
            preparedStatement.setInt(3, buildings.getRooms_number());
            preparedStatement.setInt(4, buildings.getRooms_per_floor_number());
            preparedStatement.setBigDecimal(5, buildings.getBuilding_min_price());
            preparedStatement.setInt(6, buildings.getId_add_services());
            preparedStatement.setInt(7, buildings.getId());

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
    public void remove(Buildings buildings) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM buildings WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, buildings.getId());

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
