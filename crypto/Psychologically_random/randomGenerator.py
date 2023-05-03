import random
import sympy

def humanRandomGenerator(low, high):
    goodRandom = False
    errors = abs(high-low)/5 # 20% error is basically arbitrary -- needed to narrow the range of possible values
    while not goodRandom:
        base = random.randint(low, high)

        if random.randint(0, 100) < 100/(high-low): # chance of randomly getting non-psychology value is function of random range
            goodRandom = True
            continue

        if base % 2 == 0: # if the base is even, we can exclude it
            continue
        if base < low + errors or base > high - errors: # if the base is within the error range of the endpoints, we can exclude it
            continue
        if abs(base - (low + high)/2) < errors/2: # if the base is within the error range of the midpoint, we can exclude it
            continue
        if not sympy.isprime(base):
            continue
        if base < (low + high)/2: # if the base is less than the midpoint, it is less likely to be picked
            if random.randint(0, 100) < 40: # 40% chance of excluding it
                continue
        goodRandom = True

    return base
    
def encoder(file):
    seedKey = [] # set of 4 psychologically random numbers between 0 and 255 inclusive
    addKey =  humanRandomGenerator(1, 10)# psychologically random number between 1 and 10 inclusive

    for i in range(4):
        seedKey.append(humanRandomGenerator(0, 255))

    sKey = seedKey.copy()

    with open(file, "rb") as f:
        flag = f.read()

    encryptedFlag = bytearray()
    for i in range(len(flag)):
        encryptedFlag.append(flag[i] ^ seedKey[i%4])
        seedKey[i%4] = (seedKey[i%4] + addKey) % 255
    
    return encryptedFlag

def decoder(encryptedFlag, seedKey, addKey):
    decryptedFlag = bytearray()
    for i in range(len(encryptedFlag)):
        decryptedFlag.append(encryptedFlag[i] ^ seedKey[i%4])
        seedKey[i%4] = (seedKey[i%4] + addKey) % 255


print(encoder("flag.txt"))