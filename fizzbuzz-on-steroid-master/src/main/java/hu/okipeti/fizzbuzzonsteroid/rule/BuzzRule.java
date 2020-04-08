package hu.okipeti.fizzbuzzonsteroid.rule;

import hu.okipeti.fizzbuzzonsteroid.Rule;
import org.springframework.stereotype.Component;

@Component
public class BuzzRule implements Rule {
    @Override
    public String getOutputIfTrue() {
        return "Buzz";
    }

    @Override
    public boolean test(Integer i) {
        return i % 5 == 0;
    }


    @Override
    public int getOrder() {
        return 2;
    }
}
