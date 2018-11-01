using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AlphaDiceTest
{
    class Program
    {
        static void Main(string[] args)
        {
            testZero();
            testOne();
            testTwo();
            testThree();
            testFour();
            Console.ReadLine();
        }

        private static void testZero()
        {
            alphaDice.AlphaDice thisAD = new alphaDice.AlphaDice();
            String[] rolls = new String[] { "ABC", "ZCB" };
            int result = thisAD.badData(rolls);

            Console.WriteLine("-------Test Zero-------");
            Console.Write("\nInput");
            for (int i = 0; i < rolls.Length; i++)
            {
                Console.Write(rolls[i] + " ");
            }
            Console.WriteLine("Expected output: -1");
            Console.WriteLine("Actual output: " + result);
        }

        private static void testOne()
        {
            alphaDice.AlphaDice thisAD = new alphaDice.AlphaDice();
            String[] rolls = new String[] { "ABC", "DEF", "BCA", "GHI", "ABC" };
            int result = thisAD.badData(rolls);

            Console.WriteLine("-------Test One-------");
            Console.Write("\nInput");
            for (int i = 0; i < rolls.Length; i++)
            {
                Console.Write(rolls[i] + " ");
            }
            Console.WriteLine("Expected output: 3");
            Console.WriteLine("Actual output: " + result);
        }

        private static void testTwo()
        {
            alphaDice.AlphaDice thisAD = new alphaDice.AlphaDice();
            String[] rolls = new String[] { "ABA", "CDE", "CDE", "CDE", "CDE" };
            int result = thisAD.badData(rolls);

            Console.WriteLine("-------Test Two-------");
            Console.Write("\nInput");
            for (int i = 0; i < rolls.Length; i++)
            {
                Console.Write(rolls[i] + " ");
            }
            Console.WriteLine("Expected output: 0");
            Console.WriteLine("Actual output: " + result);
        }

        private static void testThree()
        {
            alphaDice.AlphaDice thisAD = new alphaDice.AlphaDice();
            String[] rolls = new String[] { "ABC", "DEF", "BCF" };
            int result = thisAD.badData(rolls);

            Console.WriteLine("-------Test Three-------");
            Console.Write("\nInput");
            for (int i = 0; i < rolls.Length; i++)
            {
                Console.Write(rolls[i] + " ");
            }
            Console.WriteLine("Expected output: 2");
            Console.WriteLine("Actual output: " + result);
        }

        private static void testFour()
        {
            alphaDice.AlphaDice thisAD = new alphaDice.AlphaDice();
            String[] rolls = new String[] { "ABC", "DEF", "ADF" };
            int result = thisAD.badData(rolls);

            Console.WriteLine("-------Test Three-------");
            Console.Write("\nInput");
            for (int i = 0; i < rolls.Length; i++)
            {
                Console.Write(rolls[i] + " ");
            }
            Console.WriteLine("Expected output: 2");
            Console.WriteLine("Actual output: " + result);
        }
    }
}
