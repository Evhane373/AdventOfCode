package aoc5;

import java.io.*;

public class Map 
{
    int xMax = 1000;
    int yMax = 1000;
    int[][] map = new int[xMax][yMax];
    
    public Map()
    {
        for(int x = 0; x < xMax; x++)
        {
            for(int y = 0; y < yMax; y++)
            {
                map[x][y] = 0;
            }
        }
    }
    
    public void printMap()
    {
        for(int y = 0; y < yMax; y++)
        {
            for(int x = 0; x < xMax; x++)
            {
                System.out.print(map[x][y]);
            }
            System.out.println();
        }
    }
    public int getData(int x, int y)
    {
        return map[x][y];
    }
    public int getVent(int vSize)
    {
        int ventCount = 0;
        for(int x = 0; x < xMax; x++)
        {
            for(int y = 0; y < yMax; y++)
            {
                if(map[y][x] >= vSize)
                {
                    ventCount++;
                }
            }
        }
        return ventCount;
    }
    
    public void addVent(int x1, int x2, int y1, int y2)
    {
        if(x1 == x2 && y1 == y2)
        {
            map[x1][y1] += 1;
            System.out.println("Draw Dot");
        }
        else if(x1 == x2)
        {
            drawYLine(y1, y2, x1);
            System.out.println("Draw Y");
        }
        else if(y1 == y2)
        {
            drawXLine(x1, x2, y1);
            System.out.println("Draw X");
        }
        else
        {
            drawDLine(x1, x2, y1, y2);
            System.out.println("DrawDiag");
        }
    }
    
    void drawYLine(int pos1, int pos2, int x)
    {
        if(pos1 < pos2)
        {
            for(int i= pos1; i <= pos2; i++)
            {
                map[x][i] += 1;
            }
        }
        else if (pos1 > pos2)
        {
            for(int i= pos2; i <= pos1; i++)
            {
                map[x][i] += 1;
            }
        }
    }
    void drawXLine(int pos1, int pos2, int y)
    {
        if(pos1 < pos2)
        {
            for(int i= pos1; i <= pos2; i++)
            {
                map[i][y] += 1;
            }
        }
        else if (pos1 > pos2)
        {
            for(int i= pos2; i <= pos1; i++)
            {
                map[i][y] += 1;
            }
        }
    }
    public void drawDLine(int x1, int x2, int y1, int y2)
    {
        if(x1 < x2)
        {
            System.out.print("for");
            if(y1 < y2)
            {
                System.out.print("pos");
                for(int x = x1, y = y1; x <= x2 && y <= y2; x++, y++)
                {
                    map[x][y] += 1;
                }
            }
            else if(y1 > y2)
            {
                System.out.print("neg");
                for(int x = x1, y = y1; x <= x2 && y >= y2; x++, y--)
                {
                    map[x][y] += 1;
                }
            }
        }
        else if(x1 > x2)
        {
            System.out.print("back");
            if(y1 < y2)
            {
                System.out.print("pos");
                for(int x = x1, y = y1; x >= x2 && y <= y2; x--, y++)
                {
                    map[x][y] += 1;
                }
            }
            else if(y1 > y2)
            {
                System.out.print("neg");
                for(int x = x1, y = y1; x >= x2 && y >= y2; x--, y--)
                {
                    map[x][y] += 1;
                }
            }
        }
        
    }
}
