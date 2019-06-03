import java.util.*;

/**
 *
 * Created by: Jordan Pritt Date: 3/29/17
 *
 * Purpose: This application takes in any amount of words separated by a single
 * space, tokenizes the words by a single space deliminator, and then sorts the
 * names alphabetically. After displaying the words the user is prompted to
 * submit another set of words or exit the application.
 *
 */

public class Main {

  public static void main(String[] args) {

    // create scanner to get user input
    Scanner input = new Scanner(System.in);

    // variables for continuing loop or getting words
    String typedWords, answer;

    do {

      // /prompt user
      System.out.println("Please enter as many words as desired:" + "\n");
      typedWords = input.nextLine();

      // get user input
      typedWords = typedWords.toLowerCase();

      // create an alphabetized set and fill it with user input.
      Set<String> words = new TreeSet<>(Arrays.asList(typedWords.split(" ")));

      // display the now sorted words the user typed with lambda foreach loop, because
      // why not?
      words.forEach(System.out::println);

      // prompt user to continue or exit
      System.out.println("\n" + "Type 'y' and then press enter/return to run another set of words" + "\n"
          + "or anything else then enter/return to exit application.");

      // get user's answer to prompt
      answer = input.nextLine();

    } while (answer.equalsIgnoreCase("y"));
  }
}