
from random import randint
from sys import argv

ATTACK_TO_ROLL_MAP = {
    "testAttack": ["1d20", "2d4"]
}

def tryParseInt(s):
    try:
        return int(s)
    except ValueError:
        return None

def performSingleRoll(singleRoll):
    singleRoll = singleRoll.strip()
    if "-" in singleRoll:
        singleRoll = singleRoll.replace("-", "+-")
    value = tryParseInt(singleRoll)
    if value != None:
        return value

    if "+" in singleRoll:
        rollPart, offset = singleRoll.split("+")
    else:
        rollPart, offset = singleRoll, 0
    offset = int(offset)
    numRolls, numSides = rollPart.split("d")
    numRolls, numSides = int(numRolls), int(numSides)
    total = offset
    for i in xrange(numRolls):
        total += randint(1, numSides)
    return total

def performRoll(rollString):
    rollString = rollString.strip()
    total = 0
    for singleRoll in rollString.split(","):
        total += performSingleRoll(singleRoll)
    return total

def performAndPrintRoll(rollString):
    total = 0
    for singleRoll in rollString.split(","):
        rollAmount = performSingleRoll(singleRoll)
        print "Rolling '" + singleRoll + "': " + str(rollAmount)
        total += rollAmount
    print "The total is: " + str(total)

def performAndPrintAttack(attackName):
    if attackName not in ATTACK_TO_ROLL_MAP:
        print "Attack name '" + attackName + "' was not found."
        return;

    total = 0
    print "Performing attack: '" + attackName + "'"
    for rollString in ATTACK_TO_ROLL_MAP[attackName]:
        rollAmount = performRoll(rollString)
        print "Rolling '" + rollString + "': " + str(rollAmount)
        total += rollAmount
    print "The total is: " + str(total)

if __name__ == "__main__":
    for attack in argv[1:]:
        print ""
        if attack in ATTACK_TO_ROLL_MAP:
            performAndPrintAttack(attack)
        else:
            performAndPrintRoll(attack)
        print ""
