import java.util.ArrayList;

public class QuickSort {


  public static int[] sortNums (int[] inArr) {

    int inputLength = inArr.length;
    int[] outArr = inArr;
    System.out.println("-----------------------------------");

    for (int i = 0; i < inputLength; i++) {
      System.out.println(inArr[i]);
    }

    if (inputLength <= 1) {
      return outArr;
    }

    int pivot = outArr[inputLength - 1];
    int wallIndex = 0;

    for (int i = 0; i < inputLength; i++) {
      int thisItem = outArr[i];

      if (thisItem < pivot) {
        int temp = outArr[i];
        outArr[i] = outArr[wallIndex];
        outArr[wallIndex] = temp;
        wallIndex++;
      }
    }

    int pivotTemp = outArr[wallIndex];
    outArr[wallIndex] = outArr[inputLength-1];
    outArr[inputLength - 1] = pivotTemp;

    int[] leftSide = new int[wallIndex];
    int[] rightSide = new int[inputLength - wallIndex];

    for (int i = 0; i < wallIndex; i++) {
      leftSide[i] = outArr[i]    ;
    }

    int rightSize = inputLength - wallIndex;

    for (int i = 0; i < rightSize; i++) {
      rightSide[i] = outArr[wallIndex + i];
    }

    int[] sortedLeft = sortNums(leftSide);
    int[] sortedRight = sortNums(rightSide);

    for (int i = 0; i < sortedLeft.length; i++) {
      outArr[i] = sortedLeft[i];
    }

    for (int i = 0; i < sortedRight.length; i++) {
      outArr[sortedLeft.length + i] = sortedRight[i];
    }

    return outArr;
  }
}
