/**
 * Date last modified: 10/5/2016
 * Author = Jordan Pritt
 * Project for Java 1 
 */

import java.util.Scanner;

public class project_4 {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    int choice = 0;
    double celsius = 0, fahrenheit = 0, inches = 0, centimeters = 0, length = 0, width = 0, height = 0, boxVolume = 0,
        radius = 0, sphereVolume = 0, result = 0;
    double boxArea = box(result, length, width, height);
    double sphereArea = sphere(result, radius);
    char doAgain = 'y';

    while (doAgain == 'y' || doAgain == 'Y') {

      System.out.print(" Main Menu \n 1. Celsius to Fahrenheit \n 2. Inches to Centimeters \n "
          + "3. Find Volume and Area of a box \n 4. Find Volume and Area of a sphere \n"
          + "Please select one of the four choices \nThen press enter to continue");
      choice = input.nextInt();

      if (choice == 1) {
        System.out.println("This program will convert a celsius value into a fahrenheit one. \n");

        System.out.println("Please enter the tempature for conversion: ");
        celsius = input.nextInt();

        fahrenheit = 1.8 * celsius + 32.0;

        System.out.println(celsius + " degree(s) in celcius" + " is " + fahrenheit + " in fahrenheit. \n");

        System.out.println("Do you want to continue?\n: " + "enter \'Y\' for another round\n "
            + " enter \'N\'   to end the program\n");

        doAgain = input.next().charAt(0);
      }

      else if (choice == 2) {
        System.out.println("This program will convert inches to centimeters. \n");

        System.out.println("Please enter the length for conversion: ");
        inches = input.nextInt();

        centimeters = 2.54 * inches;

        System.out.println(inches + " inches is " + centimeters + " centimeters. \n");

        System.out.println("Do you want to continue?\n: " + "enter \'Y\' for another round\n "
            + " enter \'N\'   to end the program\n");

        doAgain = input.next().charAt(0);
      }

      else if (choice == 3) {
        System.out.println("Enter length: ");
        length = input.nextDouble();

        System.out.println("Enter height: ");
        height = input.nextDouble();

        System.out.println("Enter width: ");
        width = input.nextDouble();

        boxVolume = length * width * height;
        boxArea = box(result, length, width, height);

        System.out.println("The area of your box is: " + boxArea + "\n" + "The volume of your box is: " + boxVolume);

        System.out.println("Do you want to continue?\n: " + "enter \'Y\' for another round\n "
            + " enter \'N\'   to end the program\n");
        doAgain = input.next().charAt(0);

      }

      else if (choice == 4) {
        System.out.println("Enter radius: ");
        radius = input.nextDouble();

        sphereVolume = 4.0 / 3.0 * 3.14159 * Math.pow(radius, 3);
        sphereArea = sphere(result, radius);

        System.out.println(
            "The area of your sphere is: " + sphereArea + "\n" + "The volume of your sphereVolume is: " + sphereVolume);

        System.out.println("Do you want to continue?\n: " + "enter \'Y\' for another round\n "
            + " enter \'N\'   to end the program\n");
        doAgain = input.next().charAt(0);
      }

      else {
        System.out.println("That is not a valid option. Please restart and try again");

      }
    }
  }

  public static double box(double result, double length, double width, double height) {
    result = length * width;
    return result;
  }

  public static double sphere(double result, double radius) {
    result = 4 * 3.14159 * (radius * radius);
    return result;
  }
}