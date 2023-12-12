package project.models;

public class Horse {
    private int horse_id;
    private int trainer_id;
    private String name;
    private int age;
    private String other_details;

    public Horse(int horse_id, int trainer_id, String name, int age, String other_details) {
        this.horse_id = horse_id;
        this.trainer_id = trainer_id;
        this.name = name;
        this.age = age;
        this.other_details = other_details;
    }

    public int getHorse_id() {
        return horse_id;
    }

    public void setHorse_id(int horse_id) {
        this.horse_id = horse_id;
    }

    public int getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(int trainer_id) {
        this.trainer_id = trainer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOther_details() {
        return other_details;
    }

    public void setOther_details(String other_details) {
        this.other_details = other_details;
    }
}
