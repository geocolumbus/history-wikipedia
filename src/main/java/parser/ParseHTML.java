package parser;

import model.HistoryEvent;
import model.MonthlyEvents;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Parse the wikipedia page
 */
public class ParseHTML {

    static Logger log = Logger.getLogger(ParseHTML.class.getName());

    public static MonthlyEvents parse(String text) {
        MonthlyEvents monthlyEvents = new MonthlyEvents();

        Document doc = Jsoup.parse(text);
        String title = doc.select("title").get(0).html();

        monthlyEvents.setYear(getYearFromTitle(title));
        monthlyEvents.setMonth(getMonthFromTitle(title));
        monthlyEvents.setDaysInMonth(getNumberOfDaysInMonth(monthlyEvents.getYear(), monthlyEvents.getMonth()));
        monthlyEvents.setEvents(getEventsFromDays(doc, monthlyEvents.getDaysInMonth()));

        return monthlyEvents;
    }

    /* Utilities ******************************************************************************************************/

    protected static ArrayList<HistoryEvent> getEventsFromDays(Document doc, int daysInMonth) {
        ArrayList<HistoryEvent> historyEvents = new ArrayList<>();
        Elements eventContent = doc.select("h2 + *");
        Elements eventHeader = doc.select("h2");
        int counter = 0;
        int dayCounter = 0;

        while (dayCounter < daysInMonth) {
            if (eventHeader.get(counter).select("span").size() != 0 && eventHeader.get(counter).select("span").hasClass("mw-headline")) {
                Elements liItems = eventContent.get(dayCounter).select("li");
                for (Element liItem : liItems) {
                    historyEvents.add(new HistoryEvent(liItem.text(), dayCounter));
                }
                dayCounter++;
            }
            counter++;
        }
        return historyEvents;
    }

    protected static String getMonthFromTitle(String title) {
        String[] titleParts = title.split(" ");
        return titleParts[0];
    }

    protected static String getYearFromTitle(String title) {
        String[] titleParts = title.split(" ");
        return titleParts[1];
    }

    protected static int getNumberOfDaysInMonth(String year, String month) {
        int iYear = Integer.parseInt(year);
        int iMonth = 0; // january
        int iDay = 1;

        iMonth = month.toLowerCase().equals("february") ? iMonth = 1 : iMonth;
        iMonth = month.toLowerCase().equals("march") ? iMonth = 2 : iMonth;
        iMonth = month.toLowerCase().equals("april") ? iMonth = 3 : iMonth;
        iMonth = month.toLowerCase().equals("may") ? iMonth = 4 : iMonth;
        iMonth = month.toLowerCase().equals("june") ? iMonth = 5 : iMonth;
        iMonth = month.toLowerCase().equals("july") ? iMonth = 6 : iMonth;
        iMonth = month.toLowerCase().equals("august") ? iMonth = 7 : iMonth;
        iMonth = month.toLowerCase().equals("september") ? iMonth = 8 : iMonth;
        iMonth = month.toLowerCase().equals("october") ? iMonth = 9 : iMonth;
        iMonth = month.toLowerCase().equals("november") ? iMonth = 10 : iMonth;
        iMonth = month.toLowerCase().equals("december") ? iMonth = 11 : iMonth;

        Calendar mycal = new GregorianCalendar(iYear, iMonth, iDay);

        return mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
