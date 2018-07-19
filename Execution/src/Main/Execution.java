package Main;

import java.util.Scanner;

public class Execution {




  public Execution() { }


  public long analyze(String[] code) {

    int counter = 0;


    String formalizedInput = formalizeInput(code);
    Scanner scan = new Scanner(formalizedInput);
    scan.useDelimiter(";");

    while (scan.hasNext()) {
      String thisScan = scan.next();

      for (int i = 0; i < thisScan.length(); i++) {
        char thisChar = thisScan.charAt(i);
        if (thisChar == 'B') {
          counter++;
        }

        if (thisChar == '('){
          int placesForward = 0;

          while (thisChar != ')') {
            placesForward++;
            thisChar = thisScan.charAt(i + placesForward);
          }
          String thisSubString = thisScan.substring(i + 1, i + placesForward);
          int times = Integer.parseInt(thisSubString);
          System.out.println("\t\t\ttimes:" + times);

        }
      }

      System.out.println(thisScan);

      //if (thisScan.charAt(0) == 'B') {
        //System.out.println(thisScan.charAt(0) + scan.next());
      //}


    }
    System.out.println("\n" + counter);
    return counter;
  }

  //DONE
  public String formalizeInput(String[] input) {

    StringBuilder outputString = new StringBuilder();

    for (String thisString : input) {
      outputString.append(thisString);
    }

    return outputString.toString();
  }

  public void scan(String[] input) {




  }
}
