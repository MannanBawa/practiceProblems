import java.util.HashMap;

public class Dice {

  //This adds all possible dice orientations for when the key Character lands on the top side. So
  // each key maps to 4 char arrays of length 5, each array representing a possibility for where
  // the chars could be located. The arrays themselves show what char is in what space in this
  // order [Front, Right, Back, Left, Bottom] with unknown/undetermined values being represented
  // by the null character = '\u0000'
  HashMap<Character, char[][] > possibleDiceMappings;

  public Dice() {
    possibleDiceMappings = new HashMap<Character, char[][]>();
  }

  public void addRoll(char top, char front, char right) {

    if (!isRealRoll(top,front,right)) {
      //System.out.println("IS NOT REAL ROLL");
      throw new IllegalArgumentException("Cannot have repeat elements in one roll");
    }

    if (!possibleDiceMappings.containsKey(top)) {
      try { updateMapping(top, front, right); } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException(" ");
      }
    } else {
      try { verifyMapping(top, front, right); } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException(" ");
      }
    }

    if (!possibleDiceMappings.containsKey(front)) {
      try {
        updateMapping(front, right, top);
      } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException(" ");
      }
    } else {
      try {
        //verifyMapping(front, right, top);
      } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException(" ");
      }
    }


    if (!possibleDiceMappings.containsKey(right)) {
      try { updateMapping(right, top, front); } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException(" ");
      }
    } else {
      try {
        //verifyMapping(right, top, front);
      }
      catch (IllegalArgumentException e) {
        throw new IllegalArgumentException(" ");
      }
    }

  }

  private boolean isCapped() {
    return (possibleDiceMappings.size() == 6);
  }

  private boolean isRealRoll(char top, char front, char right) {
    return (top != front && top != right && front != right);
  }

  private void updateMapping(char thisTop, char thisFront, char thisRight) throws IllegalArgumentException {

    if (isCapped()) {
      //System.out.println("IS CAPPED BOI");
      throw new IllegalArgumentException("There are already 6 elements mapped to this die");
    }

    char[] topCharArrOne = new char[]{thisFront, thisRight, '\u0000', '\u0000', '\u0000'};
    char[] topCharArrTwo = new char[]{'\u0000', thisFront, thisRight, '\u0000', '\u0000'};
    char[] topCharArrThree = new char[]{'\u0000', '\u0000', thisFront, thisRight, '\u0000'};
    char[] topCharArrFour = new char[]{thisRight, '\u0000', '\u0000', thisFront, '\u0000'};

    char[][] topCharArr = new char[][]{topCharArrOne, topCharArrTwo, topCharArrThree,
            topCharArrFour};

    possibleDiceMappings.put(thisTop, topCharArr);
    //System.out.println("Top Added");




  }

  private void verifyMapping(char topCharToCheck, char frontCharToCheck, char rightCharToCheck) throws
          IllegalArgumentException {

    char[][] arrayToCheck = possibleDiceMappings.get(topCharToCheck);

    for (int i = 0; i < arrayToCheck.length; i++) {

      if (arrayToCheck[i][0] == frontCharToCheck) {
        if (arrayToCheck[i][1] == rightCharToCheck) {
          return;
        } else if (arrayToCheck[i][1] != rightCharToCheck && arrayToCheck[i][1] != '\u0000') {
          throw new IllegalArgumentException("This Right character cannot be here because it " +
                  "has been determined impossible");
        }
      } else if (arrayToCheck[i][0] != frontCharToCheck && arrayToCheck[i][0] != '\u0000') {
        throw new IllegalArgumentException("This Front character cannot be here because it has " +
                "been determined impossible");
      }
    }


  }




}

