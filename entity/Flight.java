package entity;

import java.sql.Time;

public class Flight {
    private String id;
    private String from;
    private String to;
    private int lengthFlight;
    private Time ourGo;
    private Time ourCome;
    private int cost;

    public Flight() {
    }

    public Flight(String id, String from, String to, int lengthFlight, Time ourGo, Time ourCome, int cost) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.lengthFlight = lengthFlight;
        this.ourGo = ourGo;
        this.ourCome = ourCome;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getLengthFlight() {
        return lengthFlight;
    }

    public void setLengthFlight(int lengthFlight) {
        this.lengthFlight = lengthFlight;
    }

    public Time getOurGo() {
        return ourGo;
    }

    public void setOurGo(Time ourGo) {
        this.ourGo = ourGo;
    }

    public Time getOurCome() {
        return ourCome;
    }

    public void setOurCome(Time ourCome) {
        this.ourCome = ourCome;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id='" + id + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", lengthFlight=" + lengthFlight +
                ", ourGo=" + ourGo +
                ", ourCome=" + ourCome +
                ", cost=" + cost +
                '}';
    }
}
