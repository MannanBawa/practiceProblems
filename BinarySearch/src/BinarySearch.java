public class BinarySearch {

    int forCounter;

    public BinarySearch() {
        forCounter = 0;
    }

    //returns true if the input number exists in the inputArray, false if not
    // since it's binarySearch it obviously assumes that the array is pre sorted,
    // it will not function correctly if the array is not pre sorted.
    public boolean doesExist(int numToFind, int[] inputArray) {

        int inputArrayLength = inputArray.length;
        int middleIndex = Math.floorDiv(inputArrayLength, 2);
//        System.out.println("Middle Index:" + middleIndex);
        System.out.println("Length: " + inputArrayLength);

        if (inputArrayLength == 1) {
            return (inputArray[0] == numToFind);
        } if (inputArrayLength > 1) {
            int middleValue = inputArray[middleIndex];
//            System.out.println("\tMiddle Value:" + middleValue);

            if (middleValue == numToFind) {
                return true;
            }
            else if (numToFind < middleValue) {
                System.out.println("LEFT SIDE");
                int[] leftHalf = new int[middleIndex];

                for (int i = 0; i < middleIndex; i++) {
                    leftHalf[i] = inputArray[i];
                }
                return doesExist(numToFind, leftHalf);
            }
            else if (numToFind > middleValue) {
                System.out.println("RIGHT SIDE");
                int[] rightHalf = new int[middleIndex];
                System.out.println("\tMIDDLE INDEX: " + middleIndex);
                for (int i = 0; i < middleIndex; i++) {
                    rightHalf[i] = inputArray[middleIndex + i];
                    System.out.println("\tRIGHT HALF VAL:" + rightHalf[i]);
                }
                return doesExist(numToFind, rightHalf);
            } else {
                return false;
            }
        }
        return false;
    }

    //this might be too complicated for now, try just checking out like, doing a binary word search or some shit dog
    public void findIndex(int numToFind, int[] inputArray){};

}
