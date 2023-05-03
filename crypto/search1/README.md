# Repeated Search Analysis Part 1
## Problem Description
Johnny patched the previous leak, but seems to have created a new one. See if you can still decrypt the flag.
## User Files
generator.py
## Solve
The program is just RSA encryption, but we're given $(p-2)(q-2)$. Since $(p-2)(q-2)=pq-2p-2q+4=n-2p-2q+4$, we can get $p+q$ fairly easily. Let's assign $k=p+q$. $p$ and $q$ are both garunteed to be greater than $2^{127}$, due to the way that `getPrime` generates them. Let's assume $p\le q$. If that's the case then $2^{127}\le p\le\frac{k}{2}$. From here we can substitute $q=k-p$ and search for p. We are given $n$. $n=pq=p(k-p)$. If we treat this equation as a function of $p$, we can see that for a constant $k$, over the range $[2^{127},\frac{k}{2}]$, as $p$ increases, $n$ increases. Therefore, we can do a binary search over the range $[2^{127},\frac{k}{2}]$ until putting in our hypothetical $p$ into this function matches the given value of $n$. 
```python
from Crypto.Util.number import inverse, long_to_bytes
m = # first value in output
n = # second value in output
leak = # third value in output
e = 65537
sumVal = (n - leak + 4) // 2

def binSearch(higher, lower, current):
    q = sumVal - current
    if q * current == n:
        return current
    elif q * current < n:
        return binSearch(higher, current, (higher + current)//2)
    else:
        return binSearch(current, lower, (lower + current)//2)

p = binSearch(sumVal // 2 + 1, 2**127, ((sumVal // 2 + 1) + 2**127) // 2)
q = n // p
l = (p-1)*(q-1)
d = inverse(e, l)
print(long_to_bytes(pow(m, d, n)))
```
## Flag
```
bucket{d0nt_l34K_pr1v4T3_nUmS}
```