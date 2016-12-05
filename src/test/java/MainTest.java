import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test that the app starts and logs a debug message.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainTest {

    @Mock
    private Appender mockAppender;

    @Captor
    private ArgumentCaptor captorLoggingEvent;

    @Before
    public void setup() {
        LogManager.getRootLogger().addAppender(mockAppender);
    }

    @After
    public void teardown() {
        LogManager.getRootLogger().removeAppender(mockAppender);
    }

    @Test
    public void shouldConcatAndLog() {
        String[] args = {"test=true"};
        Main.main(args);

        verify(mockAppender).doAppend((LoggingEvent) captorLoggingEvent.capture());
        LoggingEvent loggingEvent = (LoggingEvent) captorLoggingEvent.getValue();
        //Check log level
        assertThat(loggingEvent.getLevel(), is(Level.DEBUG));
        //Check the message being logged
        assertThat(loggingEvent.getRenderedMessage(),
            is("Application start."));
    }
}
