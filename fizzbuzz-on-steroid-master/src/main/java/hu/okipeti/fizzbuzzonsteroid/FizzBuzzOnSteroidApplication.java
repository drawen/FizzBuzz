package hu.okipeti.fizzbuzzonsteroid;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FizzBuzzOnSteroidApplication {

    public static void main(String[] args) {
        SpringApplication.run(FizzBuzzOnSteroidApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(FizzBuzzRunner fizzBuzzRunner) {
        return args -> fizzBuzzRunner.run();
    }
}
