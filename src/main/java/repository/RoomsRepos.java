package repository;

import model.Rooms;

import java.sql.SQLException;
import java.util.List;

public interface RoomsRepos {
    //create
    void add(Rooms rooms) throws SQLException;

    //read
    List<Rooms> getAll() throws SQLException;

    Rooms getById(Integer id) throws SQLException;

    //update by id
    void update(Rooms rooms) throws SQLException;

    //delete by id
    void remove(Rooms rooms) throws SQLException;
}
