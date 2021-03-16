package hu.nive.ujratervezes.zarovizsga.workhours;

import java.time.LocalDate;

public class Work {

    private final String name;
    private final int workingHours;
    private final LocalDate workDate;

    public Work(String name, int workingHours, LocalDate workDate) {
        this.name = name;
        this.workingHours = workingHours;
        this.workDate = workDate;
    }

    public String getName() {
        return name;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public LocalDate getWorkDate() {
        return workDate;
    }

    public String print() {
        return name + ": " + workDate;
    }
}
