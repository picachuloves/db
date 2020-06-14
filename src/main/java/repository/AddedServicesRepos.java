package repository;


import model.AddedServices;

import java.sql.SQLException;
import java.util.List;

public interface AddedServicesRepos {
    //create
    void add(AddedServices addedServices) throws SQLException;

    //read
    List<AddedServices> getAll() throws SQLException;

    AddedServices getById(Integer id) throws SQLException;

    //update by id
    void updateById(AddedServices addedServices) throws SQLException;

    //delete by id
    void removeById(AddedServices addedServices) throws SQLException;
}
