package model;

public class Clients {
    private Integer id;
    private String fio;
    private String phone_number;
    public Clients(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
