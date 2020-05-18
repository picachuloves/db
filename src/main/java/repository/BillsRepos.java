package repository;


import model.Bills;

import java.sql.SQLException;
import java.util.List;

public interface BillsRepos {
    //create
    void add(Bills bills) throws SQLException;

    //read
    List<Bills> getAll() throws SQLException;

    Bills getByBillNumber(Integer id) throws SQLException;

    //update by id
    void update(Bills bills) throws SQLException;

    //delete by id
    void remove(Bills bills) throws SQLException;
}
