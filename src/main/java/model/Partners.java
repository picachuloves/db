package model;

import java.sql.Date;

public class Partners {
    private Integer contract_number;
    private String information;
    private Date cooperation_date_start;
    private Date cooperation_date_end;
    public Partners(){}

    public Integer getContract_number() {
        return contract_number;
    }

    public void setContract_number(Integer contract_number) {
        this.contract_number = contract_number;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Date getCooperation_date_start() {
        return cooperation_date_start;
    }

    public void setCooperation_date_start(Date cooperation_date_start) {
        this.cooperation_date_start = cooperation_date_start;
    }

    public Date getCooperation_date_end() {
        return cooperation_date_end;
    }

    public void setCooperation_date_end(Date cooperation_date_end) {
        this.cooperation_date_end = cooperation_date_end;
    }

    @Override
    public String toString() {
        return "Partners{" +
                "contract_number=" + contract_number +
                ", information='" + information + '\'' +
                ", cooperation_date_start=" + cooperation_date_start +
                ", cooperation_date_end=" + cooperation_date_end +
                '}';
    }
}
