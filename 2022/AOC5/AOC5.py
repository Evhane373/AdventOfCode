from pathlib import Path
import string

input = open(Path(__file__).with_name("Input.txt"))
inputSplit = input.read().split('\n\n')

boxInput = inputSplit[0].split('\n')
moveInput = inputSplit[1].split('\n')

stackList = [[],[],[],[],[],[],[],[],[]]

def move9000(num, fr, to):
    for x in range(0,num):
        stackList[to].insert(0, stackList[fr].pop(0))

def move9001(num, fr, to):
    moveStack = []
    for x in range(0,num):
        moveStack.append(stackList[fr][0])
        del stackList[fr][0]
    stackList[to] = moveStack + stackList[to]

for x in boxInput:
    print(x)
    for y in range(1,10):
        charPos = ((y - 1) * 4) + 1
        if x[charPos] != ' ':
            stackList[y-1].append(x[charPos])
            print(x[charPos])

for x in moveInput:
    m = x.replace('move', '')
    m = m.replace('from', '')
    m = m.replace('to', '')
    m = m.strip()
    mc = m.split('  ')
    print(mc)
    #move9000(int(mc[0]), int(mc[1])-1, int(mc[2])-1)
    move9001(int(mc[0]), int(mc[1])-1, int(mc[2])-1)

output = ''
for x in stackList:
    print(x)
    output += x[0]

print(output)

