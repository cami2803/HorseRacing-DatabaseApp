package project.models;

import java.util.ArrayList;
import java.util.List;

public class Schedules {
    private List<Schedule> scheduleList;

    public Schedules() {
        this.scheduleList = new ArrayList<>();
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
