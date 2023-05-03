from Crypto.Random import random
import random

d = b"bucket{I5_tH15_aN_NSA_baCkDoOr?}" # flag

basePower = 100
squarePower = 50
multPower = 50
powerTrace = []

for byte in d:
    for i in range(5):
        powerTrace.append(basePower + random.randint(-5,5)) #base power - once per byte
    for bit in bin(byte)[2:]:
        for i in range(10):
            powerTrace.append(basePower + random.randint(-10,10) + squarePower) #square power
        if bit == '1':
            for i in range(10):
                powerTrace.append(basePower + random.randint(-10,10) + multPower) #mult power

with open("powerTrace.txt", "w") as f:
    f.write("[")
    for i in range(len(powerTrace)-1):
        f.write(str(powerTrace[i])+",")
    f.write(str(powerTrace[-1]))
    f.write("]")