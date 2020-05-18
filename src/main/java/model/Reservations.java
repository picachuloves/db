package model;

import java.sql.Date;

public class Reservations {
    private Integer id;
    private Integer res_partner;
    private Integer stars_number;
    private Integer floor_number;
    private Date res_date_start;
    private Date res_date_end;
    private Integer discount;

    public Reservations(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRes_partner() {
        return res_partner;
    }

    public void setRes_partner(Integer res_partner) {
        this.res_partner = res_partner;
    }

    public Integer getStars_number() {
        return stars_number;
    }

    public void setStars_number(Integer stars_number) {
        this.stars_number = stars_number;
    }

    public Integer getFloor_number() {
        return floor_number;
    }

    public void setFloor_number(Integer floor_number) {
        this.floor_number = floor_number;
    }

    public Date getRes_date_start() {
        return res_date_start;
    }

    public void setRes_date_start(Date res_date_start) {
        this.res_date_start = res_date_start;
    }

    public Date getRes_date_end() {
        return res_date_end;
    }

    public void setRes_date_end(Date res_date_end) {
        this.res_date_end = res_date_end;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Reservations{" +
                "id=" + id +
                ", res_partner=" + res_partner +
                ", stars_number=" + stars_number +
                ", floor_number=" + floor_number +
                ", res_date_start=" + res_date_start +
                ", res_date_end=" + res_date_end +
                ", discount=" + discount +
                '}';
    }
}
