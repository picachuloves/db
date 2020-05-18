package repository;

import model.Reviews;

import java.sql.SQLException;
import java.util.List;

public interface ReviewsRepos {
    //create
    void add(Reviews reviews) throws SQLException;

    //read
    List<Reviews> getAll() throws SQLException;

    Reviews getByIdClient(Integer id) throws SQLException;
    Reviews getByIdRoom(Integer id) throws SQLException;

    //update by id
    void updateByIdClient(Reviews reviews) throws SQLException;
    void updateByIdRoom(Reviews reviews) throws SQLException;

    //delete by id
    void removeByIdClient(Reviews reviews) throws SQLException;
    void removeByIdRoom(Reviews reviews) throws SQLException;
}
