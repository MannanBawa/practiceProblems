import org.junit.Test;

import Main.Coordinate;
import Main.TVTower;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;


public class TVTowerTest {


  @Test
  public void test0() {
    TVTower thisTower = new TVTower();
    int[] xIn = {1, 0, -1, 0};
    int[] yIn = {0, 1, 0, -1};
    //System.out.print("BEFORE FUNC");
    //thisTower.minRadius(xIn, yIn);
    assertEquals(1, thisTower.minRadius(xIn,yIn), 1e-9);
  }

  @Test
  public void test1() {
    TVTower thisTower = new TVTower();
    int[] xIn = {3};
    int[] yIn = {299};
    //System.out.print("BEFORE FUNC");
    //thisTower.minRadius(xIn, yIn);
    assertEquals(0, thisTower.minRadius(xIn,yIn), 1e-9);
  }

  @Test
  public void test2() {
    TVTower thisTower = new TVTower();
    int[] xIn = {5, 3, -4, 2};
    int[] yIn = {0, 4, 3, 2};
    //System.out.print("BEFORE FUNC");
    //thisTower.minRadius(xIn, yIn);
    assertEquals(4.743416490252569, thisTower.minRadius(xIn,yIn), 1e-9);
  }

  @Test
  public void midPointTest() {
    TVTower thisTower = new TVTower();
    Coordinate firstCoord = new Coordinate(0, 1);
    Coordinate secondCoord = new Coordinate(1, 0);
    Coordinate midPoint = thisTower.midPoint(firstCoord, secondCoord);
    //System.out.print("BEFORE FUNC");
    assertEquals(0.5, midPoint.getX(), 0);
    assertEquals(0.5, midPoint.getY(), 0);
  }
}
