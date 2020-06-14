package repository;


import model.ResClients;

import java.sql.SQLException;
import java.util.List;

public interface ResClientsRepos {
    //create
    void add(ResClients resClients) throws SQLException;

    //read
    List<ResClients> getAll() throws SQLException;

    ResClients getByIdClient(Integer id) throws SQLException;
    ResClients getByIdReservation(Integer id) throws SQLException;

    //update by id
    void updateByIdClient(ResClients resClients) throws SQLException;
    void updateByIdReservation(ResClients resClients) throws SQLException;
    void update(ResClients before, ResClients after) throws SQLException;

    //delete by id
    void removeByIdClient(ResClients resClients) throws SQLException;
    void removeByIdReservation(ResClients resClients) throws SQLException;
    void remove(ResClients resClients) throws SQLException;
}
