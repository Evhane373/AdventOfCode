from pathlib import Path
input = open(Path(__file__).with_name("Input.txt"))

def rps(a, x):
    rock = 1
    paper = 2
    scissors = 3
    win = 6
    draw = 3
    loss = 0
    score = 0
    
    if a == 'A': #rock
        if x == 'X': #scissors
            score += scissors + loss
        elif x == 'Y': #paper
            score += paper + win
        elif x == 'Z': #scissors
            score += scissors + loss
    elif a == 'B': #paper
        if x == 'X': #rock
            score += rock + loss
        elif x == 'Y': #paper
            score += paper + draw
        elif x == 'Z': #scissors
            score += scissors + win
    elif a == 'C': #scissors
        if x == 'X': #rock
            score += rock + win
        elif x == 'Y': #paper
            score += paper + loss
        elif x == 'Z': #scissors
            score += scissors + draw
            
    print(score)
    return score

def ldw(a, x):
    rock = 1
    paper = 2
    scissors = 3
    win = 6
    draw = 3
    loss = 0
    score = 0
    
    if a == 'A': #rock
        if x == 'X': #loss
            score += scissors + loss
        elif x == 'Y': #draw
            score += rock + draw
        elif x == 'Z': #win
            score += paper + win
    elif a == 'B': #paper
        if x == 'X': #loss
            score += rock + loss
        elif x == 'Y': #draw
            score += paper + draw
        elif x == 'Z': #win
            score += scissors + win
    elif a == 'C': #scissors
        if x == 'X': #loss
            score += paper + loss
        elif x == 'Y': #draw
            score += scissors + draw
        elif x == 'Z': #win
            score += rock + win
            
    print(score)
    return score
inputList = input.read().split('\n')
score = 0



for x in inputList:
    xSplit = x.split(" ")
    #score += rps(xSplit[0], xSplit[1])
    score += ldw(xSplit[0], xSplit[1])
print(score)