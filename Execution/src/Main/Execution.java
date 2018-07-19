package Main;

import java.util.Scanner;

public class Execution {


  int counter;
  int newestTimes;

  public Execution() {
    counter = 0;
    newestTimes = 1;
  }


  public long analyze(String[] code) {

    //int counter = 0;
    String formalizedInput = formalizeInput(code);
    System.out.println("INPUT: " + formalizedInput + "\n\n");
    int testOut = scanner(formalizedInput);
    System.out.println("TEST OUTPUT: " + testOut);


    //Scanner scan = new Scanner(formalizedInput);
    //scan.useDelimiter(";");

//    while (scan.hasNext()) {
//      String thisScan = scan.next();
//
//      scanString(thisScan);
//
//    }
    //System.out.println("\n" + counter);
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

      if (thisChar == '('){
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

        while ((thisChar != '}') && ((i + placesForward) < input.length() - 1) ) {
          placesForward++;
          thisChar = input.charAt(i + placesForward);
        }
        String thisSubString = input.substring(i + 1, i + placesForward);
        scanString(thisSubString);
      }
    }
  }

  public int scanner(String input) {

    System.out.println("SCANNER INPUT: " + input);
    int inputLength = input.length();
    int returnVal = 0;

    for (int i = 0; i < inputLength; i++) {

      char thisChar = input.charAt(i);
      //System.out.println(thisChar);


      if (thisChar == '{') {
        //Test Substring so you know how it works well
        //System.out.println("{ - TERM: " + input.substring(i+1));
        String subString = input.substring(i+1);
        //System.out.println("OPENING BRACE VAL: " + returnVal);
        scanner(subString);
      }

      if (thisChar == 'B') {
        //Add B to equation
        //System.out.println("B-TERM: " + input.substring(i + 6));
        String subString = input.substring(i+5);
        returnVal = 1 + scanner(subString);

        //System.out.println("ADD RETURN VAL: " + returnVal);
        return returnVal;
      }

      if (thisChar == '(') {
        //System.out.println("HIT THE (");
        int braceCounter = 0;
        char closingBrace = input.charAt(i);

        while (closingBrace != ')') {
          braceCounter++;
          closingBrace = input.charAt(braceCounter);
          //System.out.println("CLOSING BRACE: " + closingBrace);
        }

        String multiplierString = input.substring(i + 1, braceCounter);
        int multiplier = Integer.parseInt(multiplierString);
        //System.out.println("MULTIPLIER: " + multiplier);

        String subString = input.substring(braceCounter + 1);
        //System.out.println("MULT SUB STRING: " + subString);
        returnVal = multiplier * scanner(subString);
        //System.out.println("MULT RETURN VAL: " + returnVal);
        return returnVal;
      }

      if (thisChar == '}') {
        String subString = input.substring(i+1);
        scanner(subString);
        return returnVal;
      }
    }
    return returnVal;
  }






















}
