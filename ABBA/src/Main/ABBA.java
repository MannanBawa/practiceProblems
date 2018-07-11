package Main;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;


/* Solution to Top Coder Problem found at the following link:
https://arena.topcoder.com/#/u/practiceCode/16527/48825/13918/2/326683

Difficulty - Medium
 */



public class ABBA {

  //HashMap<String, Boolean> Q = new HashMap<String, Boolean>();
  private ArrayList<String> stringQ;
  private ArrayList<Boolean> checkedQ;

  public ABBA() {
    stringQ = new ArrayList<String>();
    checkedQ = new ArrayList<Boolean>();
  }



  public String canObtain(String initial, String target) {

    stringQ.add(initial);
    checkedQ.add(0, false);
    System.out.println("INITIAL: " + initial);


    for (int i = 0; i < stringQ.size(); i++) {

      String thisVal = stringQ.get(i);
      String thisValA = addA(thisVal);
      String thisValRB = reverseAddB(thisVal);

      if (!thisVal.equals(target) && !checkedQ.get(i) ) {

        if (thisValA.equals(target) || thisValRB.equals(target)) {
          return "Possible";
        }

          //Adding the value + A to the Queue
          stringQ.add(thisValA);
          //System.out.println(thisValA);
          checkedQ.add(false);

          //Adding the reverse + B to the Queue
          stringQ.add(thisValRB);
          //System.out.println(thisValRB);
          checkedQ.add(false);

          checkedQ.add(i, true);
        }

        if (thisValA.length() > target.length()) {
          checkedQ.add(i, true);
          //break;
          return "Impossible";
          //System.out.println
          // ("------------------------------------------------------------------");
        }
      }
    //return "Impossible";
    return "Impossible";
  }

  public String addA(String input){
    return input + "A";
  }

  public String addB(String input) {
    return input + "B";
  }

  public String reverse(String input) {
    return new StringBuilder(input).reverse().toString();
  }

  public String reverseAddB (String input) {
    String output = reverse(input);
    return addB(output);
  }

  public void Dump() {

    while(!stringQ.isEmpty()) {
      stringQ.remove(0);
    }

    while(!checkedQ.isEmpty()) {
      checkedQ.remove(0);
    }

    System.out.println("STRING: " + stringQ.size() + " CHECK: " + checkedQ.size());

    }

}
