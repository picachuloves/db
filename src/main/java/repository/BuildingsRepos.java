package repository;

import model.Buildings;

import java.sql.SQLException;
import java.util.List;

public interface BuildingsRepos {
    //create
    void add(Buildings buildings) throws SQLException;

    //read
    List<Buildings> getAll() throws SQLException;

    Buildings getById(Integer id) throws SQLException;

    //update by id
    void update(Buildings buildings) throws SQLException;

    //delete by id
    void remove(Buildings buildings) throws SQLException;
}
