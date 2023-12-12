package project.models;

public class Price {
    private int price_id;
    private int horse_id;
    private int race_id;
    private int time;
    private int price;

    public Price(int price_id, int horse_id, int race_id, int time, int price) {
        this.price_id = price_id;
        this.horse_id = horse_id;
        this.race_id = race_id;
        this.time = time;
        this.price = price;
    }

    public int getPrice_id() {
        return price_id;
    }

    public void setPrice_id(int price_id) {
        this.price_id = price_id;
    }

    public int getHorse_id() {
        return horse_id;
    }

    public void setHorse_id(int horse_id) {
        this.horse_id = horse_id;
    }

    public int getRace_id() {
        return race_id;
    }

    public void setRace_id(int race_id) {
        this.race_id = race_id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
