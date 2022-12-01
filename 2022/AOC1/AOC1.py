from pathlib import Path


input = open(Path(__file__).with_name("Input.txt"))
#print(input.read())

elfList = input.read().split('\n')
print(elfList)
sum = 0
sums = []
for x in elfList:
    if x.isdigit():
        sum += int(x)
        print("ADD")
    else:
        sums.append(sum)
        sum = 0
        print("TOTAL")

sums.sort(reverse = True)
print(sums[0] + sums[1] + sums[2])