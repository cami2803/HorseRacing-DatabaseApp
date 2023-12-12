package project.models;

import java.util.ArrayList;
import java.util.List;

public class Races {
    private List<Race> races;

    public Races() {
        this.races = new ArrayList<>();
    }

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }

}
