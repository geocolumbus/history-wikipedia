import org.apache.log4j.Logger;

/**
 * Entry point for the Wikipedia history scraper.
 */
public class Main {
    static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        log.debug("Application start.");
        if (args != null && args.length > 0) {
            if (args[0].equals("test=true")) {
                return;
            }
        }
    }
}
