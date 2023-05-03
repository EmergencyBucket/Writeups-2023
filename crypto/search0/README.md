# Repeated Search Analysis Intro
## Problem Description
Johnny's a math whiz and figured out a method to encrypt his messages securely. He's a bad programmer though, and his program seems to be leaking some important bits. Can you decrypt the flag?
## User files
generator.py
## Solve
The program is just RSA encryption, but 108 out of 120 bits of one of the prime factors are leaked. That leaves 20 unknown bits for that factor, which can be brute forced.
```python
from Crypto.Util.number import isPrime, inverse, long_to_bytes
m = # first value in output
n = # second value in output
x = # binary dump at end of output (is a string, put quotes around it)
e = 65537
y = x
def isFactor(p):
    return isPrime(p) and n % p == 0
x += "0"*(128-len(x))
y += "1"*(128-len(y))
x = int(x,2)
print(x)
y = int(y,2)
print(y)
count = 0
possible = filter(isFactor, range(x, y+1))
p = next(possible)
q = n // p
l = (p-1)*(q-1)
d = inverse(e, l)
print(long_to_bytes(pow(m, d, n)))
```
## Flag
```
bucket{m3m0ry_L3Aks_4R3_bAD}
```