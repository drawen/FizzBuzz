package hu.okipeti.fizzbuzzonsteroid;

import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class FizzBuzzRunner {

  private final FizzBuzzComponent fizzBuzzComponent;

  public FizzBuzzRunner(FizzBuzzComponent fizzBuzzComponent) {
    this.fizzBuzzComponent = fizzBuzzComponent;
  }

  public void run() {
    IntStream.range(1, 101).forEach(fizzBuzzComponent::fizzBuzzNumber);
  }
}
