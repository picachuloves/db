package repository;

import model.AddServices;

import java.sql.SQLException;
import java.util.List;

public interface AddServicesRepos {
    //create
    void add(AddServices address) throws SQLException;

    //read
    List<AddServices> getAll() throws SQLException;

    AddServices getById(Integer id) throws SQLException;

    //update by id
    void update(AddServices address) throws SQLException;

    //delete by id
    void remove(AddServices address) throws SQLException;
}
