package com.askat.cw9_m3.model;

import java.io.Serializable;

public class WorksModel implements Serializable {
    private String nameJob, NameCompany, salary, position, time, timeLoad;

    public WorksModel(String nameJob, String nameCompany, String salary, String position, String time, String timeLoad) {
        this.nameJob = nameJob;
        NameCompany = nameCompany;
        this.salary = salary;
        this.position = position;
        this.time = time;
        this.timeLoad = timeLoad;
    }

    public String getNameJob() {
        return nameJob;
    }

    public String getNameCompany() {
        return NameCompany;
    }

    public String getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getTime() {
        return time;
    }

    public String getTimeLoad() {
        return timeLoad;
    }
}
