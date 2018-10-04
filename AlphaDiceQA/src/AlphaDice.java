public class AlphaDice {

  //https://arena.topcoder.com/index.html#/u/practiceCode/1297/1643/1761/1/1297

  //^^ This the problem statement


  Dice thisDice;


  public AlphaDice () {

    thisDice = new Dice();

  }

  public int badData (String[] roll) {

    for (int i = 0; i < roll.length; i++) {

      String thisRoll = roll[i];

      if (thisRoll.length() != 3) {
        throw new IllegalArgumentException("Roll showed more or less than 3 sides, impossible.");
      }


      char topChar = thisRoll.charAt(0);
      char frontChar = thisRoll.charAt(1);
      char rightChar = thisRoll.charAt(2);

      try {
        thisDice.addRoll(topChar, frontChar, rightChar);
      } catch (IllegalArgumentException e) {
        return i;
      }


    }
    return -1;
  }






}
