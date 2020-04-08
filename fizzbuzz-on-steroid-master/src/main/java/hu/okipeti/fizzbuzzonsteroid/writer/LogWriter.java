package hu.okipeti.fizzbuzzonsteroid.writer;

import hu.okipeti.fizzbuzzonsteroid.Writer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class LogWriter implements Writer {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogWriter.class);

    @Override
    public void write(String s) {
        LOGGER.info(s);
    }
}
