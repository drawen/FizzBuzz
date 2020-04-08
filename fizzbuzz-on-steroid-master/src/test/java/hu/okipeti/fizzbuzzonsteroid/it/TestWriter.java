package hu.okipeti.fizzbuzzonsteroid.it;

import hu.okipeti.fizzbuzzonsteroid.Writer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
class TestWriter implements Writer {
  private List<String> result = new ArrayList<>();

  @Override
  public void write(String s) {
    result.add(s);
    System.out.println("s = " + result.size());
  }

  public List<String> getResult() {
    return result;
  }

  public void clear() {
    result.clear();
  }
}
