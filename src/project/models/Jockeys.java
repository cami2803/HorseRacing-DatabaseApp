package project.models;

import java.util.ArrayList;
import java.util.List;

public class Jockeys {

    private List<Jockey> jockeys;

    public Jockeys(){
        this.jockeys = new ArrayList<>();
    }

    public List<Jockey> getJockeys() {
        return jockeys;
    }

    public void setJockeys(List<Jockey> jockeys) {
        this.jockeys = jockeys;
    }
}
