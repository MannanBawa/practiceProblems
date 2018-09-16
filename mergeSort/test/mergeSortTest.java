import org.junit.Test;

public class mergeSortTest {

  @Test
  public void testEvenAmount() {
    MergeSort thisMS = new MergeSort();
    int[] inputs = new int[8];
    inputs[0] = 6;
    inputs[1] = 5;
    inputs[2] = 3;
    inputs[3] = 1;
    inputs[4] = 8;
    inputs[5] = 7;
    inputs[6] = 2;
    inputs[7] = 4;



    int[] sorted = thisMS.sortNums(inputs);
    for (int i=0; i< sorted.length; i++) {
      System.out.println(sorted[i]);
    }
  }

  @Test
  public void testOddAmount() {
    MergeSort thisMS = new MergeSort();
    int[] inputs = new int[9];
    inputs[0] = 6;
    inputs[1] = 5;
    inputs[2] = 3;
    inputs[3] = 1;
    inputs[4] = 8;
    inputs[5] = 7;
    inputs[6] = 2;
    inputs[7] = 4;
    inputs[8] = 10;



    int[] sorted = thisMS.sortNums(inputs);
    for (int i=0; i< sorted.length; i++) {
      System.out.println(sorted[i]);
    }
  }



}
