package hu.okipeti.fizzbuzzonsteroid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class FizzBuzzComponent {
    private final List<Rule> rules;
    private final List<Writer> writers;

    @Autowired
    public FizzBuzzComponent(List<Rule> rules, List<Writer> writers) {
        this.rules = rules;
        this.writers = writers;
    }

    public List<String> fizzBuzzNumber(int toNumber) {
        List<String> list = IntStream.range(1, toNumber + 1).mapToObj(this::applyRules).collect(Collectors.toList());
        log(list);
        return list;
    }

    private void log(List<String> list) {
        list.forEach(s -> writers.forEach(writer -> writer.write(s)));
    }

    public String applyRules(int number) {
        return rules.stream()
                .filter(rule -> rule.test(number))
                .sorted(Comparator.comparingInt(Rule::getOrder))
                .map(Rule::getOutputIfTrue)
                .reduce((s, s2) -> s + s2)
                .orElse(String.valueOf(number));
    }
}
