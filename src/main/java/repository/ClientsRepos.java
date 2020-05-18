package repository;


import model.Clients;

import java.sql.SQLException;
import java.util.List;

public interface ClientsRepos {
    //create
    void add(Clients clients) throws SQLException;

    //read
    List<Clients> getAll() throws SQLException;

    Clients getById(Integer id) throws SQLException;

    //update by id
    void update(Clients clients) throws SQLException;

    //delete by id
    void remove(Clients clients) throws SQLException;

    void removeAll() throws SQLException;


}
