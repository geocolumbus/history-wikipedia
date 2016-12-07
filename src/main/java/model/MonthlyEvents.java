package model;

import java.util.ArrayList;

/**
 * A list of HistoryEvents.
 */
public class MonthlyEvents {
    private ArrayList<HistoryEvent> events;
    private String year;
    private String month;
    private int daysInMonth;

    public MonthlyEvents() {
    }

    public ArrayList<HistoryEvent> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<HistoryEvent> events) {
        this.events = events;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getDaysInMonth() {
        return daysInMonth;
    }

    public void setDaysInMonth(int daysInMonth) {
        this.daysInMonth = daysInMonth;
    }

    @Override
    public String toString() {
        return "MonthlyEvents{" +
            "events=" + events +
            ", year='" + year + '\'' +
            ", month='" + month + '\'' +
            ", daysInMonth=" + daysInMonth +
            '}';
    }


}
