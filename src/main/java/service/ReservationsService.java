package service;

import connection.DBConnection;
import model.Reservations;
import repository.ReservationsRepos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationsService implements ReservationsRepos {
    private Connection connection;
    @Override
    public void add(Reservations reservations) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO reservations(res_partner, stars_number, floor_number, res_date_start, res_date_end, discount) values(?,?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, reservations.getRes_partner());
            preparedStatement.setInt(2, reservations.getStars_number());
            preparedStatement.setInt(3, reservations.getFloor_number());
            preparedStatement.setDate(4, reservations.getRes_date_start());
            preparedStatement.setDate(5, reservations.getRes_date_end());
            preparedStatement.setInt(6, reservations.getDiscount());

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
    public List<Reservations> getAll() throws SQLException {
        connection = DBConnection.getConnection();
        List<Reservations> list = new ArrayList<>();

        String sql = "SELECT * FROM reservations";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Reservations reservations = new Reservations();
                reservations.setId(resultSet.getInt("id"));
                reservations.setRes_partner(resultSet.getInt("res_partner"));
                reservations.setStars_number(resultSet.getInt("stars_number"));
                reservations.setFloor_number(resultSet.getInt("floor_number"));
                reservations.setRes_date_start(resultSet.getDate("res_date_start"));
                reservations.setRes_date_end(resultSet.getDate("res_date_end"));
                reservations.setDiscount(resultSet.getInt("discount"));

                list.add(reservations);
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
    public Reservations getById(Integer id) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM reservations WHERE id=?";

        Reservations reservations = new Reservations();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                reservations.setId(resultSet.getInt("id"));
                reservations.setRes_partner(resultSet.getInt("res_partner"));
                reservations.setStars_number(resultSet.getInt("stars_number"));
                reservations.setFloor_number(resultSet.getInt("floor_number"));
                reservations.setRes_date_start(resultSet.getDate("res_date_start"));
                reservations.setRes_date_end(resultSet.getDate("res_date_end"));
                reservations.setDiscount(resultSet.getInt("discount"));
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
        return reservations;
    }

    @Override
    public void update(Reservations reservations) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE reservations SET res_partner=?, stars_number=?, floor_number=?, res_date_start=?, res_date_end=?, discount=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, reservations.getRes_partner());
            preparedStatement.setInt(2, reservations.getStars_number());
            preparedStatement.setInt(3, reservations.getFloor_number());
            preparedStatement.setDate(4, reservations.getRes_date_start());
            preparedStatement.setDate(5, reservations.getRes_date_end());
            preparedStatement.setInt(6, reservations.getDiscount());
            preparedStatement.setInt(7, reservations.getId());

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
    public void remove(Reservations reservations) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM reservations WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, reservations.getId());

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

    public List<Reservations> getAvailableRes() throws SQLException{
        connection = DBConnection.getConnection();
        List<Reservations> list = new ArrayList<>();

        String sql = "select * from reservations where reservations.id not in(select reservations.id from reservations where res_date_end < current_date);";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Reservations reservations = new Reservations();
                reservations.setId(resultSet.getInt("id"));
                reservations.setRes_partner(resultSet.getInt("res_partner"));
                reservations.setStars_number(resultSet.getInt("stars_number"));
                reservations.setFloor_number(resultSet.getInt("floor_number"));
                reservations.setRes_date_start(resultSet.getDate("res_date_start"));
                reservations.setRes_date_end(resultSet.getDate("res_date_end"));
                reservations.setDiscount(resultSet.getInt("discount"));

                list.add(reservations);
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
}
