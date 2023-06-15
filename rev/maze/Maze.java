import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Maze {

    public static char[][] maze;

    public static Random random = new Random();

    public static String getFlag() {
        try {
            Scanner scanner = new Scanner(new File("flag.txt"));

            return scanner.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("There has been an unexpected error. Please report this to the CTF admins.");
        }

        return "";
    }

    public static void initMap() {
        System.out.println("I've learned from my mistakes and this time I will construct a full maze you will never be able to break out of!!!");

        maze = new char[41][41];

        for (int r = 1; r <= 20; r++) {
            if(r%2==1) {
                for (int x = 20-r; x <= 20+r; x++) {
                    for (int y = 20-r; y <= 20+r; y++) {
                        if(x == 20-r || x == 20+r || y == 20-r || y == 20+r) {
                            maze[x][y] = '#';
                        }
                    }
                }
            }
        }

        for (int x = 0; x < maze.length; x++) {
            for (int y = 0; y < maze[x].length; y++) {
                if(maze[x][y]!='#') {
                    maze[x][y]=' ';
                }
                System.out.print(maze[x][y]);
            }
            System.out.println();
        }

        for(int i = 0; i < 10; i++) {
            int len = 3+(i*4);

            int rand = random.nextInt(len);

            int side = random.nextInt(4);

            switch(side) {
                case 0: {
                    maze[20+len/2][20-len/2+rand]=' ';
                    break;
                }
                case 1: {
                    maze[20-len/2+rand][20+len/2]=' ';
                    break;
                }
                case 2: {
                    maze[20-len/2][20-len/2+rand]=' ';
                    break;
                }
                case 3: {
                    maze[20-len/2+rand][20-len/2]=' ';
                    break;
                }
            }
        }

        maze[20][20]='X';
    }

    public static void main(String[] args) {
        initMap();

        int currX = 20;
        int currY = 20;

        try {
            Scanner input = new Scanner(System.in);

            while(true) {
                char in = input.next().charAt(0);

                if(in == 'Q') {
                    if(maze[currX-1][currY-1]=='#') {
                        break;
                    }
                    maze[currX][currY]=' ';
                    maze[--currX][--currY]='X';
                }
                if(in == 'W') {
                    if(maze[currX-1][currY]=='#') {
                        break;
                    }
                    maze[currX][currY]=' ';
                    maze[--currX][currY]='X';
                }
                if(in == 'E') {
                    if(maze[currX-1][currY+1]=='#') {
                        break;
                    }
                    maze[currX][currY]=' ';
                    maze[--currX][++currY]='X';
                }
                if(in == 'D') {
                    if(maze[currX][currY+1]=='#') {
                        break;
                    }
                    maze[currX][currY]=' ';
                    maze[currX][++currY]='X';
                }
                if(in == 'C') {
                    if(maze[currX+1][currY+1]=='#') {
                        break;
                    }
                    maze[currX][currY]=' ';
                    maze[++currX][++currY]='X';
                }
                if(in == 'S') {
                    if(maze[currX+1][currY]=='#') {
                        break;
                    }
                    maze[currX][currY]=' ';
                    maze[++currX][currY]='X';
                }
                if(in == 'Z') {
                    if(maze[currX+1][currY-1]=='#') {
                        break;
                    }
                    maze[currX][currY]=' ';
                    maze[++currX][--currY]='X';
                }
                if(in == 'A') {
                    if(maze[currX][currY-1]=='#') {
                        break;
                    }
                    maze[currX][currY]=' ';
                    maze[currX][--currY]='X';
                }
                if(in == 'R') {
                    System.out.println("Here is a random number for you since i'm nice: " + random.nextDouble());
                }
            }

            input.close();

            System.out.println("YOU LOSE I WIN! BETTER LUCK NEXT TIME!");
        }
        catch (Exception e) {
            if(e instanceof ArrayIndexOutOfBoundsException) {
                System.out.println(getFlag());
            }
        }
    }
}