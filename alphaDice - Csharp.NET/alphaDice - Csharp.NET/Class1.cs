using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

//https://arena.topcoder.com/index.html#/u/practiceCode/1297/1643/1761/1/1297
//^^ This the problem statement

namespace alphaDice
{
    public class Dice
    {

            //This adds all possible dice orientations for when the key Character lands on the top side. So
            // each key maps to 4 char arrays of length 5, each array representing a possibility for where
            // the chars could be located. The arrays themselves show what char is in what space in this
            // order [Front, Right, Back, Left, Bottom] with unknown/undetermined values being represented
            // by the null character = '\u0000'
            Dictionary<Char, char[][]> possibleDiceMappings;

            public Dice()
            {

                possibleDiceMappings = new Dictionary<Char, char[][]>();
            }
            public void addRoll(char top, char front, char right)
            {

                if (!isRealRoll(top, front, right))
                {
                    //System.out.println("IS NOT REAL ROLL");
                    throw new ArgumentException("Cannot have repeat elements in one roll");
                }

                if (!possibleDiceMappings.ContainsKey(top))
                {
                    try { updateMapping(top, front, right); }
                    catch (ArgumentException e)
                    {
                        throw new ArgumentException(" ");
                    }
                }
                else
                {
                    try { verifyMapping(top, front, right); }
                    catch (ArgumentException e)
                    {
                        throw new ArgumentException(" ");
                    }
                }

                if (!possibleDiceMappings.ContainsKey(front))
                {
                    try
                    {
                        updateMapping(front, right, top);
                    }
                    catch (ArgumentException e)
                    {
                        throw new ArgumentException(" ");
                    }
                }
                else
                {
                    try
                    {
                        //verifyMapping(front, right, top);
                    }
                    catch (ArgumentException e)
                    {
                        throw new ArgumentException(" ");
                    }
                }


                if (!possibleDiceMappings.ContainsKey(right))
                {
                    try { updateMapping(right, top, front); }
                    catch (ArgumentException e)
                    {
                        throw new ArgumentException(" ");
                    }
                }
                else
                {
                    try
                    {
                        //verifyMapping(right, top, front);
                    }
                    catch (ArgumentException e)
                    {
                        throw new ArgumentException(" ");
                    }
                }

            }
            private bool isCapped()
            {
                return (possibleDiceMappings.Count() == 6);
            }
            private bool isRealRoll(char top, char front, char right)
            {
                return (top != front && top != right && front != right);
            }
            private void updateMapping(char thisTop, char thisFront, char thisRight)
            {

                if (isCapped())
                {
                    //System.out.println("IS CAPPED BOI");
                    throw new ArgumentException("There are already 6 elements mapped to this die");
                }

                char[] topCharArrOne = new char[] { thisFront, thisRight, '\u0000', '\u0000', '\u0000' };
                char[] topCharArrTwo = new char[] { '\u0000', thisFront, thisRight, '\u0000', '\u0000' };
                char[] topCharArrThree = new char[] { '\u0000', '\u0000', thisFront, thisRight, '\u0000' };
                char[] topCharArrFour = new char[] { thisRight, '\u0000', '\u0000', thisFront, '\u0000' };

                char[][] topCharArr = new char[][] { topCharArrOne, topCharArrTwo, topCharArrThree, topCharArrFour };

                possibleDiceMappings.Add(thisTop, topCharArr);
                //System.out.println("Top Added");
            }
            private void verifyMapping(char topCharToCheck, char frontCharToCheck, char rightCharToCheck)
            {

                possibleDiceMappings.TryGetValue(topCharToCheck, out char[][] arrayToCheck);

                for (int i = 0; i < arrayToCheck.Length; i++)
                {

                    if (arrayToCheck[i][0] == frontCharToCheck)
                    {
                        if (arrayToCheck[i][1] == rightCharToCheck)
                        {
                            return;
                        }
                        else if (arrayToCheck[i][1] != rightCharToCheck && arrayToCheck[i][1] != '\u0000')
                        {
                            throw new ArgumentException("This Right character cannot be here because it " +
                                "has been determined impossible");
                        }
                    }
                    else if (arrayToCheck[i][0] != frontCharToCheck && arrayToCheck[i][0] != '\u0000')
                    {
                        throw new ArgumentException("This Front character cannot be here because it has " +
                            "been determined impossible");
                    }
                }


            }
    }

    public class AlphaDice
    {
        Dice thisDice;

        public AlphaDice()
        {
            thisDice = new Dice();
        }

        public int badData(String[] roll)
        {

            for (int i = 0; i < roll.Length; i++)
            {
                String thisRoll = roll[i];

                if (thisRoll.Length != 3)
                {
                    throw new ArgumentException("Roll showed more or less than 3 sides, impossible.");
                }
                char topChar = thisRoll[0];
                char frontChar = thisRoll[1];
                char rightChar = thisRoll[2];

                try
                {
                    thisDice.addRoll(topChar, frontChar, rightChar);
                }
                catch (ArgumentException e)
                {
                    return i;
                }
            }
            return -1;
        }
    }
}

