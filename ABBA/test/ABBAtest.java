import org.junit.Test;

import Main.ABBA;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;


public class ABBAtest {




  @Test
  public void test1() {
    ABBA thisAbba = new ABBA();
    thisAbba.Dump();
    String thisResult = thisAbba.canObtain("B", "ABBA");
    System.out.println(thisResult);

    assertEquals("Possible", thisResult);

  }

  @Test
  public void test2() {
    ABBA thisAbba = new ABBA();
    thisAbba.Dump();
    String thisResult = thisAbba.canObtain("BBAB", "ABABABABB");
    assertEquals("Impossible", thisResult);
  }

  @Test
  public void test3() {
    ABBA thisAbba = new ABBA();
    String thisResult = thisAbba.canObtain("A", "BB");
    assertEquals("Impossible", thisResult);
  }

  @Test
  public void test4() {
    ABBA thisAbba = new ABBA();
    String thisResult = thisAbba.canObtain("BBBBABABBBBBBA", "BBBBABABBABBBBBBABABBBBBBBBABAABBBAA");
    assertEquals("Possible", thisResult);
  }


}
