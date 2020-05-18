package repository;

import model.RoomTypes;

import java.sql.SQLException;
import java.util.List;

public interface RoomTypesRepos {
    //create
    void add(RoomTypes roomTypes) throws SQLException;

    //read
    List<RoomTypes> getAll() throws SQLException;

    RoomTypes getById(Integer id) throws SQLException;

    //update by id
    void update(RoomTypes roomTypes) throws SQLException;

    //delete by id
    void remove(RoomTypes roomTypes) throws SQLException;
}
