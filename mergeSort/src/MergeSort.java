import java.util.Stack;

public class MergeSort {

  public int[] sortNums(int[] inputArray) {

    int inputLength = inputArray.length;

    if (inputLength < 2) {
      return inputArray;
    } else if (inputLength == 2) {
      if (inputArray[0] > inputArray[1]) {
        int temp = inputArray[0];
        inputArray[0] = inputArray[1];
        inputArray[1] = temp;
        return inputArray;
      } else {
        return inputArray;
      }
    } else if (inputLength > 2) {
      int halfIndex = Math.floorDiv(inputLength, 2);

      int[] firstHalf = new int[0];
      int[] secondHalf = new int[0];

      if (inputLength % 2 == 0) {

        firstHalf = new int[halfIndex];
        secondHalf = new int[halfIndex];

        for (int i = 0; i < halfIndex; i++) {
          firstHalf[i] = inputArray[i];
          secondHalf[i] = inputArray[halfIndex + i];
        }

      } else if (inputLength % 2 == 1) {

        firstHalf = new int[halfIndex + 1];
        secondHalf = new int[halfIndex];

        for (int i = 0; i < halfIndex + 1; i++) {
          firstHalf[i] = inputArray[i];
          if (i < halfIndex) {
            secondHalf[i] = inputArray[halfIndex + i + 1];
          }
        }
      }

      int[] sortedFirstHalf = sortNums(firstHalf);
      int[] sortedSecondHalf = sortNums(secondHalf);

      int [] merged = merge(sortedFirstHalf, sortedSecondHalf);

      return merged;
    } else {
      throw new IllegalArgumentException("How could this be a number that's not greater than 2?");
    }
  }


  public int[] merge(int[] arrOne, int[] arrTwo) {

    int arrOneLength = arrOne.length;
    int arrTwoLength = arrTwo.length;
    int arrIndex = 0;
    int[] mergedArr = new int[arrOneLength + arrTwoLength];
    Stack<Integer> stackOne;
    Stack<Integer> stackTwo;

    stackOne = new Stack<Integer>();
    stackTwo = new Stack<Integer>();

    for (int i = arrOneLength - 1; i > -1; i--) {
      int thisInteger = arrOne[i];
      stackOne.push(thisInteger);
    }

    for (int i = arrTwoLength - 1; i > -1; i--) {
      stackTwo.push(arrTwo[i]);
    }

    arrOne = null;
    arrTwo = null;

    while (!stackOne.isEmpty() && !stackTwo.isEmpty()) {
      if ((int)stackOne.peek() <= (int)stackTwo.peek()) {
        int thisNum = (int)stackOne.pop();
        mergedArr[arrIndex] = thisNum;
        arrIndex++;
      } else if ((int)stackOne.peek() > (int)stackTwo.peek()) {
        int thisNum = (int)stackTwo.pop();
        mergedArr[arrIndex] = thisNum;
        arrIndex++;
      }
    }

    if (stackOne.isEmpty()) {
      while (!stackTwo.isEmpty()) {
        int thisNum = (int)stackTwo.pop();
        mergedArr[arrIndex] = thisNum;
        arrIndex++;
      }
    } else if (stackTwo.isEmpty()) {
      while (!stackOne.isEmpty()) {
        int thisNum = (int)stackOne.pop();
        mergedArr[arrIndex] = thisNum;
        arrIndex++;;
      }
    }

    if (stackOne.isEmpty() && stackTwo.isEmpty()) {
      //System.out.println("BOTH STACKS EMPTIED");
      return mergedArr;
    }
    return mergedArr;
  }
}
