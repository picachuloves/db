package repository;

import model.Partners;

import java.sql.SQLException;
import java.util.List;

public interface PartnersRepos {
    //create
    void add(Partners partners) throws SQLException;

    //read
    List<Partners> getAll() throws SQLException;

    Partners getByContractNumber(Integer number) throws SQLException;

    //update by id
    void update(Partners partners) throws SQLException;

    //delete by id
    void remove(Partners partners) throws SQLException;
}
