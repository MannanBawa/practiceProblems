using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace quickSort
{
    class Program
    {
        static void Main(string[] args)
        {
            string inputSize;
            Console.WriteLine("Enter the number of elements to sort: ");
            inputSize = Console.ReadLine();
            Console.WriteLine("You entered " + inputSize);
            Int32.TryParse(inputSize, out int arrSize);

            int[] inputArr = new int[arrSize];

            for (int i = 0; i < arrSize; i++)
            {
                Console.WriteLine("Please enter the value of element " + i + ": ");
                string inputVal = Console.ReadLine();
                Int32.TryParse(inputVal, out int thisVal);
                inputArr[i] = thisVal;
            }

            Console.WriteLine("All input values taken in");

            for (int i = 0; i < arrSize; i++)
            {
                Console.Write(inputArr[i] + " ");
            }

            int[] outArr = new int[arrSize];
            outArr = quickSortNums(inputArr);

            Console.WriteLine("SORTED");

            for (int i = 0; i < arrSize; i++)
            {
                Console.Write(outArr[i] + " ");
            }

            Console.ReadLine();
        }

        public static int[] quickSortNums(int[] inputArr) {

            int inputLength = inputArr.Length;
            int[] outArr = inputArr;

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
            outArr[wallIndex] = outArr[inputLength - 1];
            outArr[inputLength - 1] = pivotTemp;

            int[] leftSide = new int[wallIndex];
            int[] rightSide = new int[inputLength - wallIndex];

            for (int i = 0; i < wallIndex; i++)
            {
                leftSide[i] = outArr[i];
            }

            int rightSize = inputLength - wallIndex;

            for (int i = 0; i < rightSize; i++)
            {
                rightSide[i] = outArr[wallIndex + i];
            }

            int[] sortedLeft = quickSortNums(leftSide);
            int[] sortedRight = quickSortNums(rightSide);

            for (int i = 0; i < sortedLeft.Length; i++)
            {
                outArr[i] = sortedLeft[i];
            }

            for (int i = 0; i < sortedRight.Length; i++)
            {
                outArr[sortedLeft.Length + i] = sortedRight[i];
            }

            return outArr;
        }
    }
}


