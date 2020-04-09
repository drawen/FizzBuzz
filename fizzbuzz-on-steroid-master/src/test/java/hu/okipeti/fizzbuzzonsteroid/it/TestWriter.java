package hu.okipeti.fizzbuzzonsteroid.it;

import hu.okipeti.fizzbuzzonsteroid.Writer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class TestWriter implements Writer {
    private final List<String> result = new ArrayList<>();

    @Override
    public void write(String s) {
        result.add(s);
        System.out.println("s = " + result.size());
    }

    public List<String> getResult() {
        return result;
    }

    public void clear() {
        result.clear();
    }
}
