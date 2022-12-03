from pathlib import Path
import string

input = open(Path(__file__).with_name("Input.txt"))
inputList = input.read().split('\n')

def part1():
    priority = 0
    for x in inputList:
        s = str(x)
        half = int(len(s) / 2)
        c1 = s[:half]
        c2 = s[half:]
        #print(c1,c2)
        
        common = ''
        for a in c1:
            if common == '':
                for b in c2:
                    if str(a) == str(b):
                        common = str(a)
                        break
        #print(common)
        
        for a in string.ascii_lowercase:
            if a == common:
                priority += string.ascii_lowercase.index(a) + 1
            elif a.upper() == common:
                priority += string.ascii_lowercase.index(a) + 27
    print(priority)

def part2():
    priority = 0
    for x in range(len(inputList)):
        if (x+3) % 3 == 0:
            print(x)
            e1 = str(inputList[x])
            e2 = str(inputList[x+1])
            e3 = str(inputList[x+2])
            commonList = []
            for a in e1:
                for b in e2:
                    if str(a) == str(b):
                        commonList.append(str(a))
            badge = ''
            for a in commonList:
                for b in e3:
                    if str(a) == str(b):
                        badge = str(a)
                        break
            
            for a in string.ascii_lowercase:
                if a == badge:
                    priority += string.ascii_lowercase.index(a) + 1
                elif a.upper() == badge:
                    priority += string.ascii_lowercase.index(a) + 27
    print(priority)
part1()
part2()