package aoc1;
import java.io.*;
import java.util.*;

public class AOC1 {

    public static void main(String[] args)  throws Exception
    {
        int[] numArray = new int[2000];
        File file = new File("C:\\Users\\jocquee\\Documents\\AdventOfCode2021\\AOC1.txt");
        Scanner fileReader = new Scanner(file);
        int x = 0, numIncrease = 0;
        int newNum = 9999999, oldNum = 9999999;
        while(fileReader.hasNext())
        {
            numArray[x] = fileReader.nextInt();
            x++;
        }
        fileReader.close();
        
        for(int i = 0; i < numArray.length-2; i++)
        {
            oldNum = newNum;
            newNum = numArray[i] + numArray[i+1] + numArray[i+2];
            
            if(newNum > oldNum)
            {
                numIncrease++;
            }
        }
        System.out.println(numIncrease);
    }
    
}
