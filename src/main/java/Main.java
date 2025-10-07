import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean repeat = true;

        do {
            try {
                System.out.println("Choose a bedtime story from the list: " +
                        "\nGoldilocks" +
                        "\nHansel and Gretel" +
                        "\nMary had a Little Lamb\n");
                String story = scanner.nextLine();

                BufferedReader reader = null;

                if (story.equalsIgnoreCase("goldilocks")) {
                    reader = new BufferedReader(new FileReader("src/main/resources/goldilocks.txt"));
                } else if (story.equalsIgnoreCase("hansel and gretel")) {
                    reader = new BufferedReader(new FileReader("src/main/resources/hansel_and_gretel.txt"));
                } else if (story.equalsIgnoreCase("mary had a little lamb")) {
                    reader = new BufferedReader(new FileReader("src/main/resources/mary_had_a_little_lamb.txt"));
                } else {
                    System.err.println("Invalid input. Please enter a valid title.");
                }

                if (reader != null) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    reader.close();
                }

            } catch (FileNotFoundException e) {
                System.err.println("Error: " + e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("\nWould you like to pick another bedtime story? yes/no");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                repeat = true;
            } else if (answer.equalsIgnoreCase("no")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.err.println("Invalid input. Please enter \"yes or no\"");
            }
        } while (repeat);

    }
}




