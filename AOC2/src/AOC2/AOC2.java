package AOC2;
import java.io.*;
import java.util.*;

public class AOC2 {

    public static void main(String[] args)  throws Exception
    {
        String[] inputArray = new String[1000];
        File file = new File("C:\\Users\\jocquee\\Documents\\AdventOfCode2021\\AOC2.txt");
        Scanner fileReader = new Scanner(file);
        int x = 0;
        
        while(fileReader.hasNext())
        {
            inputArray[x] = fileReader.nextLine();
            x++;
        }
        fileReader.close();
        
        int[] intArray = new int[1000];
        
        
        for(int i = 0; i<inputArray.length; i++)
        {
            String[] inputSplit = inputArray[i].split(" ");
            inputArray[i] = inputSplit[0];
            intArray[i] = Integer.parseInt(inputSplit[1]);
        }
        
        
        int hPos = 0, vPos = 0, aim = 0;
        for(int i = 0; i<inputArray.length; i++)
        {
            if(inputArray[i].compareToIgnoreCase("up") == 0)
            {
                aim -= intArray[i];
            }
            else if(inputArray[i].compareToIgnoreCase("down") == 0)
            {
                aim += intArray[i];
            }
            else if(inputArray[i].compareToIgnoreCase("forward") == 0)
            {
                hPos += intArray[i];
                vPos += intArray[i] * aim;
            }
        }
        
        System.out.println(hPos * vPos);
        
    }
    
}
