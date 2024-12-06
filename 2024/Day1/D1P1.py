from pathlib import Path
input = open(Path(__file__).with_name("Input.txt"))
#print(input.read())

def getDiff(list1, list2):
    list1.sort()
    list2.sort()
    diff = 0
    x = 0
    while(x < count):
        if(list1[x] > list2[x]):
            diff += list1[x] - list2[x]
        elif(list1[x] < list2[x]):
            diff += list2[x] - list1[x]
        else:
            diff += 0
        x += 1
    return(diff)

def getSame(list1, list2):
    score = 0
    for x in list1:
        count = 0
        for y in list2:
            if(x == y):
                count += 1
        score += x * count
    return(score)

numList = input.read().split('\n')
list1 = []
list2 = []
count = 0
for x in numList:
    list1.append(int(x.split(' ')[0]))
    list2.append(int(x.split(' ')[3]))
    #print(x.split(' ')[0] + " | " + x.split(' ')[3] + " " + str(count))
    count += 1
print("Part 1: " + str(getDiff(list1, list2)) + " | Part 2: " + str(getSame(list1, list2)))

