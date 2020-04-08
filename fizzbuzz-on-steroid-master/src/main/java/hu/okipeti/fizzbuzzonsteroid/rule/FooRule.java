package hu.okipeti.fizzbuzzonsteroid.rule;

import hu.okipeti.fizzbuzzonsteroid.Rule;
import org.springframework.stereotype.Component;

@Component
public class FooRule implements Rule {
    @Override
    public String getOutputIfTrue() {
        return "Foo";
    }

    @Override
    public int getOrder() {
        return 3;
    }

    @Override
    public boolean test(Integer i) {
        return i % 4 == 0;
    }
}
