package project.models;

public class Jockey {
    private int id;
    private String name;
    private String gender;
    private String other_details;
    private int weight;

    public Jockey(int id, String name, String gender, int weight, String other_details) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.weight = weight;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOther_details() {
        return other_details;
    }

    public void setOther_details(String other_details) {
        this.other_details = other_details;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
