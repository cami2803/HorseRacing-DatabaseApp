package project.models;

import java.util.ArrayList;
import java.util.List;

public class RaceCourses {
    private List<RaceCourse> raceCourseList;

    public RaceCourses() {
        this.raceCourseList = new ArrayList<>();
    }

    public List<RaceCourse> getRaceCourseList() {
        return raceCourseList;
    }

    public void setRaceCourseList(List<RaceCourse> raceCourseList) {
        this.raceCourseList = raceCourseList;
    }

}
