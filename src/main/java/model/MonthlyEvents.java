package model;

import java.util.ArrayList;

/**
 * A list of HistoryEvents.
 */
public class MonthlyEvents {
    private ArrayList<HistoryEvent> events;
    public static String title;

    public MonthlyEvents() {
    }



    public ArrayList<HistoryEvent> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<HistoryEvent> events) {
        this.events = events;
    }
}
