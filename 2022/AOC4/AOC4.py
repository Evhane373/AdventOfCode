from pathlib import Path
import string

input = open(Path(__file__).with_name("Input.txt"))
inputList = input.read().split('\n')

totalOverlap = 0
partOverlap = 0

for x in inputList:
    elf = x.split(',')
    elf1 = elf[0].split('-')
    elf2 = elf[1].split('-')
    
    elf1Min = int(elf1[0])
    elf1Max = int(elf1[1])
    elf2Min = int(elf2[0])
    elf2Max = int(elf2[1])
    
    if elf1Min <= elf2Min and elf1Max >= elf2Max:
        totalOverlap += 1
    elif elf1Min >= elf2Min and elf1Max <= elf2Max:
        totalOverlap += 1
        
    if elf1Min <= elf2Min and elf1Max >= elf2Min:
        partOverlap += 1
    elif elf1Min >= elf2Min and elf2Max >= elf1Min:
        partOverlap += 1
print(totalOverlap)
print(partOverlap)