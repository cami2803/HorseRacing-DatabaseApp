package project.models;

import java.sql.Time;
import java.util.Date;

public class Schedule {
    private int race_id;
    private int race_class_code;
    private int race_course_id;
    private int race_rating_code;
    private int race_type_code;
    private int distance;
    private Date date;
    private Time time;
    private String other_details;

    public Schedule(int race_id, int race_class_code, int race_course_id, int race_rating_code, int race_type_code, int distance, Date date, Time time, String other_details) {
        this.race_id = race_id;
        this.race_class_code = race_class_code;
        this.race_course_id = race_course_id;
        this.race_rating_code = race_rating_code;
        this.race_type_code = race_type_code;
        this.distance = distance;
        this.date = date;
        this.time = time;
        this.other_details = other_details;
    }

    public int getRace_id() {
        return race_id;
    }

    public void setRace_id(int race_id) {
        this.race_id = race_id;
    }

    public int getRace_class_code() {
        return race_class_code;
    }

    public void setRace_class_code(int race_class_code) {
        this.race_class_code = race_class_code;
    }

    public int getRace_course_id() {
        return race_course_id;
    }

    public void setRace_course_id(int race_course_id) {
        this.race_course_id = race_course_id;
    }

    public int getRace_rating_code() {
        return race_rating_code;
    }

    public void setRace_rating_code(int race_rating_code) {
        this.race_rating_code = race_rating_code;
    }

    public int getRace_type_code() {
        return race_type_code;
    }

    public void setRace_type_code(int race_type_code) {
        this.race_type_code = race_type_code;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getOther_details() {
        return other_details;
    }

    public void setOther_details(String other_details) {
        this.other_details = other_details;
    }
}
