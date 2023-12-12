package project.models;

public class Trainer {
    private int id;
    private String name;
    private String other_details;

    public Trainer(int id, String name, String other_details){
        this.id = id;
        this.name = name;
        this.other_details = other_details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOther_details() {
        return other_details;
    }

    public void setOther_details(String other_details) {
        this.other_details = other_details;
    }

}
