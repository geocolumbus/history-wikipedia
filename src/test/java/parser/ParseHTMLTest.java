package parser;

import helper.FileUtility;
import model.MonthlyEvents;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test the wikipedia monthly date page parser
 */
public class ParseHTMLTest {

    @Test
    public void testGetTitle1() {
        MonthlyEvents monthlyEvents;
        FileUtility fileUtility = new FileUtility();

        monthlyEvents = ParseHTML.parse(fileUtility.read("january1966.html"));
        assertEquals("January", monthlyEvents.getMonth());
        assertEquals("1966", monthlyEvents.getYear());
        assertEquals(115, monthlyEvents.getEvents().size());

        monthlyEvents = ParseHTML.parse(fileUtility.read("january1953.html"));
        assertEquals("January", monthlyEvents.getMonth());
        assertEquals("1953", monthlyEvents.getYear());
        assertEquals(25, monthlyEvents.getEvents().size());
    }

    @Test
    public void getMonthFromTitle() {
        assertEquals("January", ParseHTML.getMonthFromTitle("January 1966 - Wikipedia"));
    }

    @Test
    public void getYearFromTitle() {
        assertEquals("1966", ParseHTML.getYearFromTitle("January 1966 - Wikipedia"));
    }

    @Test
    public void getNumberOfDaysInMonth() {
        assertEquals(31, ParseHTML.getNumberOfDaysInMonth("1966", "January"));

        // Handles leap years
        assertEquals(28, ParseHTML.getNumberOfDaysInMonth("1966", "February")); // normal year
        assertEquals(29, ParseHTML.getNumberOfDaysInMonth("1968", "February")); // leap year

        assertEquals(31, ParseHTML.getNumberOfDaysInMonth("1776", "March"));
        assertEquals(30, ParseHTML.getNumberOfDaysInMonth("1250", "April"));
        assertEquals(31, ParseHTML.getNumberOfDaysInMonth("300", "May"));
        assertEquals(30, ParseHTML.getNumberOfDaysInMonth("0", "June"));
        assertEquals(31, ParseHTML.getNumberOfDaysInMonth("2900", "July"));
        assertEquals(31, ParseHTML.getNumberOfDaysInMonth("2016", "August"));
        assertEquals(30, ParseHTML.getNumberOfDaysInMonth("2016", "September"));
        assertEquals(31, ParseHTML.getNumberOfDaysInMonth("2016", "October"));
        assertEquals(30, ParseHTML.getNumberOfDaysInMonth("2016", "November"));
        assertEquals(31, ParseHTML.getNumberOfDaysInMonth("2016", "December"));
    }
}
