package model;

import java.math.BigDecimal;

public class RoomTypes {
    private Integer id;
    private Integer floor;
    private Integer people_number;
    private BigDecimal service_cost_per_day;
    private BigDecimal min_price;

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public RoomTypes(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPeople_number() {
        return people_number;
    }

    public void setPeople_number(Integer people_number) {
        this.people_number = people_number;
    }

    public BigDecimal getService_cost_per_day() {
        return service_cost_per_day;
    }

    public void setService_cost_per_day(BigDecimal service_cost_per_day) {
        this.service_cost_per_day = service_cost_per_day;
    }

    public BigDecimal getMin_price() {
        return min_price;
    }

    public void setMin_price(BigDecimal min_price) {
        this.min_price = min_price;
    }

    @Override
    public String toString() {
        return "RoomTypes{" +
                "id=" + id +
                ", floor=" + floor +
                ", people_number=" + people_number +
                ", service_cost_per_day=" + service_cost_per_day +
                ", min_price=" + min_price +
                '}';
    }
}
