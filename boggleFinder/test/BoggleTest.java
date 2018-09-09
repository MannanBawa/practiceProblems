import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoggleTest {


  @Test
  public void testFARM() {
    Boggle game = new Boggle();
    boolean answer = game.doesExist("FARM");
    assertEquals(true, answer);
  }

  @Test
  public void testFARMER() {
    Boggle game = new Boggle();
    boolean answer = game.doesExist("FARMER");
    assertEquals(true, answer);
  }

  @Test
  public void testFARMERS() {
    Boggle game = new Boggle();
    boolean answer = game.doesExist("FARMERS");
    assertEquals(true, answer);
  }

  @Test
  public void failTestFARMERX() {
    Boggle game = new Boggle();
    boolean answer = game.doesExist("FARMERX");
    assertEquals(false, answer);
  }

  @Test
  public void testRABES() {
    Boggle game = new Boggle();
    boolean answer = game.doesExist("RABES");
    assertEquals(true, answer);
  }

  @Test
  public void testPQGP() {
    Boggle game = new Boggle();
    boolean answer = game.doesExist("PQGP");
    assertEquals(true, answer);
  }

  @Test
  public void failTestPQGPG() {
    Boggle game = new Boggle();
    boolean answer = game.doesExist("PQGPG");
    assertEquals(false, answer);
  }

  @Test
  public void testPFAS() {
    Boggle game = new Boggle();
    boolean answer = game.doesExist("PFAS");
    assertEquals(true, answer);
  }

  @Test
  public void testPAESEB() {
    Boggle game = new Boggle();
    boolean answer = game.doesExist("PAESEB");
    assertEquals(true, answer);
  }

  @Test
  public void testPQGPMP() {
    Boggle game = new Boggle();
    boolean answer = game.doesExist("PQGPMP");
    assertEquals(false, answer);
  }
}
