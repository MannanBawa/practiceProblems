package Main;

/* Solution to Top Coder Problem found at the following link:
https://arena.topcoder.com/#/u/practiceCode/1338/2141/2309/1/1338

Difficulty - Medium
 */

import java.util.ArrayList;
import java.util.HashMap;

public class LunchScheduler {

  ArrayList<Employee> employees;
  ArrayList<Handshake> handshakes;

  public LunchScheduler() {
    employees = new ArrayList<Employee>();
    handshakes = new ArrayList<Handshake>();
  }

  public int getOverlap(String[] M) {

    int[][] formalizedInput = formalizeInput(M);
    HashMap shakesPerRow = countShakesPerRow(formalizedInput);
    HashMap rowCheckOrder = createCheckOrder(shakesPerRow);

    checkRowsForHandshakes(formalizedInput, rowCheckOrder);

    removeDuplicateHandshakes();

    int[] shakeArray = getShakesPerEmployee();
    int maxVal = getMax(shakeArray);

    return maxVal + 1;
  }





  //DONE - print off
  private int[][] formalizeInput(String[] input) {

    int [][] output = new int[input.length][input[0].length()];

    for (int i = 0; i < input.length; i++) {
      for(int j = 0; j < input[0].length(); j++) {
        char thisChar = input[i].charAt(j);
        output[i][j] = Character.getNumericValue(thisChar);
      }
    }


//    for (int i = 0; i < input.length; i++) {
//      for(int j = 0; j < input[0].length(); j++) {
//        System.out.print(output[i][j]);
//      }
//      System.out.print("\n");
//    }


    return output;
  }

  //DONE - print off
  private int[][] reverseInput(int[][] input) {
    //Assumes input is a square matrix
    int[][] output = new int[input.length][input[0].length];


    //Go down row by row
    for (int k = 0; k < output.length; k++) {
      //Go column by column
      for (int i = 0; i < output[k].length; i++) {
        int val = input[k].length - 1 - i;
        //System.out.print(" " + k + "," + val + " " + k + "," + i + "\n");
        output[k][i] = input[k][val];
      }
      //System.out.print("\n");
    }

//
//    for (int i = 0; i < output.length; i++) {
//      for(int j = 0; j < output[0].length; j++) {
//        System.out.print(output[i][j]);
//      }
//      System.out.print("\n");
//    }


    return output;
  }

  //DONE - print off
  private boolean[][] reverseInput(boolean[][] input) {
    //Assumes input is a square matrix
    boolean[][] output = new boolean[input.length][input[0].length];


    //Go down row by row
    for (int k = 0; k < output.length; k++) {
      //Go column by column
      for (int i = 0; i < output[k].length; i++) {
        int val = input[k].length - 1 - i;
        //System.out.print(" " + k + "," + val + " " + k + "," + i + "\n");
        output[k][i] = input[k][val];
      }
      //System.out.print("\n");
    }

//
//    for (int i = 0; i < output.length; i++) {
//      for(int j = 0; j < output[0].length; j++) {
//        System.out.print(output[i][j]);
//      }
//      System.out.print("\n");
//    }


    return output;
  }

  //DONE - print off
  private boolean[][] setFalseFromBack(int[][] input, boolean[][] outputTemplate) {

    for (int row = 0; row < input.length ; row++) {
      int col = 0;
      while (col < input[row].length && input[row][col] == 0) {
        //while (col < input[0].length) {
        //System.out.print("IN WHILE");
        //System.out.println(row + "," + col);
        outputTemplate[row][col] = false;
        col++;
      }
    }

    return outputTemplate;
  }

  //DONE - print off
  private HashMap countShakesPerRow(int[][] input) {

    HashMap shakesPerRow = new HashMap<>();

    for (int row = 0; row < input.length; row++) {
      int shakeCounter = 0;
      for (int col = 0; col < input[row].length; col++) {
        if (input[row][col] == 1) {
          shakeCounter++;
        }
      }
      //output[row] = shakeCounter;
      shakesPerRow.put(row, shakeCounter);
    }

//    //Print loop
//    for (int i = 0; i < shakesPerRow.size(); i++) {
//      System.out.println("Row:" + i + " Has " + shakesPerRow.get(i) + " shakes");
//    }

    return shakesPerRow;
  }

  //DONE
  private int countShakesInRow(int[] input) {

    int shakeCounter = 0;
    for (int col = 0; col < input.length; col++) {
      if (input[col] == 1) {
          shakeCounter++;
      }
    }
    return shakeCounter;
  }

  //DONE - print on
  private HashMap createCheckOrder(HashMap input) {

    HashMap output = input;
//    HashMap output = new HashMap();

    int minimumValue = (int) input.get(0);
    int minimumKey = 0;

    //System.out.println("Min-Row:" + minimumKey + " Has " + minimumValue + " shakes");

    for (int i = 0; i < input.size() - 1; i++) {

      for (int j = 0; j < input.size() - i - 1; j++) {

        int thisValue = (int) input.get(j);
        int nextValue = (int) input.get(j + 1);

        if (thisValue > nextValue) {
          output.put(j, nextValue);
          output.put(j + 1, thisValue);
        }
      }
    }


//    //Print loop
//    for (int i = 0; i < output.size(); i++) {
//      System.out.println(i + ": Row with " + output.get(i) + " shakes");
//    }

    return output;
  }

  //DONE - print on
  private void checkRowsForHandshakes(int[][] rowData, HashMap handshakeCheckOrder) {

    //Create and Emloyee for each row
    for (int i = 0; i < rowData.length; i++) {
      Employee newEmployee = new Employee(i);
      employees.add(newEmployee);
    }

    int rowsChecked = 0;
    boolean[] thisRowChecked = new boolean[rowData.length];

    while (rowsChecked != rowData.length) {

      for (int row = 0; row < rowData.length; row++) {
        int numShakesInRow = countShakesInRow(rowData[row]);
        //System.out.println("ROWS CHECKED = " + rowsChecked);

        if (numShakesInRow == (int) handshakeCheckOrder.get(rowsChecked) &&
                !thisRowChecked[row]) {

          //Create Employees and Handshakes
          Employee thisEmployee = employees.get(row);

          //Go down the columns, shaking hands
          for (int col = 0; col < rowData[row].length; col++) {
            Employee otherEmployee = employees.get(col);
            if (rowData[row][col] == 1) {
              Handshake thisHandshake = thisEmployee.shakeHands(otherEmployee);
              handshakes.add(thisHandshake);
            }
          }
          rowsChecked++;
          thisRowChecked[row] = true;
          if (rowsChecked == rowData.length) {
            break;
          }
        }

      }
    }
  }

  private void removeDuplicateHandshakes() {

    for (int i = 0; i < handshakes.size(); i++) {
      Handshake thisHandshake = handshakes.get(i);

      for (int j = i; j < handshakes.size(); j++) {
        Handshake otherHandshake = handshakes.get(j);

        if (thisHandshake.reverseEquals(otherHandshake)) {
          handshakes.remove(j);
        }
      }
    }
  }

  private int[] getShakesPerEmployee() {

    int[] outputShakes = new int[employees.size()];

    for (int j = 0; j< employees.size(); j++) {

      Employee thisEmployee = employees.get(j);
      int thisEmpShakes = 0;

      for (int i = 0; i < handshakes.size(); i++) {
        Handshake thisShake = handshakes.get(i);
        if (thisShake.getShaker1().equals(thisEmployee)) {
          thisEmpShakes++;
        }
      }
      outputShakes[j] = thisEmpShakes;
    }
//
//    for (int x = 0; x < outputShakes.length; x++) {
//      System.out.println(outputShakes[x]);
//    }

    return outputShakes;
  }

  private int getMax(int[] input) {
    int maxVal = input[0];

    for (int i = 0; i < input.length; i++) {
      if (input[i] > maxVal) {
        maxVal = input[i];
      }
    }
    return maxVal;
  }



  public void printHandshakes() {
    for (Handshake shake : handshakes) {
      System.out.println(shake);
    }
  }

  public void printEmployees() {
    for (Employee emp : employees) {
      System.out.println(emp);
    }
  }

  //DONE - print off
  public String[] reverseInput(String[] input) {
    String[] output = input;

    for (int i = 0; i < output.length; i++) {
      output[i] = new StringBuilder(output[i]).reverse().toString();
    }

//
//    for (String row : output) {
//      System.out.println(row);
//    }

    return output;
  }

  /**
   * Takes the reversed number matrix as input. Marks all as true by default.
   * Then iterates, marking every spot associated with a 0 as F, until the first 1 is found per row.
   * Then reverses it again, iterating: marking every spot with 0 as F, until the first 1 is found.
   * Returns this final array.
   * @param input
   * @return
   */
  //DONE - print off
  public boolean[][] generateBooleanMatrix(int[][] input) {

    //Assumes input is a square matrix

    boolean[][] output = new boolean[input.length][input[0].length];
    //System.out.println("IN GEN BOOL");

    //Set all values to a default true
    for (int i = 0; i < output.length; i++) {
      for (int j = 0; j < output[0].length; j++) {
        output[i][j] = true;
      }
    }

    //Set False from the back
    output =  setFalseFromBack(input, output);

    //Reverse Out and In Arrays
    output = reverseInput(output);
    int[][]realInput = reverseInput(input);

    //Set False from the back
    output =  setFalseFromBack(realInput, output);

//    //Print loop
//    for (int i = 0; i < output.length; i++) {
//      for(int j = 0; j < output[0].length; j++) {
//        System.out.print(output[i][j] + ", ");
//      }
//      System.out.print("\n");
//    }


    return output;
  }

  //DONE - print off
  public int[] countTruesPerColumn(boolean[][] input){

    int[] outArray = new int[input[0].length];

    for (int col = 0; col < input[0].length; col++) {
      for (int row = 0; row < input.length; row++) {
        if (input[row][col]) {
          outArray[col]++;
        }
      }
    }
//
//    //Print loop
//    for (int x : outArray) {
//      System.out.print(x + " ");
//    }


    return outArray;
  }




}
