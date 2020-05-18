package model;

public class ResRooms {
    private Integer id_room;
    private Integer id_reservation;
    public ResRooms(){}

    public Integer getId_room() {
        return id_room;
    }

    public void setId_room(Integer id_room) {
        this.id_room = id_room;
    }

    public Integer getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(Integer id_reservation) {
        this.id_reservation = id_reservation;
    }

    @Override
    public String toString() {
        return "ResRooms{" +
                "id_room=" + id_room +
                ", id_reservation=" + id_reservation +
                '}';
    }
}
