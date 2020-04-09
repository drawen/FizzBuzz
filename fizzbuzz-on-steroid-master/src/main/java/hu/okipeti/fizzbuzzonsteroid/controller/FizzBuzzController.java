package hu.okipeti.fizzbuzzonsteroid.controller;

import hu.okipeti.fizzbuzzonsteroid.FizzBuzzComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FizzBuzzController {

    private final FizzBuzzComponent fizzBuzzComponent;

    @Autowired
    public FizzBuzzController(FizzBuzzComponent fizzBuzzComponent) {
        this.fizzBuzzComponent = fizzBuzzComponent;
    }

    @GetMapping("/fizzbuzz")
    public List<String> getFizzBuzzNumbers(@RequestParam(name = "to", defaultValue = "100") int maxNumber) {
        return fizzBuzzComponent.fizzBuzzNumber(maxNumber);
    }
}
