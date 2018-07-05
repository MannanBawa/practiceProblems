
import org.junit.Test;

import Main.TallPeople;

import static org.junit.Assert.assertEquals;


public class TallPeopleTest {

  TallPeople tp = new TallPeople();

  @Test
  public void test1() {
    String[] people = {"9 2 3", "4 8 7"};
    int expected[] = {4, 7};
    int result[] = tp.getPeople(people);
    assertEquals(expected.length, result.length);
    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i], result[i]);
    }
  }

  @Test
  public void test2() {
    String[] people = {"1 2", "4 5", "3 6"};
    int expected[] = {4, 4};
    int result[] = tp.getPeople(people);
    assertEquals(expected.length, result.length);
    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i], result[i]);
    }
  }

  @Test
  public void test3() {
    String[] people = {"1 1", "1 1"};
    int expected[] = {1, 1};
    int result[] = tp.getPeople(people);
    assertEquals(expected.length, result.length);
    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i], result[i]);
    }
  }
}
