package hu.okipeti.fizzbuzzonsteroid.rule;

import hu.okipeti.fizzbuzzonsteroid.Rule;
import org.springframework.stereotype.Component;

@Component
public class FizzRule implements Rule {
    @Override
    public String getOutputIfTrue() {
        return "Fizz";
    }

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public boolean test(Integer i) {
        return i % 3 == 0;
    }
}
