/*
* The StringBlowUp program implements an application that
* takes a string the user inputs and replaces numbers with a number of the next
* digit equal to themself.
*
* @author  Ben Whitten
* @version 1.0
* @since   2020-11-25 
*/

import java.util.Scanner;  // Import the Scanner class

public class StringBlowUp {
  /**
   * This class is what runs the program.
   */
  public static void main(String[] args) {

    // Creating a scanner.
    Scanner scan = new Scanner(System.in);

    // Gets variable chosenString from the user.
    System.out.println("Insert a string:");
    String chosenString = scan.nextLine();

    // Stating important variables for later.
    String finalString = "";
    int timeThrough = 0;

    // Process.
    /* For loop for going through each character in the string a flaging the
     * characters which are integers.
     */
    for (int position = 0; position < chosenString.length(); position++) {
      boolean flag = (Character.isDigit(chosenString.charAt(position)));
      // If the character is flagged, do:
      if (flag) {
        // Try to catch any errors.
        try {
          while (true) {
            /* Turns any integers into the next character a number of times
             * equal to themselves.
             */
            finalString = finalString + chosenString.charAt(position + 1);
            timeThrough = timeThrough + 1;
            /*
             * I dont know why I have to subtract 49 but its the only way it
             * works.
             */
            if (timeThrough > (chosenString.charAt(position) - 49)) {
              timeThrough = 0;
              break;
            }
          }
        // If the next int is a whitespace, it catches it and fixes the string.
        } catch (Exception e) {
          finalString = finalString + chosenString.charAt(position);
        }
      // If the character is a letter, place it in as normal.
      } else {
        finalString = finalString + chosenString.charAt(position);
      }
    }
    // Prints out the blown up string.
    System.out.println();
    System.out.println("Your blown up string is:");
    System.out.println(finalString);

  }
}
