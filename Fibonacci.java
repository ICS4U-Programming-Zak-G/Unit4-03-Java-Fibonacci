// Import libraries
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
* This program uses recursion with the Fibonacci Sequence
* To find the value at a certain term.
*
* @author  Zak Goneau
* @version 1.0
* @since   2025-04-24
*/

// Creating class
public final class Fibonacci {

    /**
     * This is a private constructor used to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Fibonacci() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     * @throws Exception - Input/Output exception
     */

    public static void main(final String[] args) throws Exception {

        // Initialize output string
        String outputStr = "";

        // Open file writer to write to output file
        final FileWriter myWriter = new FileWriter("output.txt");

        // Introduce program to user
        System.out.println("This program uses recursion to "
                + "determine the value at a certain term in the "
                + "Fibonacci sequence. The output will be in a file.");

        // Open input file and prepare to read
        final File file = new File("./input.txt");
        final Scanner scanner = new Scanner(file);

        // Loop while there's another line in the file
        while (scanner.hasNextLine()) {

            // Get current line from file
            final String line = scanner.nextLine();

            // Try to convert line to integer
            try {
                // Convert line to integer
                final int numberLine = Integer.parseInt(line);

                // Check if number is positive
                if (numberLine < 0) {
                    // Add to output string if negative
                    outputStr += numberLine + " is not a positive integer.\n";

                // Otherwise number is positive
                } else {
                    // Call function to find value at term
                    final int fibonacciResult = fibonacci(numberLine);

                    // Add result to output string
                    outputStr += "The term of " + numberLine
                         + " is " + fibonacciResult + "\n";

                }
            // Catch invalid input and add to output string
            } catch (NumberFormatException error) {
                outputStr += line + " is not a positive integer.\n";
            }
        }

        // Write to output file
        myWriter.write(outputStr);

        // Display success message
        System.out.println("Success, the term "
                + "is printed in the output file.");

        // Close scanner
        scanner.close();

        // Close writer
        myWriter.close();
    }

    /**
    * This function finds the value at a term in the Fibonacci Sequence.
    *
    * @param number The term in the Fibonacci Sequence
    * @return The value at the term in the Fibonacci Sequence
    */

    // Define function to find value at term
    public static int fibonacci(final int number) {
        // Set base case
        if (number <= 1) {
            // Return number if 0 or 1
            return number;

        // Otherwise perform recursion
        } else {
            // Call function and return value
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }
}
