import org.junit.Test;

import Main.LunchScheduler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

public class LunchSchedulerTest {



  @Test
  public void test0() {
    LunchScheduler thisLunch = new LunchScheduler();
    String[] thisIn = {"0110", "1010", "1100", "0000"};
    //System.out.print("BEFORE FUNC");
    assertEquals(3, thisLunch.getOverlap(thisIn));
  }

  @Test
  public void test1() {
    LunchScheduler thisLunch = new LunchScheduler();
    String[] thisIn = {"011111", "101111", "110111", "111011", "111101", "111110"};
    assertEquals(6, thisLunch.getOverlap(thisIn));
  }

  @Test
  public void test2() {
    LunchScheduler thisLunch = new LunchScheduler();
    String[] thisIn = {"01000000", "10000000", "00000000", "00000000", "00000000", "00000000",
            "00000001", "00000010"};
    assertEquals(2, thisLunch.getOverlap(thisIn));
  }

  @Test
  public void test3() {
    LunchScheduler thisLunch = new LunchScheduler();
    String[] thisIn = {"011011010", "101000111", "110010110", "000001101", "101001000",
            "100110101", "011101010", "111000100", "010101000"};
    assertEquals(5, thisLunch.getOverlap(thisIn));
  }

  @Test
  public void test4() {
    LunchScheduler thisLunch = new LunchScheduler();
    String[] thisIn = {"000", "000", "000"};
    assertEquals(1, thisLunch.getOverlap(thisIn));
  }

}
