package aoc6;

import java.io.*;
import java.util.*;

public class AOC6 {

    public static void main(String[] args) throws Exception
    {
        File file  = new File("C:\\Users\\jocquee\\Documents\\AdventOfCode2021\\AOC6.txt");
        Scanner fileReader = new Scanner(file);
        String input = "";
        while(fileReader.hasNext())
        {
            input = fileReader.nextLine();
        }
        String[] inputSplit = input.split(",");
        
        List<Integer> lFish = new ArrayList<>();
        for (String inputSplit1 : inputSplit) 
        {
            lFish.add(Integer.parseInt(inputSplit1));
        }
        /*
        for(int i = 0; i < 256; i++)
        {
            int size = lFish.size();
            for(int x = 0; x < size; x++)
            {
                if(lFish.get(x) == 0)
                {
                    lFish.set(x, 6);
                    lFish.add(8);
                }
                else
                {
                    lFish.set(x, (lFish.get(x) - 1));
                }
            }
            System.out.println(i + " " + lFish.size());
            
        }
*/
        long f0 = 0, f1 = 0, f2 = 0, f3 = 0, f4 = 0, f5 = 0, f6 = 0, f7 = 0, f8 = 0; 
        for(int i = 0; i < lFish.size(); i++)
        {
            switch(lFish.get(i))
            {
                case 0:
                    f0 += 1;
                    break;
                case 1:
                    f1 += 1;
                    break;
                case 2:
                    f2 += 1;
                    break;
                case 3:
                    f3 += 1;
                    break;
                case 4:
                    f4 += 1;
                    break;
                case 5:
                    f5 += 1;
                    break;
                case 6:
                    f6 += 1;
                    break;
                case 7:
                    f7 += 1;
                    break;
                case 8:
                    f8 += 1;
                    break;
            }
        }
        System.out.println(f0 + " " + 
                f1 + " " + 
                f2 + " " + 
                f3 + " " + 
                f4 + " " + 
                f5 + " " + 
                f6 + " " + 
                f7 + " " + 
                f8);
        
        for(int i = 0; i < 256; i++)
        {
            long temp = f0;
            f0 = f1;
            f1 = f2;
            f2 = f3;
            f3 = f4;
            f4 = f5;
            f5 = f6;
            f6 = temp;
            f6 += f7; //Add new fish to cycle
            f7 = f8;
            f8 = temp;
        }
        
        System.out.println(f0 + f1 + f2 + f3 + f4 + f5 + f6 + f7 + f8);
        System.out.println((long)lFish.size());
        
    }
    
}
