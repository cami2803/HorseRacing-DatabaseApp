package project.models;

import java.util.ArrayList;
import java.util.List;

public class Horses {
    private List<Horse> horseList;

    public Horses() {
        this.horseList = new ArrayList<>();
    }

    public List<Horse> getHorseList() {
        return horseList;
    }

    public void setHorseList(List<Horse> horseList) {
        this.horseList = horseList;
    }
}
