import org.junit.Test;

public class QuickSortTest {

  @Test
  public void randomTest() {
    QuickSort thisQS = new QuickSort();
    int[] in = new int[8];
    in[0] = 7;
    in[1] = 4;
    in[2] = 5;
    in[3] = 8;
    in[4] = 2;
    in[5] = 1;
    in[6] = 3;
    in[7] = 6;

    int[] result = thisQS.newSortNums(in);
    System.out.println("--------------------------------\n---------------------------");
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }
}
