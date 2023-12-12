package project.models;

import java.util.ArrayList;
import java.util.List;

public class Details {
    private List<Detail> details;

    public Details() {
        this.details = new ArrayList<>();
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }
}
