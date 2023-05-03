# Repeated Search Analysis Part 3
## Problem Description
Nah nah, now it's official. Johnny has to have figured it out by now
## User Files
generator.py
## Solve
The program is a variation on the standard RSA encryption. The flag is actually part of one of the modulus factors, and the offset between that factor and the flag is the encoded message. Since we're provided the private key, we can decode the offset very easily. From there, we just need to get the two modulus factors and try subtracting the offset from both of them. An explanation for deriving the factors from the private key is listed here: https://crypto.stackexchange.com/questions/11509/computing-p-and-q-from-private-key.
An implementation of this process is shown below.
```python
from Crypto.Util.number import inverse, getRandomInteger, long_to_bytes
m = # first value in output
n = # second value in output
d = # third value in output
e = 65537
offset = pow(m, d, n)
f = e*d - 1
s = 0
g = f
while g % 2 == 0:
    s += 1
    g = g // 2

c = -1
b = 0
while c != 1:
    if c == -1:
        b = 1
        while b == 1 or b == -1:
            a = getRandomInteger(127)
            b = pow(a, g, n)
    else:
        b = c
    c = pow(b, 2, n)

def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)

p = gcd(b-1, n) - offset
q = gcd(b+1, n) - offset

print(long_to_bytes(p))
print(long_to_bytes(q))
```
## Flag
```
bucket{sw1tCH1nG_D1dNT_W0rK}
```