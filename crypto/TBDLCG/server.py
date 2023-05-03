import os
import math
import random

def r(a, b, seed, n):
    return (a * seed + b) % n

if __name__ == '__main__':
    print("""You are playing a game of table tennis against Cogsworth64's AI bot.
The bot is only able to serve the ball, because Cogsworth64 disabled the other options.
The bot will send a certain spin (represented by a number 0-8) and location (represented by a number 0-8) at each point. If you can guess the spin and location, you win the point. If you can't, the bot wins the point.
The first player to win 20 points wins the game. Try not to lose.
""")
    a = random.randint(0, 10000)
    b = random.randint(0, 10000)
    seedSpin = random.randint(0, 10000)
    seedLocation = random.randint(0, 10000)
    n = 9
    playerScore = 0
    botScore = 0
    while(playerScore < 5 and botScore < 5):
        print("Your score: " + str(playerScore))
        print("Bot's score: " + str(botScore))
        location = int(input("What is your guess for location? "))
        spin = int(input("What is your guess for spin? "))
        seedLocation = r(a, b, seedLocation, n)
        seedSpin = r(a, b, seedSpin, n)
        if (seedSpin == spin and seedLocation == location):
            playerScore += 1
            print("You win the point!")
        else:
            botScore += 1
            print("You lose the point!")
            print(f"The bot's spin was {seedSpin} and location was {seedLocation}")
    if (playerScore == 5):
        print("You win the game!")
        with open("flag.txt", "rb") as f:
            print(f.read())
    elif(botScore == 5):
        print("You lose the game! \n No flag for you!")
            