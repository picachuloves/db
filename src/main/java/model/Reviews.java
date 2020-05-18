package model;

public class Reviews {
    private Integer id_client;
    private Integer id_room;
    private Integer mark;
    private String review;
    public Reviews(){}

    public Integer getId_client() {
        return id_client;
    }

    public void setId_client(Integer id_client) {
        this.id_client = id_client;
    }

    public Integer getId_room() {
        return id_room;
    }

    public void setId_room(Integer id_room) {
        this.id_room = id_room;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "id_client=" + id_client +
                ", id_room=" + id_room +
                ", mark=" + mark +
                ", review='" + review + '\'' +
                '}';
    }
}
