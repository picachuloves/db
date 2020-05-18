package repository;


import model.Contracts;

import java.sql.SQLException;
import java.util.List;

public interface ContractsRepos {
    //create
    void add(Contracts contracts) throws SQLException;

    //read
    List<Contracts> getAll() throws SQLException;

    Contracts getByContractNumber(Integer id) throws SQLException;

    //update by id
    void update(Contracts contracts) throws SQLException;

    //delete by id
    void remove(Contracts contracts) throws SQLException;
}
