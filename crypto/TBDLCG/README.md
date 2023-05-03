# TBDLCG - Easy
**Author:** [cogsworth64#1110](https://github.com/cogsworth64)
## Problem Description
BLAHFALJFAJDFLBLAHAOIFLJFDA - is that random enough for you?

## User's Files
- server.py

## Running
```bash
docker build -t tbdlcg_easy .
docker run -p 5000:80 tbdlcg_easy
```
## Solution
This is basically a trivial Linear Congruential Generator problem. The random function is given in the following format: \
$r_{s+1} = (a * r_s + b) mod n$ \
Since the random values are given and n is known to be 9, it is possible to develop a system of equations to solve for a and b with just 3 random values: \
$r_{s+1} = (a * r_s + b) mod 9$ \
$r_{s+2} = (a * r_{s+1} + b) mod 9$ \
At this point you have two equations, and two unknowns, which can be solved by subtracting one equation from the other: \
$r_{s+2} - r_{s+1} = a * (r_{s+1} - r_{s+2}) mod 9$ \
From here, we can easily solve for a: \
$a = (r_{s+2} - r_{s+1})/((r_{s+1} - r_s) inv mod 9) mod 9$ \
And then b can be solved easily with just one equation: \
$r_{s+1} = (a * r_s + b) % 9$ \
$b = (r_{s+1} - a * r_s) % 9$ \
Since there are two pseudorandom functions running concurrently, it is necessary to solve for two sets of a and b. Once they are known, the random function is known, and the subsequent values of location and spin can be generated before each "point".  

Flag: ``bucket{#1_victory_royale_86f2b88341d8d}``