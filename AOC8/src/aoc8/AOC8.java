package aoc8;

import java.io.File;
import java.util.Scanner;
import java.util.*;

public class AOC8 
{

    public static void main(String[] args) throws Exception
    {
        File file  = new File("S:\\GitHubRepo\\AdventOfCode\\Inputs\\AOC8.txt");
        Scanner fileReader = new Scanner(file);
        List<String> input = new ArrayList<>();
        while(fileReader.hasNext())
        {
            input.add(fileReader.nextLine());
        }
        //System.out.println(input);
        ArrayList<String> uSignal = new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();
        for(int i = 0; i < input.size(); i++)
        {
            uSignal.add(input.get(i).split(" \\| ")[0]);
            output.add(input.get(i).split(" \\| ")[1]);
        }
        //System.out.println(uSignal);
        //System.out.println(output);
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
        //System.out.println(num1 + num4 + num7 + num8);
        
        int codeSum = 0;
        for(int i = 0; i < output.size(); i++)
        {
            String code = decoder(uSignal.get(i));
            
            //Set 0
            String code0 = code.charAt(0) + ""
                    + code.charAt(1) + ""
                    + code.charAt(2) + ""
                    + code.charAt(4) + ""
                    + code.charAt(5) + ""
                    + code.charAt(6);
            code0 = sort(code0);
            
            //Set 1
            String code1 = code.charAt(2) + ""
                    + code.charAt(5);
            code1 = sort(code1);
            
            //Set 2
            String code2 = code.charAt(0) + ""
                    + code.charAt(2) + ""
                    + code.charAt(3) + ""
                    + code.charAt(4) + ""
                    + code.charAt(6);
            code2 = sort(code2);
            
            //Set 3
            String code3 = code.charAt(0) + ""
                    + code.charAt(2) + ""
                    + code.charAt(3) + ""
                    + code.charAt(5) + ""
                    + code.charAt(6);
            code3 = sort(code3);
            
            //Set 4
            String code4 = code.charAt(1) + ""
                    + code.charAt(2) + ""
                    + code.charAt(3) + ""
                    + code.charAt(5);
            code4 = sort(code4);
            
            //Set 5
            String code5 = code.charAt(0) + ""
                    + code.charAt(1) + ""
                    + code.charAt(3) + ""
                    + code.charAt(5) + ""
                    + code.charAt(6);
            code5 = sort(code5);
            
            //Set 6
            String code6 = code.charAt(0) + ""
                    + code.charAt(1) + ""
                    + code.charAt(3) + ""
                    + code.charAt(4) + ""
                    + code.charAt(5) + ""
                    + code.charAt(6);
            code6 = sort(code6);
            
            //Set 7
            String code7 = code.charAt(0) + ""
                    + code.charAt(2) + ""
                    + code.charAt(5);
            code7 = sort(code7);
            
            //Set 8
            String code8 = code;
            code8 = sort(code8);
            
            //Set 9
            String code9 = code.charAt(0) + ""
                    + code.charAt(1) + ""
                    + code.charAt(2) + ""
                    + code.charAt(3) + ""
                    + code.charAt(5) + ""
                    + code.charAt(6);
            code9 = sort(code9);
            
            String[] outCode = output.get(i).split(" ");
            String oCode = "";
            
            for(int x = 0; x < outCode.length; x++)
            {
                if(sort(outCode[x]).compareTo(code0) == 0)
                {
                    oCode += "0";
                }
                else if(sort(outCode[x]).compareTo(code1) == 0)
                {
                    oCode += "1";
                }
                else if(sort(outCode[x]).compareTo(code2) == 0)
                {
                    oCode += "2";
                }
                else if(sort(outCode[x]).compareTo(code3) == 0)
                {
                    oCode += "3";
                }
                else if(sort(outCode[x]).compareTo(code4) == 0)
                {
                    oCode += "4";
                }
                else if(sort(outCode[x]).compareTo(code5) == 0)
                {
                    oCode += "5";
                }
                else if(sort(outCode[x]).compareTo(code6) == 0)
                {
                    oCode += "6";
                }
                else if(sort(outCode[x]).compareTo(code7) == 0)
                {
                    oCode += "7";
                }
                else if(sort(outCode[x]).compareTo(code8) == 0)
                {
                    oCode += "8";
                }
                else if(sort(outCode[x]).compareTo(code9) == 0)
                {
                    oCode += "9";
                }
            }
            System.out.println(oCode);
            codeSum += Integer.parseInt(oCode);
        }
        System.out.println(codeSum);
    }
    
    
    static String decoder(String input)
    {
        String[] inputSplit = input.split(" ");
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
                part1 = inputSplit[i].toCharArray();
            }
            if(inputSplit[i].length() == 4) //4
            {
                part4 = inputSplit[i].toCharArray();
            }
            if(inputSplit[i].length() == 3) //7
            {
                part7 = inputSplit[i].toCharArray();
            }
            if(inputSplit[i].length() == 7) //8
            {
                part8 = inputSplit[i].toCharArray();
            }
        }
        //Find 9
        for(int i = 0; i < inputSplit.length; i++)
        {
            if(inputSplit[i].length() == 6) //0, 9, 6
            {
                if(compare(part4, inputSplit[i].toCharArray()))
                {
                    part9 = inputSplit[i].toCharArray();
                }
            }
        }
        //Find 0 and 6
        for(int i = 0; i < inputSplit.length; i++)
        {
            if(inputSplit[i].length() == 6) //0, 9, 6
            {
                if(compare(inputSplit[i].toCharArray(), part9)){}
                else //0,6
                {
                    int numMatch = 0;
                    for(int x = 0; x < inputSplit[i].length(); x++)
                    {
                        if(inputSplit[i].charAt(x) == part1[0] || inputSplit[i].charAt(x) == part1[1])
                        {
                            numMatch++;
                        }
                    }
                    if(numMatch == 1)
                    {
                        part6 = inputSplit[i].toCharArray();
                    }
                    else if(numMatch == 2)
                    {
                        part0 = inputSplit[i].toCharArray();
                    }
                }
            }
        }
        //Find 5
        for(int i = 0; i < inputSplit.length; i++)
        {
            if(inputSplit[i].length() == 5) //2, 3, 5
            {
                if(compare(inputSplit[i].toCharArray(), part6))
                {
                    part5 = inputSplit[i].toCharArray();
                }
            }
        }
        //Find 2,3
        for(int i = 0; i < inputSplit.length; i++)
        {
            if(inputSplit[i].length() == 5) //2, 3, 5
            {
                if(compare(inputSplit[i].toCharArray(), part6))
                {}
                else
                {
                    if(compare(part1, inputSplit[i].toCharArray())) //3
                    {
                        part3 = inputSplit[i].toCharArray();
                    }
                    else
                    {
                        part2 = inputSplit[i].toCharArray();
                    }
                }
            }
        }
        String code0 = "", code1 = "", code2 = "", code3 = "", code4 = "", code5 = "", code6 = "", code7 = "", code8 = "", code9 = "";
        code0 = "" + part0[0] + part0[1] + part0[2] + part0[3] + part0[4] + part0[5]; 
        code1 = "" + part1[0] + part1[1]; 
        code2 = "" + part2[0] + part2[1] + part2[2] + part2[3] + part2[4]; 
        code3 = "" + part3[0] + part3[1] + part3[2] + part3[3] + part3[4]; 
        code4 = "" + part4[0] + part4[1] + part4[2] + part4[3]; 
        code5 = "" + part5[0] + part5[1] + part5[2] + part5[3] + part5[4]; 
        code6 = "" + part6[0] + part6[1] + part6[2] + part6[3] + part6[4] + part6[5]; 
        code7 = "" + part7[0] + part7[1] + part7[2]; 
        code8 = "" + part8[0] + part8[1] + part8[2] + part8[3] + part8[4] + part8[5] + part8[6];
        code9 = "" + part9[0] + part9[1] + part9[2] + part9[3] + part9[4] + part9[5]; 

        //Top, 7-1
        letterOrder += getDiff(code7, code1); //Should be A
        //Top left, 4-3
        letterOrder += getDiff(code4, code3);
        //Top right, 8-6
        letterOrder += getDiff(code8, code6); //e
        //Middle, 8-0
        letterOrder += getDiff(code8, code0); //d
        //Bottom left, 8-9
        letterOrder += getDiff(code8, code9); //f
        //Bottom right, 2-1?
        letterOrder += getDiff(code1, code2);
        //Bottom, ?
        letterOrder += getDiff("abcdefg", letterOrder);
        //System.out.println(letterOrder);

        return letterOrder;
    }
    static boolean compare(char[] c1, char[] c2) //Big array, then small array
    {
        //char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        boolean tf = true;
        for(int i = 0; i < c1.length; i++)
        {
            int num = 0;
            for(int x = 0; x < c2.length; x++)
            {
                if(c1[i] == c2[x])
                {
                    
                }
                else
                {
                    num++;
                }
            }
            if(num >= c2.length)
            {
                tf = false;
            }
        }
        return tf;
    }
    static String getDiff(String s1, String s2)
    {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        String output = "";
        for(int i = 0; i < c1.length; i++)
        {
            int numMatch = 0;
            for(int x = 0; x < c2.length; x++)
            {
                if(c1[i] == c2[x])
                {
                    numMatch++;
                }
            }
            if(numMatch == 0)
            {
                output += c1[i];
            }
        }
        return output;
    }
    static String sort(String input)
    {
        char[] c = input.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}