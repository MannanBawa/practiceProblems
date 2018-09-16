import org.junit.Test;

import Main.Execution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

public class ExecutionTest {

  @Test
  public void test0() {
    Execution thisExecution = new Execution();
    String[] input = {"BASIC;for(10){BASIC;}"};
    //thisExecution.analyze(input);
    assertEquals(11, thisExecution.analyze(input));
  }

//  @Test
//  public void testHalf() {
//    Execution thisExecution = new Execution();
//    String[] input = {"BASIC;for(10){BASIC;BASIC;}"};
//    //thisExecution.analyze(input);
//    assertEquals(21, thisExecution.analyze(input));
//    System.out.println("READOUT: " + thisExecution.readout);
//  }

  @Test
  public void test1() {
    Execution thisExecution = new Execution();
    String[] input = {"BASIC;" ,"for(10){" ," for(100){}" ," BASIC;" ," for(20){" ," BASIC;" ," " +
            "BASIC;" ," }" ," BASIC;" ,"}"};
    //thisExecution.analyze(input);
    //System.out.println("READOUT: " thisExecution.readout);
    assertEquals(421, thisExecution.analyze(input));

  }

  @Test
  public void test2() {
    Execution thisExecution = new Execution();
    String[] input = {"for(0){}"};
    //thisExecution.analyze(input);
    assertEquals(0, thisExecution.analyze(input));
  }

  @Test
  public void test3() {
    Execution thisExecution = new Execution();
    String[] input = {"for(10900){}BASIC;"};
    //thisExecution.analyze(input);
    assertEquals(1, thisExecution.analyze(input));
  }

//  @Test
//  public void test4() {
//    Execution thisExecution = new Execution();
//    String[] input = {"for(2){for(2){for(2){for(2){for(2){for(2){for(2){" ,"for(2){for(2){for(2)" +
//            "{for(2){for(2){for(2){for(2){" ,"for(2){for(2){for(2){for(2){for(2){for(2){for(2){"
//            ,"for(2){for(2){for(2){for(2){for(2){for(2){for(2){" ,"for(2){for(2){for(2){for(2)" +
//            "{for(2){for(2){for(2){" ,"for(2){for(2){for(2){for(2){for(2){for(2){for(2){" ,"for" +
//            "(2){for(2){for(2){for(2){for(2){for(2){for(2){" ,"for(2){for(2){for(2){for(2){for(2)" +
//            "{for(2){for(2){" ,"BASIC;" ,"}}}}}}}}}}}}}}}}}}}}}}}}}}}}" ,
//            "}}}}}}}}}}}}}}}}}}}}}}}}}}}}"};
//    //thisExecution.analyze(input);
//    //assertEquals(72057594037927936, thisExecution.analyze(input));
//  }

  @Test
  public void test5() {
    Execution thisExecution = new Execution();
    String[] input = {"for(0){}" ,"for(1)" ,"{BASIC;" ,"for(5){BASIC;}" ,"for(2){BASIC;}" ,
            "BASIC;" ," for" ,"( 3 ){BASIC;}}"};
    //thisExecution.analyze(input);
    assertEquals(12, thisExecution.analyze(input));
  }

  @Test
  public void test6() {
    Execution thisExecution = new Execution();
    String[] input = {"BASIC;for(7){for(3){}for(0){BASIC;}}"};
    //thisExecution.analyze(input);
    assertEquals(1, thisExecution.analyze(input));
  }

//  @Test
//  public void test7() {
//    Execution thisExecution = new Execution();
//    String[] input = {"for(9223372036854775807){BASIC;}"};
//    thisExecution.analyze(input);
//    //assertEquals(9223372036854775807, thisExecution.analyze(input));
//  }

  @Test
  public void setGetterTest() {
    Execution thisExecution = new Execution();
    String[] input = {"BASIC;for(7){for(3){}for(0){BASIC;}}"};
    String formalInput = thisExecution.formalizeInput(input);
    thisExecution.setGetter(formalInput);

  }




}
