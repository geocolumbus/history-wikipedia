package parser;

import model.MonthlyEvents;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Parse the wikipedia page
 */
public class ParseHTML {

    public static MonthlyEvents parse(String text) {
        MonthlyEvents historyEvents = new MonthlyEvents();

        Document doc = Jsoup.parse(text);
        MonthlyEvents.title = doc.select("title").get(0).html();

        return historyEvents;
    }
}
