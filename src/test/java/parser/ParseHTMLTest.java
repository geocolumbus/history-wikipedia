package parser;

import model.MonthlyEvents;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Test the wikipedia monthly date page parser
 */
public class ParseHTMLTest {

    /**
     * Utility to read the sample HTML file in from the test/resources folder.
     *
     * @param fileName
     * @return
     */
    private String getFile(String fileName) {

        String result = "";

        ClassLoader classLoader = getClass().getClassLoader();
        try {
            result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Test
    public void testGetTitle() {
        String testHTML;
        testHTML = getFile("january1966.html");
        MonthlyEvents actual = ParseHTML.parse(testHTML);
        String expected = "January 1966 - Wikipedia";
        assertEquals(expected, MonthlyEvents.title);
    }
}
