package model;

public class Rooms {
    private Integer id;
    private Integer id_building;
    private Integer id_room_types;
    public Rooms(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_building() {
        return id_building;
    }

    public void setId_building(Integer id_building) {
        this.id_building = id_building;
    }

    public Integer getId_room_types() {
        return id_room_types;
    }

    public void setId_room_types(Integer id_room_types) {
        this.id_room_types = id_room_types;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "id=" + id +
                ", id_building=" + id_building +
                ", id_room_types=" + id_room_types +
                '}';
    }
}
