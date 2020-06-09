package service;



import connection.DBConnection;
import model.Reviews;
import repository.ReviewsRepos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewsService implements ReviewsRepos {
    private Connection connection;
    @Override
    public void add(Reviews reviews) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO reviews values(?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, reviews.getId_client());
            preparedStatement.setInt(2, reviews.getId_room());
            preparedStatement.setInt(3, reviews.getMark());
            preparedStatement.setString(4, reviews.getReview());

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
    public List<Reviews> getAll() throws SQLException {
        connection = DBConnection.getConnection();
        List<Reviews> list = new ArrayList<>();

        String sql = "SELECT * FROM reviews";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Reviews reviews = new Reviews();

                reviews.setId_client(resultSet.getInt("id_client"));
                reviews.setId_room(resultSet.getInt("id_room"));
                reviews.setMark(resultSet.getInt("mark"));
                reviews.setReview(resultSet.getString("review"));

                list.add(reviews);
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
    public Reviews getByIdClient(Integer id) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM reviews WHERE id_client=?";

        Reviews reviews = new Reviews();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                reviews.setId_client(resultSet.getInt("id_client"));
                reviews.setId_room(resultSet.getInt("id_room"));
                reviews.setMark(resultSet.getInt("mark"));
                reviews.setReview(resultSet.getString("review"));
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
        return reviews;
    }

    @Override
    public Reviews getByIdRoom(Integer id) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM reviews WHERE id_room=?";

        Reviews reviews = new Reviews();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                reviews.setId_client(resultSet.getInt("id_client"));
                reviews.setId_room(resultSet.getInt("id_room"));
                reviews.setMark(resultSet.getInt("mark"));
                reviews.setReview(resultSet.getString("review"));
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
        return reviews;
    }

    @Override
    public void updateByIdClient(Reviews reviews) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE reviews SET id_room=?, mark=?, review=? WHERE id_client=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, reviews.getId_room());
            preparedStatement.setInt(2, reviews.getMark());
            preparedStatement.setString(3, reviews.getReview());
            preparedStatement.setInt(4, reviews.getId_client());

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
    public void updateByIdRoom(Reviews reviews) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE reviews SET id_client=?, mark=?, review=? WHERE id_room=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, reviews.getId_client());
            preparedStatement.setInt(2, reviews.getMark());
            preparedStatement.setString(3, reviews.getReview());
            preparedStatement.setInt(4, reviews.getId_room());

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
    public void removeByIdClient(Reviews reviews) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM reviews WHERE id_client=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, reviews.getId_client());

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
    public void removeByIdRoom(Reviews reviews) throws SQLException {
        connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM reviews WHERE id_room=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, reviews.getId_room());

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
