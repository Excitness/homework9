package com.askat.cw9_m3.model;

import java.io.Serializable;

public class JobListModel implements Serializable {
    private String nameJob, NameCompany, location, salary, position, time, availability;

    public JobListModel(String nameJob, String nameCompany, String location, String salary, String position, String time, String availability) {
        this.nameJob = nameJob;
        NameCompany = nameCompany;
        this.location = location;
        this.salary = salary;
        this.position = position;
        this.time = time;
        this.availability = availability;
    }

    public String getNameJob() {
        return nameJob;
    }

    public String getNameCompany() {
        return NameCompany;
    }

    public String getLocation() {
        return location;
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

    public String getAvailability() {
        return availability;
    }
}
