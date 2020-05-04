package sample;

public class VolunteerTable {

    String name, timeslot;

    public VolunteerTable(String name, String timeslot) {
        this.name = name;
        this.timeslot = timeslot;
    }

    public String getName() {
        return name;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }
}
