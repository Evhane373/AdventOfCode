from pathlib import Path
import string

input = open(Path(__file__).with_name("Input.txt"))
inputSplit = input.read().split('\n')


def packetIdentifier(inp, length):
    s = ''
    count = 0
    for x in inp:
        if len(s) < length:
            s += x
            print(s)
            count += 1
        else:
            match = 0
            for y in s:
                match = 0
                for z in range(0,length):
                    if y == s[z]:
                        match += 1
                if match > 1:
                    break
            if match == 1:
                print(s)
                print(count)
                break
            else:
                s = s[1:]
                s += x
                count += 1

packetIdentifier(inputSplit[0], 4)
packetIdentifier(inputSplit[0], 14)