package helper;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

/**
 * Read a resource file in for a test.
 */
public class FileUtility {

    public FileUtility() {
    }

    /**
     * Utility to read the sample HTML file in from the test/resources folder.
     *
     * @param fileName
     * @return
     */
    public String read(String fileName) {

        String result = "";

        ClassLoader classLoader = getClass().getClassLoader();
        try {
            result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
