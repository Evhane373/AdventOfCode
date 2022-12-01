package aoc7;

import java.io.*;
import java.util.*;

public class AOC7 
{

    public static void main(String[] args) throws Exception
    {
        File file = new File("C:\\Users\\ewjoc\\Desktop\\AdventOfCode\\AOC7.txt");
        Scanner fileReader = new Scanner(file);
        String input = "";
        while(fileReader.hasNext())
        {
            input += fileReader.nextLine();
        }
        
        String[] sInput = input.split(",");
        
        ArrayList<Integer> hPos = new ArrayList<>();
        
        for(int i = 0; i < sInput.length; i++)
        {
            hPos.add(Integer.parseInt(sInput[i]));
        }
        
        
        ArrayList<Integer> move = new ArrayList<>();
        for(int i = 0; i < Collections.max(hPos); i++)
        {
            move.add(moveTest(i, hPos));
        }
        int max = Collections.max(hPos);
        int min = Collections.min(move);
        System.out.println(min);
        
        
    }
    static int moveTest(int pos, ArrayList<Integer> hPos)
    {
        int totMove = 0;
        
        for(int i = 0; i < hPos.size(); i++)
        {
            //totMove += Math.abs(hPos.get(i) - pos);
            for(int x = 1; x <= Math.abs(hPos.get(i) - pos); x++)
            {
               totMove += x; 
            }
        }
        
        return totMove;
    }
}
