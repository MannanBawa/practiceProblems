import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void testTrueEven() {
        BinarySearch bS = new BinarySearch();
        int[] input = new int[10];
        input[0] = 1;
        input[1] = 2;
        input[2] = 3;
        input[3] = 4;
        input[4] = 5;
        input[5] = 6;
        input[6] = 7;
        input[7] = 8;
        input[8] = 9;
        input[9] = 10;
        boolean result = bS.doesExist(4, input);
        System.out.println(result);
    }

    @Test
    public void testFalseEven() {
        BinarySearch bS = new BinarySearch();
        int[] input = new int[10];
        input[0] = 1;
        input[1] = 2;
        input[2] = 3;
        input[3] = 4;
        input[4] = 5;
        input[5] = 6;
        input[6] = 8;
        input[7] = 8;
        input[8] = 9;
        input[9] = 10;
        boolean result = bS.doesExist(7, input);
        System.out.println(result);
    }

    @Test
    public void testTrueOdd() {
        BinarySearch bS = new BinarySearch();
        int[] input = new int[9];
        input[0] = 1;
        input[1] = 2;
        input[2] = 3;
        input[3] = 4;
        input[4] = 5;
        input[5] = 6;
        input[6] = 7;
        input[7] = 8;
        input[8] = 9;
        boolean result = bS.doesExist(4, input);
        System.out.println(result);
    }

    @Test
    public void testFalseOdd() {
        BinarySearch bS = new BinarySearch();
        int[] input = new int[9];
        input[0] = 1;
        input[1] = 2;
        input[2] = 3;
        input[3] = 4;
        input[4] = 5;
        input[5] = 6;
        input[6] = 8;
        input[7] = 8;
        input[8] = 9;
        boolean result = bS.doesExist(8, input);
        System.out.println(result);
    }





}
