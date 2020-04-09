package hu.okipeti.fizzbuzzonsteroid.it;

import hu.okipeti.fizzbuzzonsteroid.FizzBuzzOnSteroidApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@Configuration
@ComponentScan(
        excludeFilters =
        @ComponentScan.Filter(type = ASSIGNABLE_TYPE, value = FizzBuzzOnSteroidApplication.class),
        basePackageClasses = FizzBuzzOnSteroidApplication.class)
@EnableAutoConfiguration
@SpringBootConfiguration
public class TestApplicationConfiguration {

}
