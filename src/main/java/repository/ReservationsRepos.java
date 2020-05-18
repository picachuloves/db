package repository;


import model.Reservations;

import java.sql.SQLException;
import java.util.List;

public interface ReservationsRepos {
    //create
    void add(Reservations reservations) throws SQLException;

    //read
    List<Reservations> getAll() throws SQLException;

    Reservations getById(Integer id) throws SQLException;

    //update by id
    void update(Reservations reservations) throws SQLException;

    //delete by id
    void remove(Reservations reservations) throws SQLException;
}
