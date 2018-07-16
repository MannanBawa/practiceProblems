package Main;

import java.util.ArrayList;

public class TVTower {

  private ArrayList<Coordinate> coordList;


  public TVTower() {
    coordList = new ArrayList<>();
  }


  public double minRadius(int[] xInputs, int[] yInputs) {

    formalizeInput(xInputs, yInputs);
    //Make sure the DISTANCE between this point and the next is less than the allowed deviation

    ArrayList<Coordinate> homingList = coordList;
    if (homingList.size() != 1) {
      while (!pointsCoalesce(homingList, 1e-9)) {
        homingList = findCentralPoint(homingList);
      }
      Coordinate centralPoint = homingList.get(0);

      System.out.println("OTHER");
      radiusTester(centralPoint);
      double radius = distanceBetween(centralPoint, coordList.get(0));
      //System.out.println(radius);
      return radius;
    } else {
      Coordinate centralPoint = homingList.get(0);
      System.out.println("RADIUS TESTER");
      radiusTester(centralPoint);
      double radius = distanceBetween(centralPoint, coordList.get(0));
      //System.out.println(radius);
      return radius;
    }
  }



  private void formalizeInput(int[] xInputs, int[] yInputs) {

    for (int i = 0; i < xInputs.length; i++) {
      coordList.add(new Coordinate(xInputs[i], yInputs[i]));
    }

//    for (Coordinate coord : coordList) {
//      System.out.println("X: " + coord.getX() + " Y: " + coord.getY());
//    }

  }

  private double distanceBetween(Coordinate inCoord1, Coordinate inCoord2) {

    double x1 = inCoord1.getX();
    double y1 = inCoord1.getY();

    double x2 = inCoord2.getX();
    double y2 = inCoord2.getY();

    double xDiff = x2 - x1;
    double yDiff = y2 - y1;

    double xD2 = xDiff * xDiff;
    double yD2 = yDiff * yDiff;

    double output = Math.sqrt(xD2 + yD2);
    return output;
  }

  public Coordinate midPoint(Coordinate inCoord1, Coordinate inCoord2) {

    double x1 = inCoord1.getX();
    double y1 = inCoord1.getY();

    double x2 = inCoord2.getX();
    double y2 = inCoord2.getY();

    double xCoord = ((x1 + x2) / 2);
    double yCoord = ((y1 + y2) / 2);

    return new Coordinate(xCoord, yCoord);
  }

  private ArrayList<Coordinate> findCentralPoint(ArrayList<Coordinate> inputList) {

    ArrayList<Coordinate> outList = new ArrayList<>();

    if (inputList.size() == 1) {
      outList.add(inputList.get(0));
      return outList;
    }

    for (int i = 0; i < inputList.size(); i++) {
      if (i == inputList.size() - 1) {
        Coordinate newCoord = midPoint(inputList.get(i), inputList.get(0));
        outList.add(i, newCoord);
      } else {
        Coordinate newCoord = midPoint(inputList.get(i), inputList.get(i + 1));
        outList.add(i, newCoord);
      }
    } // end i-For

    return outList;
  }

  private boolean pointsCoalesce (ArrayList<Coordinate> inputList, double allowedDeviation) {

    //System.out.println("POINTS COALESCE");

    boolean[] pointsClose = new boolean[inputList.size()];
    int trueCount = 0;
    //allowedDeviation = 1e-9;

    for (int i = 0; i < inputList.size() - 1; i++) {

      Coordinate thisPoint = inputList.get(i);
      Coordinate nextPoint = inputList.get(i + 1);

      double distance = distanceBetween(thisPoint, nextPoint);

      if (distance < allowedDeviation) {
        //System.out.println("\n");
        //System.out.println("(" + thisPoint.getX() + "," + thisPoint.getY() + ")");
        //System.out.println("(" + nextPoint.getX() + "," + nextPoint.getY() + ")");
        pointsClose[i] = true;
        trueCount++;
      }
    }
    //System.out.println(trueCount == inputList.size() - 1);

    return (trueCount == inputList.size() - 1);

  }

  private void radiusTester(Coordinate centralPoint) {

    ArrayList<Coordinate> thisList = coordList;
    System.out.println("CENTRAL POINT: " + centralPoint.getX() + " , " + centralPoint.getY());

    double distanceAdder = 0;

    for (int i = 0; i < thisList.size(); i++) {
      Coordinate coord = thisList.get(i);
      double distance = distanceBetween(centralPoint, coord);
      System.out.println(distance);
      distanceAdder += distance;
      //System.out.println("(" + coord.getX() + " , " + coord.getY() + ")");
    }
    double avgDist = distanceAdder / thisList.size();
    System.out.println( "AVG: " + avgDist);

  }

}
