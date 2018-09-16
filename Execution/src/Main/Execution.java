package Main;

import java.util.Scanner;

public class Execution {


  int counter;
  int newestTimes;
  int index;
  public StringBuilder readout;
  int returnVal;

  public Execution() {
    index = 0;
    counter = 0;
    newestTimes = 1;
    readout = new StringBuilder();
    returnVal = 0;

  }


  public long analyze(String[] code) {

    //int counter = 0;
    String formalizedInput = formalizeInput(code);
    System.out.println("INPUT: " + formalizedInput + "\n\n");
    int testOut = switchScanner(formalizedInput);
    System.out.println("\nOUTPUT: " + testOut);

    return testOut;
  }

  //DONE
  public String formalizeInput(String[] input) {

    StringBuilder outputString = new StringBuilder();
    outputString.append("{");
    for (String thisString : input) {
      outputString.append(thisString);
    }
    outputString.append("}");

    return outputString.toString();
  }

  public void scanString(String input) {
    for (int i = 0; i < input.length(); i++) {

      char thisChar = input.charAt(i);
      if (thisChar == 'B') {
        counter = counter * newestTimes;
      }

      if (thisChar == '(') {
        int placesForward = 0;

        while (thisChar != ')') {
          placesForward++;
          thisChar = input.charAt(i + placesForward);
        }
        String thisSubString = input.substring(i + 1, i + placesForward);
        int times = Integer.parseInt(thisSubString);
        System.out.println("\t\t\ttimes:" + times);
      }

      if (thisChar == '{') {
        int placesForward = 0;

        while ((thisChar != '}') && ((i + placesForward) < input.length() - 1)) {
          placesForward++;
          thisChar = input.charAt(i + placesForward);
        }
        String thisSubString = input.substring(i + 1, i + placesForward);
        scanString(thisSubString);
      }
    }
  }

  public int scanner(String input) {

    //System.out.println("SCANNER INPUT: " + input);
    int inputLength = input.length();
    //int returnVal;

    while(index < inputLength) {

      char thisChar = input.charAt(index);
      System.out.println("Char INPUT: " + thisChar);

      if (thisChar == 'B') {
        //Add B to equation

        //String subString = input.substring(i + 5);
        //index+=5;
        index+=1;
        returnVal = 1 + scanner(input);
        readout.append(" 1 + ");
        //counter = returnVal;
        //System.out.println("ADD RETURN VAL: " + returnVal);
        System.out.println("Add - Return Val: " + returnVal);
        return returnVal;
      } else if (thisChar == '(') {
        //System.out.println("HIT THE (");
        int braceCounter = 0;
        char closingBrace = input.charAt(index);

        while (closingBrace != ')') {
          braceCounter++;
          closingBrace = input.charAt(braceCounter);
        }

        String multiplierString = input.substring(index + 1, braceCounter);
        int multiplier = Integer.parseInt(multiplierString);
        index += 1;
        returnVal += multiplier * scanner(input);
        readout.append( multiplierString + " * (");
        System.out.println("Mult - Return Val: " + returnVal);
        //}

        //System.out.println("MULT RETURN VAL: " + returnVal);
        return returnVal;
      } else if (thisChar == '}') {
        //String subString = input.substring(i + 1);
        index += 1;
        //scanner(input);
        readout.append("}");
        //return returnVal;
        //break;
      } else if (thisChar == '{'|| thisChar == ')') {
        readout.append(thisChar);
        index +=1;
      } else {
        index+=1;
      }
    }
    //System.out.println("RET VAL: " + returnVal);
    return returnVal;
  }

  public int switchScanner (String input) {

    int inputLength = input.length();

    while (index < inputLength) {

      char thisChar = input.charAt(index);

      switch (thisChar){

        case 'B': {
          index++;
          returnVal = 1 + switchScanner(input);
          return returnVal;
        }
        case '(': {

          int closedParenCounter = 0;
          char closedParen = input.charAt(index + closedParenCounter);

          while (closedParen != ')') {
            closedParenCounter++;
            closedParen = input.charAt(index + closedParenCounter);
          }

          String multiplyThisRaw = input.substring(index+closedParenCounter + 1);
          //System.out.println(multiplyThisRaw);

          String multiplyThisRefined = getSet(multiplyThisRaw);


          String multiplierString = input.substring(index + 1, index + closedParenCounter);
          int multiplier = Integer.parseInt(multiplierString);

          index++;
          returnVal = multiplier * switchScanner(input);
        }
        default: {
          index++;
          break;
        }
      }
    }
    return returnVal;
  }


//  public String refineSelection(String input) {
//
//    int openerIndex = 0;
//    char openerChar = input.charAt(openerIndex);
//
//    while (openerChar != '{') {
//      openerIndex++;
//      openerChar = input.charAt(openerIndex);
//    }
//
//    int closerIndex = 0;
//    char closerChar = input.charAt(closerIndex);
//
//    while (closerChar != '}') {
//      closerIndex++;
//      closerChar = input.charAt(closerIndex);
//
//      if (closerChar == '{') {
//        if (closerIndex != openerIndex) {
//          //
//        }
//      }
//    }
//  }

  int numScanners = 0;

  public String getSet (String input) {

    System.out.println("GET SET INPUT: " + input);
    String returnString = new String();
    int numOpeners = 0;
    int numClosers = 0;

    for (int thisIndex = 0; thisIndex < input.length(); thisIndex++) {

      char thisChar = input.charAt(thisIndex);

      if (thisChar == '{' && thisIndex > 0) {
        returnString = getSet(input.substring(thisIndex));
        numOpeners++;
        //break;
      } else if (thisChar == '}') {
        returnString = input.substring(0, thisIndex + 1);
        numClosers++;
        if (numOpeners == numClosers) {
          break;
        }
      }
    }
    System.out.println("GET SET OUTPUT: " + returnString);
    return returnString;
  }

  public String setGetter (String input) throws IllegalArgumentException {

    int levelsDeep = 0;
    String output = new String();

    if (input.charAt(0) != '{') {
      throw new IllegalArgumentException("setGetter input must start with a { and end with a }");
    }

    for (int i = 0; i < input.length(); i++) {
      char thisChar = input.charAt(i);
      System.out.println(thisChar);

      int secondaryOpener = 0;

      if (levelsDeep != 1) {
        if (thisChar == '{'){
          levelsDeep++;
          secondaryOpener = i;
        } else if (thisChar == '}') {
          levelsDeep--;
        }
      } else if (levelsDeep == 1) {

        if (thisChar == '{') {
          levelsDeep++;
          String thisSub = input.substring(i);
          setGetter(thisSub);
        } else if (thisChar == '}') {
          levelsDeep--;
          output = input.substring(secondaryOpener, i + 1);
          return output;
        }
      }
    }
    return output;
  }

}



  //PARTIALLY WORKING CHECKPOINT
  //public int scanner(String input) {

//    counter = 0;
//    System.out.println("SCANNER INPUT: " + input);
//    int inputLength = input.length();
//    int returnVal = 0;
//
//    for (int i = 0; i < inputLength; i++) {
//
//      char thisChar = input.charAt(i);
//
//      if (thisChar == 'B') {
//        //Add B to equation
//
//        String subString = input.substring(i+5);
//        returnVal = 1 + scanner(subString);
//        counter = returnVal;
//        //System.out.println("ADD RETURN VAL: " + returnVal);
//        return returnVal;
//      }
//
//      if (thisChar == '(') {
//        //System.out.println("HIT THE (");
//        int braceCounter = 0;
//        char closingBrace = input.charAt(i);
//
//        while (closingBrace != ')') {
//          braceCounter++;
//          closingBrace = input.charAt(braceCounter);
//          //System.out.println("CLOSING BRACE: " + closingBrace);
//        }
//
//        String multiplierString = input.substring(i + 1, braceCounter);
//        int multiplier = Integer.parseInt(multiplierString);
//        //System.out.println("MULTIPLIER: " + multiplier);
//
//        String subString = input.substring(braceCounter + 1);
//        //System.out.println("MULT SUB STRING: " + subString);
//        //returnVal = multiplier * scanner(subString);
//
//        //if (scanner(subString) == 0) {
//        //returnVal = multiplier;
//        //} else {
//        returnVal = multiplier * scanner(subString);
//        //}
//
//        //System.out.println("MULT RETURN VAL: " + returnVal);
//        return returnVal;
//      }
//
//      if (thisChar == '}') {
//        String subString = input.substring(i+1);
//        scanner(subString);
//        return returnVal;
//        //break;
//      }
//    }
//    //System.out.println("RET VAL: " + returnVal);
//    return returnVal;
//  }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
