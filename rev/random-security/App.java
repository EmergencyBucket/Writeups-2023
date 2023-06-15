import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static String getFlag() {
        try {
            Scanner scanner = new Scanner(new File("flag.txt"));

            return scanner.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("There has been an unexpected error. Please report this to the CTF admins.");
        }

        return "";
    }
    public static void main(String[] args) {
        System.out.println("Since I am nice I will give you a random number:");
        System.out.println(Math.random());
        System.out.println("Now give me one!");
        Scanner scanner = new Scanner(System.in);

        if(scanner.nextDouble()==Math.random()) {
            System.out.println("Correct! Here is your flag: " + getFlag());
        }
        else {
            System.out.println("WRONG DOUBLE!!!!!");
        }

        scanner.close();
    }
}