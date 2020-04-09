package hu.okipeti.fizzbuzzonsteroid.writer;

import hu.okipeti.fizzbuzzonsteroid.Writer;
import org.springframework.stereotype.Component;

@Component
public class SysOutWriter implements Writer {
    @Override
    public void write(String s) {
        System.out.println("SysOutWriter: " + s);
    }
}
