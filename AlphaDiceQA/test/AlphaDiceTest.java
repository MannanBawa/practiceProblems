import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlphaDiceTest {

  @Test
  public void testZero() {
    AlphaDice thisAD = new AlphaDice();
    String[] rolls = new String[] {"ABC", "ZCB"};
    int result = thisAD.badData(rolls);
    assertEquals(-1, result);
  }

  @Test
  public void testOne() {
    AlphaDice thisAD = new AlphaDice();
    String[] rolls = new String[]{"ABC", "DEF", "BCA", "GHI", "ABC"};
    int result = thisAD.badData(rolls);
    assertEquals(3, result);

  }

  @Test
  public void testTwo() {
    AlphaDice thisAD = new AlphaDice();
    String[] rolls = new String[]{"ABA", "CDE", "CDE", "CDE", "CDE"};
    int result = thisAD.badData(rolls);
    assertEquals(0, result);
  }

  @Test
  public void testThree() {
    AlphaDice thisAD = new AlphaDice();
    String[] rolls = new String[3];
    rolls[0] = "ABC";
    rolls[1] = "DEF";
    rolls[2] = "BCF";
    int result = thisAD.badData(rolls);
    assertEquals(2, result);
  }

  @Test
  public void testFour() {
    AlphaDice thisAD = new AlphaDice();
    String[] rolls = new String[3];
    rolls[0] = "ABC";
    rolls[1] = "DEF";
    rolls[2] = "ADF";
    int result = thisAD.badData(rolls);
    assertEquals(2, result);
  }


}
