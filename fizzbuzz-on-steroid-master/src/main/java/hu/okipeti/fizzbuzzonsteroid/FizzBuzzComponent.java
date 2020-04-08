package hu.okipeti.fizzbuzzonsteroid;

import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FizzBuzzComponent {
  private final List<Rule> rules;
  private final List<Writer> writers;

  @Autowired
  public FizzBuzzComponent(List<Rule> rules, List<Writer> writers) {
    this.rules = rules;
    this.writers = writers;
  }

  public void fizzBuzzNumber(int i) {
    String output = applyRules(i);
    writers.forEach(writer -> writer.write(output));
  }

  private String applyRules(int i) {
    return rules.stream()
        .filter(rule -> rule.test(i))
        .sorted(Comparator.comparingInt(Rule::getOrder))
        .map(Rule::getOutputIfTrue)
        .reduce((s, s2) -> s + s2)
        .orElse(String.valueOf(i));
  }
}
