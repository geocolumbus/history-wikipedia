package model.model;

import model.HistoryEvent;
import model.MonthlyEvents;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Test the monthly events model.
 */
public class MonthlyEventsTest {

    @Test
    public void storesData() {
        HistoryEvent historyEvent = new HistoryEvent("The Rolling Stones played a concert", 0);
        ArrayList<HistoryEvent> historyEvents = new ArrayList<>();
        historyEvents.add(historyEvent);

        MonthlyEvents monthlyEvents = new MonthlyEvents();
        monthlyEvents.setYear("1966");
        monthlyEvents.setMonth("January");
        monthlyEvents.setDaysInMonth(31);
        monthlyEvents.setEvents(historyEvents);

        String expected = "MonthlyEvents{events=[HistoryEvent{" +
            "entry='The Rolling Stones played a concert', dayOfMonth=0}], " +
            "year='1966', month='January', daysInMonth=31}";
        assertEquals(expected, monthlyEvents.toString());
    }
}
