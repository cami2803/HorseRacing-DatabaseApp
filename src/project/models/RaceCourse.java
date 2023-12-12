package project.models;

public class RaceCourse {
    private int id;
    private String name;
    private String location;
    private int distance;
    private String other_details;

    public RaceCourse(int id, String name, String location, int distance, String other_details) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.distance = distance;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getOther_details() {
        return other_details;
    }

    public void setOther_details(String other_details) {
        this.other_details = other_details;
    }

}
