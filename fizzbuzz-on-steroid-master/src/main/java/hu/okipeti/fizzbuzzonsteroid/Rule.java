package hu.okipeti.fizzbuzzonsteroid;

import java.util.function.Predicate;

public interface Rule extends Predicate<Integer> {
    String getOutputIfTrue();

    int getOrder();
}
