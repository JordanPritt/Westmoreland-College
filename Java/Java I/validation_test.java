import java.util.Scanner;

public class validation_test {
  public static void main(String[] args) {

    Scanner user_input = new Scanner(System.in);

    int number = 0;
    boolean num_val;

    do {
      System.out.print("Enter a number: ");
      if (user_input.hasNextInt()) {
        number = user_input.nextInt();
        num_val = true;
      } else {
        System.out.println("That isn't a number");
        num_val = false;
        user_input.next();
      }
    }

    while (!(num_val));
    System.out.println(number + " is a number!");

    user_input.close();
  }
}