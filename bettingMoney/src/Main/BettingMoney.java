package Main;

public class BettingMoney {

    public int moneyMade(int[] amounts, int[] centsPerDollar, int finalResult) {

      int dollarsGained = 0;
      int centsGained = 0;
      int centsLost = 0;

      if (ensureValidArrays(amounts, centsPerDollar) == false) {
        throw new IllegalArgumentException("Incorrect input");
      }

      for (int i = 0; i < amounts.length; i++) {
        if (i != finalResult) {
          dollarsGained = dollarsGained + amounts[i];
        }
      }
      centsGained = dollarsGained * 100;
      centsLost = amounts[finalResult] * centsPerDollar[finalResult];
      System.out.println(centsGained - centsLost);
      return centsGained - centsLost;
    }

    private boolean ensureValidArrays(int[] amounts, int[] centsPerDollar) {
      if (amounts.length == centsPerDollar.length) {
        return true;
      } else {
        return false;
      }
    }

}
