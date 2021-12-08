package aoc8;

import java.io.File;
import java.util.Scanner;
import java.util.*;

public class AOC8 
{

    public static void main(String[] args) throws Exception
    {
        File file  = new File("C:\\Users\\jocquee\\Documents\\AdventOfCode2021\\AOC8.txt");
        Scanner fileReader = new Scanner(file);
        List<String> input = new ArrayList<>();
        while(fileReader.hasNext())
        {
            input.add(fileReader.nextLine());
        }
        System.out.println(input);
        ArrayList<String> uSignal = new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();
        for(int i = 0; i < input.size(); i++)
        {
            uSignal.add(input.get(i).split(" \\| ")[0]);
            output.add(input.get(i).split(" \\| ")[1]);
        }
        System.out.println(uSignal);
        System.out.println(output);
        int num1 = 0,
                num4 = 0,
                num7 = 0,
                num8 = 0;
        for(int i = 0; i < output.size(); i++)
        {
            String[] temp = output.get(i).split(" ");
            for(int x = 0; x < temp.length; x++)
            {
                if(temp[x].length() == 2) //1
                {
                    num1++;
                }
                else if(temp[x].length() == 4) //4
                {
                    num4++;
                }
                else if(temp[x].length() == 3) //7
                {
                    num7++;
                }
                else if(temp[x].length() == 7) //8
                {
                    num8++;
                }
            }
        }
        System.out.println(num1 + num4 + num7 + num8);
        decoder(uSignal.get(0), output.get(0));
    }
    
    
    static void decoder(String input, String output)
    {
        String[] inputSplit = input.split(" ");
        String[] outputSplit = output.split(" ");
        String letterOrder = "";
        
        char[] part0 = new char[6];
        char[] part1 = new char[2];
        char[] part2 = new char[5];
        char[] part3 = new char[5];
        char[] part4 = new char[4];
        char[] part5 = new char[5];
        char[] part6 = new char[6];
        char[] part7 = new char[3];
        char[] part8 = new char[7];
        char[] part9 = new char[6];
        
        for(int i = 0; i < inputSplit.length; i++) //Find the letters that are part of known numbers
        {
            if(inputSplit[i].length() == 2) //1
            {
                part1[0] = inputSplit[i].charAt(0);
                part1[1] = inputSplit[i].charAt(1);
            }
            if(inputSplit[i].length() == 4) //4
            {
                part4[0] = inputSplit[i].charAt(0);
                part4[1] = inputSplit[i].charAt(1);
                part4[2] = inputSplit[i].charAt(2);
                part4[3] = inputSplit[i].charAt(3);
            }
            if(inputSplit[i].length() == 3) //7
            {
                part7[0] = inputSplit[i].charAt(0);
                part7[1] = inputSplit[i].charAt(1);
                part7[2] = inputSplit[i].charAt(2);
            }
            if(inputSplit[i].length() == 7) //8
            {
                part8[0] = inputSplit[i].charAt(0);
                part8[1] = inputSplit[i].charAt(1);
                part8[2] = inputSplit[i].charAt(2);
                part8[3] = inputSplit[i].charAt(3);
                part8[4] = inputSplit[i].charAt(4);
                part8[5] = inputSplit[i].charAt(5);
                part8[6] = inputSplit[i].charAt(6);
            }
        }
        
        //Find 9
        for(int i = 0; i < inputSplit.length; i++)
        {
            if(inputSplit[i].length() == 6) //0, 9, 6
            {
                boolean fMatch = true;
                for(int x = 0; x < 6; x++)
                {
                    boolean match = false;
                    if(part4[0] == inputSplit[i].charAt(x) || 
                            part4[1] == inputSplit[i].charAt(x) || 
                            part4[2] == inputSplit[i].charAt(x) || 
                            part4[3] == inputSplit[i].charAt(x))
                    {
                        match = true;
                    }
                    else
                    {
                        match = false;
                    }
                    if(!match) //0,6
                    {
                        fMatch = false;
                    }
                }
                if(fMatch)
                {
                    part9[0] = inputSplit[i].charAt(0);
                    part9[1] = inputSplit[i].charAt(1);
                    part9[2] = inputSplit[i].charAt(2);
                    part9[3] = inputSplit[i].charAt(3);
                    part9[4] = inputSplit[i].charAt(4);
                    part9[5] = inputSplit[i].charAt(5);
                }
            }
        }
        
        //Find 0 and 6
        for(int i = 0; i < inputSplit.length; i++)
        {
            if(inputSplit[i].length() == 6) //0, 9, 6
            {
                int numMatch = 0;
                for(int x = 0; x < 6; x++) //Check if input = 9
                {
                    for(int y = 0; y < 6; y++)
                    {
                        if(inputSplit[i].charAt(x) == part9[y])
                        {
                            numMatch += 1;
                        }
                    }
                }
                if(numMatch == inputSplit[i].length()){} //9
                else //0,6
                {
                    numMatch = 0;
                    for(int x = 0; x < inputSplit[i].length(); x++)
                    {
                        if(inputSplit[i].charAt(x) == part1[0] || inputSplit[i].charAt(x) == part1[1])
                        {
                            numMatch++;
                        }
                    }
                    if(numMatch == 1)
                    {
                        part6[0] = inputSplit[i].charAt(0);
                        part6[1] = inputSplit[i].charAt(1);
                        part6[2] = inputSplit[i].charAt(2);
                        part6[3] = inputSplit[i].charAt(3);
                        part6[4] = inputSplit[i].charAt(4);
                        part6[5] = inputSplit[i].charAt(5);
                    }
                    else if(numMatch == 2)
                    {
                        part0[0] = inputSplit[i].charAt(0);
                        part0[1] = inputSplit[i].charAt(1);
                        part0[2] = inputSplit[i].charAt(2);
                        part0[3] = inputSplit[i].charAt(3);
                        part0[4] = inputSplit[i].charAt(4);
                        part0[5] = inputSplit[i].charAt(5);
                    }
                    else
                    {
                        System.out.println("Error06");
                    }
                }
                
                //Find 5
                
                //Find 2,3
            }
        }
        String code0 = "", code1 = "", code2 = "", code3 = "", code4 = "", code5 = "", code6 = "", code7 = "", code8 = "", code9 = "";
        code0 = "" + part0[0] + part0[1] + part0[2] + part0[3] + part0[4] + part0[5]; 
        code1 = "" + part1[0] + part1[1]; 
        //code2 = "" + part2[0] + part2[1] + part0[2] + part2[3] + part2[4]; 
        //code3 = "" + part3[0] + part3[1] + part3[2] + part3[3] + part3[4]; 
        code4 = "" + part4[0] + part4[1] + part4[2] + part4[3]; 
        //code5 = "" + part5[0] + part5[1] + part5[2] + part5[3] + part5[4]; 
        code6 = "" + part6[0] + part6[1] + part6[2] + part6[3] + part6[4] + part6[5]; 
        code7 = "" + part7[0] + part7[1] + part7[2]; 
        code8 = "" + part8[0] + part8[1] + part8[2] + part8[3] + part8[4] + part8[5] + part8[6];
        code9 = "" + part9[0] + part9[1] + part9[2] + part9[3] + part9[4] + part9[5]; 
        
        System.out.println(code0 + " " + 
                code1 + " " + 
                code2 + " " + 
                code3 + " " + 
                code4 + " " + 
                code5 + " " + 
                code6 + " " + 
                code7 + " " + 
                code8 + " " + 
                code9);
        //Top letter, 7-1
        for(int i = 0; i < 2; i++)
        {
            if(!(part7[i] == part1[0] || part7[i] == part1[1]))
            {
                letterOrder += part7[i];
            }
        }
        //Top left letter ???
        
        //Top right letter 8-6?
        
        //Middle letter 8-0?
        for(int i = 0; i < 7; i++)
        {
            if(!(part8[i] == part0[0] || 
                    part8[i] == part0[1] ||
                    part8[i] == part0[2] ||
                    part8[i] == part0[3] ||
                    part8[i] == part0[4] ||
                    part8[i] == part0[5]))
            {
                letterOrder += part8[i];
            }
        }
        //Bottom left letter ???
        
        //Bottom right letter 8-9
        for(int i = 0; i < 7; i++)
        {
            if(!(part8[i] == part6[0] || 
                    part8[i] == part6[1] ||
                    part8[i] == part6[2] ||
                    part8[i] == part6[3] ||
                    part8[i] == part6[4] ||
                    part8[i] == part6[5]))
            {
                letterOrder += part8[i];
            }
        }
        //Bottom letter ???
    }
}
