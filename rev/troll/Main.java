import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static String FLAG = System.getenv("FLAG");
    
    public static String answer = "6a4343aa3cb4cfc411";
    
    public static ArrayList<String> questions = new ArrayList<>(Arrays.asList("How many points to reset valor rank?",
            "What is the full name of the final boss in the last wish?",
            "Who was the hunter vanguard before cayde-6?",
            "What is the name of the city on neptune?",
            "What grenade suppresses targets?",
            "What perk used to be exclusive to vault of glass weapons, but now can roll on root of nightmares weapons?",
            "Which weapon foundry is known for its liquid ammo?",
            "Which color was the dead orbit faction most closely associated with?",
            "How many times has banshee, the gunsmith, been reset?",
            "What is the full name version of the EDZ?",
            "During a weak curse week, where is petra venj located?",
            "Where did saint-14 search when looking for osiris?",
            "What is the name of cayde-6's ghost?",
            "Which perk grants bonus damage when surrounded by enemies?",
            "Which exotic weapon resembles a lever-action rifle?",
            "Which weapon foundry tried bribing shaxx?",
            "Who does xur work for?",
            "How many oracles spawn during the 3rd round of oracles during a phase against Atheon?",
            "Which clan completed the scourge of the past raid first?",
            "Which ritual playlist is the drifter associated with?",
            "Which seasonal event featured arbalest as its exotic weapon?",
            "The icon of the extended barrel perk is the same as which shotgun perk?",
            "What was the name of the nordic faction of the black armory?",
            "Which augment allows players to interact with panels by shooting them in the deep stone crypt?",
            "Which mod gives a fixed portion of health upon collecting an orb of power?",
            "Which weapon stat increases the draw and stow speed of a weapon?",
            "How many known ahamkara still live?"));
    
    public static void main(String[] args) {
        System.out.println("Beware! I am **LUKE SMITH**! Creator of FOMO!");
        System.out.println("I will ask you a series of questions, and at the end if you answer them ALL correctly, you might get flag.");
        System.out.println("If you would like you can skip a question by saying SKIP.");
        
        StringBuilder sb = new StringBuilder();

        Scanner scanner = new Scanner(System.in);
        
        while (sb.length()!=answer.length()) {
            Random random = new Random();
            int choice = random.nextInt(questions.size());
            String question = questions.get(choice);
            System.out.println(question);
            
            String in = scanner.nextLine();
            
            if(!in.equals("SKIP")) {
                sb.append(question.charAt(choice-Integer.parseInt(in)));
            }
        }
        
        if(sb.toString().equals(answer)) {
            System.out.println(FLAG);
        }
        else {
            System.out.println("WRONG! LEAVE!");
        }
    }
    
}
