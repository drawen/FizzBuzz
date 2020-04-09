package hu.okipeti.fizzbuzzonsteroid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FizzBuzzRunner {

    private final FizzBuzzComponent fizzBuzzComponent;

    @Autowired
    public FizzBuzzRunner(FizzBuzzComponent fizzBuzzComponent) {
        this.fizzBuzzComponent = fizzBuzzComponent;
    }

    public void run() {
        fizzBuzzComponent.fizzBuzzNumber(100);
    }
}
