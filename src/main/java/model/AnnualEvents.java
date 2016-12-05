package model;

import java.util.ArrayList;

/**
 * A collection of 12 months of events.
 */
public class AnnualEvents {
    private ArrayList<MonthlyEvents> annualEvents;
    public static String year;

    public AnnualEvents() {
    }

    public ArrayList<MonthlyEvents> getAnnualEvents() {
        return annualEvents;
    }

    public void setAnnualEvents(ArrayList<MonthlyEvents> annualEvents) {
        this.annualEvents = annualEvents;
    }
}
