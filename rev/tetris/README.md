# Tetris - Medium
**Author:** [Cogsworth64](https://github.com/cogsworth64)

### Files
[Tetris.jar](tetris.jar)

## Problem Description
I'm terrible at Tetris - but luckily, my flag retrieval skills are independent of my Tetris skills. NOTE: the flag follows the format "bucket{\*}"

## Solution
Running the program leads to a simple Tetris game. When you lose, the program prints a string, which will most likely not be the flag. By putting the output code into Ghidra, or some other Java decompiler, you can see that there is a command that prints the flag in the Tetris class. The method's source traces back to the G class. Within the method, there are a series of boolean expressions that check if the flag is correct. After the boolean expressions, there is a method that converts each decimal number in the array into an ASCII value by casting to a char type. Based on the flag wrapper format, the first 7 characters and last character are known to be "bucket{" and "}". Based on the size of the array, the flag is 25 characters long. From there, doing math based on the boolean expressions allows you to glean the ASCII decimal numbers for the flag

Flag: ``bucket{t3tR1s_is_L1F3_!!}``