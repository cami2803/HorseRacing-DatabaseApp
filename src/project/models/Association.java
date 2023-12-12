package project.models;

public class Association {
    private int horse_id;
    private int race_id;
    private int jockey_id;
    private int starting_price;
    private int final_position;

    public Association(int horse_id, int race_id, int jockey_id, int starting_price, int final_position) {
        this.horse_id = horse_id;
        this.race_id = race_id;
        this.jockey_id = jockey_id;
        this.starting_price = starting_price;
        this.final_position = final_position;
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

    public int getJockey_id() {
        return jockey_id;
    }

    public void setJockey_id(int jockey_id) {
        this.jockey_id = jockey_id;
    }

    public int getStarting_price() {
        return starting_price;
    }

    public void setStarting_price(int starting_price) {
        this.starting_price = starting_price;
    }

    public int getFinal_position() {
        return final_position;
    }

    public void setFinal_position(int final_position) {
        this.final_position = final_position;
    }
}
