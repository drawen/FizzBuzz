package hu.okipeti.fizzbuzzonsteroid.it;

import static org.assertj.core.api.Assertions.assertThat;

import hu.okipeti.fizzbuzzonsteroid.FizzBuzzRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FizzBuzzOnSteroidIT {

  @Autowired private FizzBuzzRunner fizzBuzzRunner;

  @Autowired private TestWriter testWriter;

  @AfterEach
  void tearDown() {
    testWriter.clear();
  }

  @Test
  void fizzBuzzShouldReturnTheCorrectValues() {
    // when
    fizzBuzzRunner.run();

    // then
    assertThat(testWriter.getResult()).hasSize(100);
    List<String> result = testWriter.getResult();
    result.add(0,"");
    assertThat(testWriter.getResult()).element(1).isEqualTo("1");
    assertThat(testWriter.getResult()).element(3).isEqualTo("Fizz");
    assertThat(testWriter.getResult()).element(4).isEqualTo("Foo");
    assertThat(testWriter.getResult()).element(5).isEqualTo("Buzz");
    assertThat(testWriter.getResult()).element(15).isEqualTo("FizzBuzz");
    assertThat(testWriter.getResult()).element(60).isEqualTo("FizzBuzzFoo");
  }
}
