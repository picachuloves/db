package model;

import java.sql.Date;

public class Contracts {
    private Integer contract_number;
    private Integer id_client;
    private Integer id_room;
    private Date living_start;
    private Date living_end;
    private Integer id_reservation;
    public Contracts(){}

    public Integer getContract_number() {
        return contract_number;
    }

    public void setContract_number(Integer contract_number) {
        this.contract_number = contract_number;
    }

    public Integer getId_client() {
        return id_client;
    }

    public void setId_client(Integer id_client) {
        this.id_client = id_client;
    }

    public Integer getId_room() {
        return id_room;
    }

    public void setId_room(Integer id_room) {
        this.id_room = id_room;
    }

    public Date getLiving_start() {
        return living_start;
    }

    public void setLiving_start(Date living_start) {
        this.living_start = living_start;
    }

    public Date getLiving_end() {
        return living_end;
    }

    public void setLiving_end(Date living_end) {
        this.living_end = living_end;
    }

    public Integer getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(Integer id_reservation) {
        this.id_reservation = id_reservation;
    }

    @Override
    public String toString() {
        return "Contracts{" +
                "contract_number=" + contract_number +
                ", id_client=" + id_client +
                ", id_room=" + id_room +
                ", living_start=" + living_start +
                ", living_end=" + living_end +
                ", id_reservation=" + id_reservation +
                '}';
    }
}
