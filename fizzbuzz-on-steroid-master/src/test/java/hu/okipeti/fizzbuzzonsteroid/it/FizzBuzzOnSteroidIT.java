package hu.okipeti.fizzbuzzonsteroid.it;

import hu.okipeti.fizzbuzzonsteroid.FizzBuzzRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class FizzBuzzOnSteroidIT {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private FizzBuzzRunner fizzBuzzRunner;
    @Autowired
    private TestWriter testWriter;

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
        result.add(0, "");
        assertThat(testWriter.getResult()).element(1).isEqualTo("1");
        assertThat(testWriter.getResult()).element(3).isEqualTo("Fizz");
        assertThat(testWriter.getResult()).element(4).isEqualTo("Foo");
        assertThat(testWriter.getResult()).element(5).isEqualTo("Buzz");
        assertThat(testWriter.getResult()).element(15).isEqualTo("FizzBuzz");
        assertThat(testWriter.getResult()).element(60).isEqualTo("FizzBuzzFoo");
    }

    @Test
    void controllerTest() throws Exception {
        mockMvc.perform(get("/fizzbuzz"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(100))
                .andExpect(jsonPath("$[0]").value("1"))
                .andExpect(jsonPath("$[59]").value("FizzBuzzFoo"));
    }

    @Test
    void controllerWithPAremeterTest() throws Exception {
        mockMvc.perform(get("/fizzbuzz").param("to", "60"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(60))
                .andExpect(jsonPath("$[0]").value("1"))
                .andExpect(jsonPath("$[59]").value("FizzBuzzFoo"));
    }
}
