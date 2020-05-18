package model;

import java.math.BigDecimal;

public class Bills {
    private Integer bill_number;
    private Integer id_contract;
    private BigDecimal bill;
    public Bills(){}

    public Integer getBill_number() {
        return bill_number;
    }

    public void setBill_number(Integer bill_number) {
        this.bill_number = bill_number;
    }

    public Integer getId_contract() {
        return id_contract;
    }

    public void setId_contract(Integer id_contract) {
        this.id_contract = id_contract;
    }

    public BigDecimal getBill() {
        return bill;
    }

    public void setBill(BigDecimal bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Bills{" +
                "bill_number=" + bill_number +
                ", id_contract=" + id_contract +
                ", bill=" + bill +
                '}';
    }
}
