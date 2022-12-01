package aoc5;

import java.io.*;
import java.util.*;

public class AOC5 
{
    public static void main(String[] args) throws Exception
    {
        File file = new File("C:\\Users\\ewjoc\\Desktop\\AdventOfCode\\AOC5.txt");
        Scanner fileReader = new Scanner(file);
        
        Map map = new Map();
        ArrayList<String> input = new ArrayList<String>();
        ArrayList<String[]> inputSplit = new ArrayList<String[]>();
        
        while(fileReader.hasNext())
        {
            input.add(fileReader.nextLine());
        }
        
        for(int i = 0; i < input.size(); i++) //Split input
        {
            inputSplit.add(input.get(i).split("->"));
        }
        
        ArrayList<String[]> sCoords = new ArrayList<>();
        ArrayList<String[]> eCoords = new ArrayList<>();
        
        for(int i = 0; i < inputSplit.size(); i++)
        {
            sCoords.add(inputSplit.get(i)[0].split(","));
            eCoords.add(inputSplit.get(i)[1].split(","));
        }
        
        ArrayList<Integer> x1Array = new ArrayList<>();
        ArrayList<Integer> x2Array = new ArrayList<>();
        ArrayList<Integer> y1Array = new ArrayList<>();
        ArrayList<Integer> y2Array = new ArrayList<>();
        
        for(int i = 0; i < sCoords.size(); i++)
        {
            x1Array.add(Integer.parseInt(sCoords.get(i)[0].trim()));
            x2Array.add(Integer.parseInt(eCoords.get(i)[0].trim()));
            y1Array.add(Integer.parseInt(sCoords.get(i)[1].trim()));
            y2Array.add(Integer.parseInt(eCoords.get(i)[1].trim()));
            
            System.out.println(x1Array.get(i) + " " + y1Array.get(i) + " " + x2Array.get(i) + " " + y2Array.get(i));
        }
        
        for(int i = 0; i < x1Array.size(); i++)
        {
            int x1 = x1Array.get(i);
            int x2 = x2Array.get(i);
            int y1 = y1Array.get(i);
            int y2 = y2Array.get(i);
            map.addVent(x1, x2, y1, y2);
        }
        map.printMap();
        System.out.println(map.getVent(2));
    }
}
