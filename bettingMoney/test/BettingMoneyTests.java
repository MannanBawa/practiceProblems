import org.junit.Test;

import Main.BettingMoney;

import static org.junit.Assert.assertEquals;


public class BettingMoneyTests {
  BettingMoney bm = new BettingMoney();

  @Test
  public void test1() {
    int amounts[] = {10, 20, 30};
    int cPD[] = {20, 30, 40};
    int finalRes = 1;
    assertEquals(3400, bm.moneyMade(amounts, cPD, finalRes));
  }

  @Test
  public void test2() {
    int amounts[] = {200, 300, 100};
    int cPD[] = {10, 10, 10};
    int finalRes = 2;
    assertEquals(49000, bm.moneyMade(amounts, cPD, finalRes));
  }

  @Test
  public void test3() {
    int amounts[] = {100, 100, 100, 100};
    int cPD[] = {5,5,5,5};
    int finalRes = 0;
    assertEquals(29500, bm.moneyMade(amounts, cPD, finalRes));
  }

  @Test
  public void test4() {
    int amounts[] = {5000, 5000};
    int cPD[] = {100, 2};
    int finalRes = 0;
    assertEquals(0, bm.moneyMade(amounts, cPD, finalRes));
  }

  @Test
  public void test5() {
    int amounts[] = {100};
    int cPD[] = {10};
    int finalRes = 0;
    assertEquals(-1000, bm.moneyMade(amounts, cPD, finalRes));
  }
}
