import org.junit.Test;

public class AlphaDiceTest {

  @Test
  public void testZero() {
    AlphaDice thisAD = new AlphaDice();
    String[] rolls = new String[] {"ABC", "ZCB"};
    System.out.println(thisAD.badData(rolls));

  }

  @Test
  public void testOne() {
    AlphaDice thisAD = new AlphaDice();
    String[] rolls = new String[]{"ABC", "DEF", "BCA", "GHI", "ABC"};
    System.out.println(thisAD.badData(rolls));

  }

  @Test
  public void testTwo() {
    AlphaDice thisAD = new AlphaDice();
    String[] rolls = new String[]{"ABA", "CDE", "CDE", "CDE", "CDE"};
    System.out.println(thisAD.badData(rolls));
  }

  @Test
  public void testThree() {
    AlphaDice thisAD = new AlphaDice();
    String[] rolls = new String[3];
    rolls[0] = "ABC";
    rolls[1] = "DEF";
    rolls[2] = "BCF";
    System.out.println(thisAD.badData(rolls));
  }

  @Test
  public void testFour() {
    AlphaDice thisAD = new AlphaDice();
    String[] rolls = new String[3];
    rolls[0] = "ABC";
    rolls[1] = "DEF";
    rolls[2] = "ADF";
    System.out.println(thisAD.badData(rolls));
  }


}
