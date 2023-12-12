package project.models;

import java.util.ArrayList;
import java.util.List;

public class Associations {
    private List<Association> associationList;

    public Associations() {
        this.associationList = new ArrayList<>();
    }

    public List<Association> getAssociationList() {
        return associationList;
    }

    public void setAssociationList(List<Association> associationList) {
        this.associationList = associationList;
    }
}
