import java.io.File;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Vocab {

    public static ArrayList<String[]> getVocab(String filename) {
        ArrayList<String[]> vocab = new ArrayList<String[]>();
        File file = new File(filename);
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" - ");
                vocab.add(words);
            }
        } catch (FileNotFoundException error) {
            System.out.println("File not found");
        }
        Collections.shuffle(vocab);
        return vocab;
    }

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            System.out.println("Welcome to the IntroToCompSci Trainer!");
            System.out.println("Please enter the name of the file you would like to use (gpt, mine): ");

            Scanner scanner = new Scanner(System.in);
            String word = scanner.nextLine();

            ArrayList<String[]> vocab = getVocab("Grade11/raw" + word + ".txt");

            System.out.println("How many pieces of vocab would you like to test yourself on? (0 for all): ");
            int num = scanner.nextInt();

            if (num == 0) {
                for (String[] vocabWord: vocab) {
                    System.out.println("What is the definition of " + vocabWord[0] + "?");
                    String answer = scanner.nextLine();
                    System.out.println("The answer is: \n" + vocabWord[1]);
                }
            } else {
                for (int i = 0; i < num; i++) {
                    System.out.println("What is the definition of " + vocab.get(i)[0] + "?");
                    String answer = scanner.nextLine();
                    System.out.println("The answer is: \n " + vocab.get(i)[1]);
                }
            }
            
        }
    }
}