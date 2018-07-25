using System;


//lets say we have a string input with a series of signed numbers  "+5 -100  +987" and so on , I would like to know the sum of those numbers

class SeriesCounter
{
    static int Main(string[] args)
    {
        string s = "+5 -100  +987 -100 -92 +1000";
        int thisLength = s.Length;
        Console.WriteLine(thisLength);
        
        int counter = 0;
         
        for (var i = 0; i < s.Length; i++) 
        {
            
            char thisChar = s[i];
            int endIndex = 0;
            char lastChar = s[i + endIndex];
            //Console.WriteLine(thisChar);
            
            if (thisChar == '+' || thisChar == '-') {
                //Console.WriteLine("Inside main IF");

                int indexAdder = i + endIndex;    
                
                while (indexAdder < s.Length ) {
                    //Console.WriteLine("INSIDE WHILE LOOP");
                    lastChar = s[indexAdder];
                    
                    if (lastChar == ' ') {
                        break;
                    } else {
                        endIndex++;
                        indexAdder = i + endIndex;   
                    }
                }
            
                
                String sign = s.Substring(i, 1);
                
                int thisCount = 0;
                int addedCount = i + thisCount;
                char back = s[addedCount];
                
                while (back != ' ' && addedCount < s.Length) {
                    back = s[addedCount];
                    thisCount++;
                    addedCount = i + thisCount; 
                }
                
                //Console.WriteLine("i: " + i);
                //Console.WriteLine("ADDED COUNT: " + addedCount);
                String thisNum = s.Substring((i + 1), ((addedCount - i) - 1));
                //String thisNum = s.Substring((i + 1), 3);

            
                Int32.TryParse(thisNum, out int thisInt);
                Console.WriteLine("The Num:"+ thisInt);
            
                if (sign == "+") {
                    counter += thisInt;
                }
            
                if (sign == "-") {
                    counter -= thisInt;
                }   
            }
        }
        Console.WriteLine(counter);
        return counter;
    }
}
