package aoc3;

import java.util.*;
import java.io.*;

public class AOC3
{

    public static void main(String[] args) throws Exception
    {
        File file = new File("C:\\Users\\ewjoc\\Desktop\\AdventOfCode\\AOC3.txt");
        Scanner fileReader = new Scanner(file);
        ArrayList<String> input = new ArrayList<String>();
        
        while(fileReader.hasNext())
        {
            input.add(fileReader.nextLine());
        }
        String gRate = "", eRate = "";
        for(int i = 0; i < input.get(i).length(); i++)
        {
            int num0 = 0, num1 = 0;
            for(int x = 0; x < input.size(); x++)
            {
                if(input.get(x).charAt(i) == '0')
                {
                    num0++;
                }
                else if(input.get(x).charAt(i) == '1')
                {
                    num1++;
                }
            }
            if(num0 > num1)
            {
                gRate += "0";
                eRate += "1";
            }
            else if(num1 > num0)
            {
                gRate += "1";
                eRate += "0";
            }
        }
        
        ArrayList<String> ogArray = (ArrayList)input.clone();
        ArrayList<String> c02Array = (ArrayList)input.clone();
        
        int pos = 0;
        while(ogArray.size() > 1)
        {
            binFinder(ogArray, pos);
            ogArray = (ArrayList)b(ogArray, pos).clone();
            for(int i = 0; i < ogArray.size(); i++)
            {
                System.out.println(ogArray.get(i) + " " + pos);
            }
            pos++;
        }
        pos = 0;
        while(c02Array.size() > 1)
        {
            binFinder(c02Array, pos);
            c02Array = (ArrayList)c(c02Array, pos).clone();
            for(int i = 0; i < c02Array.size(); i++)
            {
                System.out.println(c02Array.get(i) + " " + pos);
            }
            pos++;
        }
        System.out.println(ogArray.get(0) + " " + c02Array.get(0));
        System.out.println(Integer.parseInt(ogArray.get(0),2) * Integer.parseInt(c02Array.get(0),2));
        
        
    }
    
    
    static int binFinder(ArrayList<String> input, int pos)
    {
        int num0 = 0, num1 = 0;
        for(int x = 0; x < input.size(); x++)
        {
            if(input.get(x).charAt(pos) == '0')
            {
                num0++;
            }
            else if(input.get(x).charAt(pos) == '1')
            {
                num1++;
            }
        }
        if(num0 > num1)
        {
            return 0;
        }
        else if(num1 > num0)
        {
            return 1;
        }
        return -1;
    }
    static ArrayList b(ArrayList<String> ar, int pos)
    {
        int size = ar.size();
        if(binFinder(ar, pos) == 0)
        {
            for(int i = 0; i < size; i++)
            {
                if(ar.get(i).charAt(pos) == '0')
                {
                    ar.add(ar.get(i));
                }
            }
        }
        else if(binFinder(ar, pos) == 1 || binFinder(ar, pos) == -1)
        {
            for(int i = 0; i < size; i++)
            {
                if(ar.get(i).charAt(pos) == '1')
                {
                    ar.add(ar.get(i));
                }
            }
        }
        for(int i = 0; i < size; i++)
        {
            ar.remove(0);
        }
        return ar;
    }
    static ArrayList c(ArrayList<String> ar, int pos)
    {
        int size = ar.size();
        if(binFinder(ar, pos) == 1 || binFinder(ar, pos) == -1)
        {
            for(int i = 0; i < size; i++)
            {
                if(ar.get(i).charAt(pos) == '0')
                {
                    ar.add(ar.get(i));
                }
            }
        }
        else if(binFinder(ar, pos) == 0)
        {
            for(int i = 0; i < size; i++)
            {
                if(ar.get(i).charAt(pos) == '1')
                {
                    ar.add(ar.get(i));
                }
            }
        }
        for(int i = 0; i < size; i++)
        {
            ar.remove(0);
        }
        return ar;
    }
}
