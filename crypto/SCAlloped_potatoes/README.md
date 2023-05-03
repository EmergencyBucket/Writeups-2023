# SCAlloped_potatoes - Medium
**Author:** [cogsworth64](https://github.com/cogsworth64)
## Problem Description
I'm using a potato battery farm to power my computer. I know potatoes are virtually indestructible, but is my RSA decryption key still safe from a physical attack?

## User's Files
- powerTrace.txt

## Solution
Based on the existence of a power trace and the problem's title (SCA stands for Side Channel Analysis/Attack), it is evident that this is a Side Channel Analysis problem. It is given that RSA decryption is being performed, and that we are supposed to find the decryption exponent. RSA decrypts via the following formula:
$m = c^d\ mod\ n$
The two operations that are being performed on the ciphertext are the modulo operation and exponentiation. The side channel attack works by attacking the exponentiation phase of the RSA decryption. Since regular exponentiation methods (multiply $x$ by itself $n$ times) are very power and time intensive, modern computers usually use a different algorithm for calculating exponents. A simple Google search will tell you that the algorithm is called the **Binary Exponentiation algorithm**. For each bit in the exponent, the base is multiplied by itself and if the bit is a 1, the base is also multiplied by the exponent. In other words, for each bit in the private key, first square the output and if the bit is a 1, also multiply the output by the base. According to SCA literature, squaring takes less power than multiplying. So from the power trace, it is possible to find the entire decryption key.

The basic approach is to simply count the number of peaks and valleys from a visual inspection of the power trace. However this is also very error prone, time consuming, and boring. An easier way would be to write a script that first normalizes the power values, and then spits out a flag based on the data. By looking through the power trace, it is pretty obvious that there are three power values - a low value, which separates out bytes, a high value, and a base value. Additionally, the values are split into groups of 10. To find the normalization range and mean values, it's possible to plot a distribution of the average values of the groups of 10 and find the peaks and ranges of the peaks. However, I am too lazy to do that, and I will just use the knowledge from when I wrote the problem. With that information, generating a solve script is possible:
```py
with open("powerTrace.txt", "r") as f:
    power = f.read()

powerList = power[1:-1].split(",")
for i in range(len(powerList)):
    powerList[i] = int(powerList[i])

finStr = ""

def average(lst):
    return sum(lst) / len(lst)

avgLst = []

for i in range(0, len(powerList), 10):
    avgLst.append(average(powerList[i:i+10]))

for i in range(1, len(avgLst)):
    if abs(100 - avgLst[i]) < 10:
        finStr += " "
    elif abs(150 - avgLst[i]) < 10:
        if abs(200 - avgLst[i+1]) < 10:
            i+=1
            finStr += "1"
        else:
            finStr += "0"

byteList = finStr.split(" ")
print(byteList[0])
flag = ""
for i in byteList:
    flag += chr(int(i, 2))
```

The flag is then given as ```bucket{I5_tH15_aN_NSA_baCkDoOr?}```