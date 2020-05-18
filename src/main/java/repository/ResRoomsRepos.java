package repository;


import model.ResRooms;

import java.sql.SQLException;
import java.util.List;

public interface ResRoomsRepos {
    //create
    void add(ResRooms resRooms) throws SQLException;

    //read
    List<ResRooms> getAll() throws SQLException;

    ResRooms getByIdRoom(Integer id) throws SQLException;
    ResRooms getByIdReservation(Integer id) throws SQLException;

    //update by id
    void updateByIdRoom(ResRooms resRooms) throws SQLException;
    void updateByIdReservation(ResRooms resRooms) throws SQLException;

    //delete by id
    void removeByIdRoom(ResRooms resRooms) throws SQLException;
    void removeByIdReservation(ResRooms resRooms) throws SQLException;
}
