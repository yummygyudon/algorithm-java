"""
1. 0부터 시작해서 차례대로 말하기
    - 첫번째 사람 : 0 ~ 열번째 사람 : 9
    - 10 이상부턴 한자리씩 끊어서 말하기 -> 열한번째 사람 : 1 열두번째 사람 : 0
"""
CONVERT_MAP = "0123456789ABCDEF"
TYPE = 0

def solution(n, t, m, p):
    global TYPE 
    TYPE = n
    totalString = makeTotalNumber(t*m)
    answer = ''
    # m 간견으로 indexing
    for i in range(p-1, t*m, m) :
        answer += totalString[i]    
    return answer

def makeTotalNumber(totalTurn) :
    turn = 0
    turnNum = 0
    totalString = ''
    isOver = False
    while True :
        if isOver :
            break
        convertNum = convert(turnNum)
        for i in range(len(convertNum)):
            turn += 1
            totalString += convertNum[i]
            if turn == (totalTurn) :
                isOver = True
                break
        turnNum += 1
    return totalString

def convert(num) :
    tmp = ''
    while True :
        if (num // TYPE == 0 ) :
            tmp += CONVERT_MAP[(num%TYPE)]
            break
        tmp += CONVERT_MAP[(num%TYPE)]
        num = num // TYPE
    return tmp[::-1]