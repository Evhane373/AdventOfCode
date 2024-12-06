from pathlib import Path
input = open(Path(__file__).with_name("Input.txt"))
#print(input.read())
inputSplit = input.read().split('\n')

def checkSafe(report):
    levels = report.split(' ')
    for x in range(len(levels)):
        levels[x] = int(levels[x])
    prev = levels[0]
    increase = False
    decrease = False
    for x in levels[1:]:
        if(x == prev):
            return False
        elif(abs(x - prev) <= 3):
            if(x > prev):
                increase = True
            elif(x < prev):
                decrease = True
            if(increase and decrease):
                return False
        elif(abs(x - prev) > 3):
            return False
        prev = x
    return True

def unsafeFixer(report):
    testVal = "7 6 4 2 1"
    #report = testVal
    levels = report.split(' ')
    levelRem = []
    for x in range(len(levels)):
        levels[x] = int(levels[x])
    for x in range(len(levels)):
        testLevel = ""
        for y in levels:
            if(not(levels[x] == y)):
                testLevel += " " + str(y)
        testLevel = testLevel.strip()
        if(checkSafe(testLevel)):
            print(testLevel + " Safe")
            return True
    print(report + " Unsafe")
    return False

safeCount = 0
unsafeReports = []
for x in inputSplit:
    if(unsafeFixer(x)):
        #print(x + " Safe")
        safeCount += 1
    else:
        #print(x + " Unsafe")
        unsafeReports.append(x)
print(str(safeCount))
newSafe = 0
#for x in unsafeReports:
#    if(unsafeFixer(x)):
#        newSafe += 1
#print(str(newSafe))