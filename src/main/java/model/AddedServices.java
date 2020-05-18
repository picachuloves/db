package model;

import java.math.BigDecimal;

public class AddedServices {
    private Integer id;
    private Integer bill_number;
    private String add_service;
    private BigDecimal service_bill;
    public AddedServices(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBill_number() {
        return bill_number;
    }

    public void setBill_number(Integer bill_number) {
        this.bill_number = bill_number;
    }

    public String getAdd_service() {
        return add_service;
    }

    public void setAdd_service(String add_service) {
        this.add_service = add_service;
    }

    public BigDecimal getService_bill() {
        return service_bill;
    }

    public void setService_bill(BigDecimal service_bill) {
        this.service_bill = service_bill;
    }

    @Override
    public String toString() {
        return "AddedServices{" +
                "id=" + id +
                ", bill_number=" + bill_number +
                ", add_service='" + add_service + '\'' +
                ", service_bill=" + service_bill +
                '}';
    }
}
