package project.models;

import java.util.ArrayList;
import java.util.List;

public class Trainers {
    private List<Trainer> trainers;
    public Trainers(){
        this.trainers = new ArrayList<>();
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

}
