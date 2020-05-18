package model;

import java.math.BigDecimal;

public class Buildings {
    private Integer id;
    private Integer stars_number;
    private Integer floors_number;
    private Integer rooms_number;
    private Integer rooms_per_floor_number;
    private BigDecimal building_min_price;
    private Integer id_add_services;

    public Buildings(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStars_number() {
        return stars_number;
    }

    public void setStars_number(Integer stars_number) {
        this.stars_number = stars_number;
    }

    public Integer getFloors_number() {
        return floors_number;
    }

    public void setFloors_number(Integer floors_number) {
        this.floors_number = floors_number;
    }

    public Integer getRooms_number() {
        return rooms_number;
    }

    public void setRooms_number(Integer rooms_number) {
        this.rooms_number = rooms_number;
    }

    public Integer getRooms_per_floor_number() {
        return rooms_per_floor_number;
    }

    public void setRooms_per_floor_number(Integer rooms_per_floor_number) {
        this.rooms_per_floor_number = rooms_per_floor_number;
    }

    public BigDecimal getBuilding_min_price() {
        return building_min_price;
    }

    public void setBuilding_min_price(BigDecimal building_min_price) {
        this.building_min_price = building_min_price;
    }

    public Integer getId_add_services() {
        return id_add_services;
    }

    public void setId_add_services(Integer id_add_services) {
        this.id_add_services = id_add_services;
    }

    @Override
    public String toString() {
        return "Buildings{" +
                "id=" + id +
                ", stars_number=" + stars_number +
                ", floors_number=" + floors_number +
                ", rooms_number=" + rooms_number +
                ", rooms_per_floor_number=" + rooms_per_floor_number +
                ", building_min_price=" + building_min_price +
                ", id_add_services=" + id_add_services +
                '}';
    }
}
