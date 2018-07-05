package Main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class TallPeople {

  public int[] getPeople(String[] people) {
    ArrayList<ArrayList> set = new ArrayList<>();

    for (int i = 0; i < people.length; i++) {
      ArrayList row = new ArrayList();
      Scanner scan = new Scanner(people[i]);
      while (scan.hasNext()) {
        row.add(Integer.parseInt(scan.next()));
      }
      set.add(i, row);
      scan.close();
    }
    //System.out.println(set);
    ArrayList listOfShortest = findShortestFromRows(set);
    int tallestFromShortest = findLargestNumber(listOfShortest);

    ArrayList listOfTallest = findTallestFromCols(set);
    int shortestFromTallest = findSmallestNumber(listOfTallest);

    int returnVal[] = {tallestFromShortest, shortestFromTallest };
    //System.out.println(tallestFromShortest + " " + shortestFromTallest);
    return returnVal;

  }

  private ArrayList findShortestFromRows(ArrayList<ArrayList> set) {
    ArrayList prospectiveShorties = new ArrayList();
    for (int i = 0; i < set.size(); i++) {
      ArrayList thisRow = set.get(i);
      prospectiveShorties.add(i, findSmallestNumber(thisRow));
    }
    return prospectiveShorties;
  }

  private ArrayList findTallestFromCols(ArrayList<ArrayList> set) {
    ArrayList prospectiveTalls = new ArrayList();
    int numberOfCols = set.get(0).size();
    for (int i = 0; i < numberOfCols; i++) {
      ArrayList thisColVals = new ArrayList();
      for (int j = 0; j < set.size(); j++) {
        thisColVals.add(set.get(j).get(i));
      }
      prospectiveTalls.add(i, findLargestNumber(thisColVals));
    }
    return prospectiveTalls;
  }



  private int findSmallestNumber(ArrayList fromThis) {
    int smallest = (int) fromThis.get(0);

    for (int i = 0; i < fromThis.size(); i++) {
      if ((int) fromThis.get(i) < smallest) {
        smallest = (int) fromThis.get(i);
      }
    }
    return smallest;
  }

  private int findLargestNumber(ArrayList fromThis) {
    int largest = (int) fromThis.get(0);

    for (int i = 0; i < fromThis.size(); i++) {
      if ((int) fromThis.get(i) > largest) {
        largest = (int) fromThis.get(i);
      }
    }
    return largest;
  }
}