package model;

import java.math.BigDecimal;

public class AddServices {
    private Integer id;
    private String services;
    private BigDecimal services_allowance;
    private String food;
    private BigDecimal food_allowance;
    private String entertainments;
    private BigDecimal entertainments_allowance;

    public AddServices(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public BigDecimal getServices_allowance() {
        return services_allowance;
    }

    public void setServices_allowance(BigDecimal services_allowance) {
        this.services_allowance = services_allowance;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public BigDecimal getFood_allowance() {
        return food_allowance;
    }

    public void setFood_allowance(BigDecimal food_allowance) {
        this.food_allowance = food_allowance;
    }

    public String getEntertainments() {
        return entertainments;
    }

    public void setEntertainments(String entertainments) {
        this.entertainments = entertainments;
    }

    public BigDecimal getEntertainments_allowance() {
        return entertainments_allowance;
    }

    public void setEntertainments_allowance(BigDecimal entertainments_allowance) {
        this.entertainments_allowance = entertainments_allowance;
    }

    @Override
    public String toString() {
        return "AddServices{" +
                "id=" + id +
                ", services='" + services + '\'' +
                ", services_allowance=" + services_allowance +
                ", food='" + food + '\'' +
                ", food_allowance=" + food_allowance +
                ", entertainments='" + entertainments + '\'' +
                ", entertainments_allowance=" + entertainments_allowance +
                '}';
    }
}
