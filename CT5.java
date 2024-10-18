import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperature {

    public static void main(String[] args) {
        // Import Scanner and create a scanner object for input
        Scanner input = new Scanner(System.in);
        
        // Create ArrayLists to store days and temperatures
        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();
        
        // Initialize a variable to hold the total temperature for weekly average
        double totalTemp = 0; 

        // Days of the week in order
        String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        // Initial prompt to check if the user is ready
        System.out.println("Welcome to the Weekly Temperature Logger!");
        System.out.print("Are you ready to input daily temperatures for the week? (yes/no): ");
        String startInput = input.nextLine().trim().toLowerCase();

        // If the user isn't ready, exit the program
        if (!startInput.equals("yes")) {
            System.out.println("Okay, come back when you're ready.");
            input.close();
            return;
        }

        // Automatically prompt for missing days' temperatures
        for (String day : weekDays) {
            if (!days.contains(day)) {
                // Ask for the missing day's temperature
                System.out.print("Enter the average temperature for " + day + ": ");
                double tempInput = input.nextDouble();
                input.nextLine();  // Clear the newline character

                // Add the day and temperature to respective ArrayLists
                days.add(day);
                temperatures.add(tempInput);

                // Update total temperature for average calculation
                totalTemp += tempInput;
            }
        }

        // After collecting all temperatures, allow the user to display days or the week continuously
        while (true) {
            System.out.println("\nWould you like to display the temperature for a specific day, 'week' to display all days and the average, or type 'quit' to exit?");
            System.out.print("Enter a day of the week (Monday to Sunday), 'week', or 'quit': ");
            String displayInput = input.nextLine().trim();

            if (displayInput.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                break;  // Exit the loop if the user types "quit"
            } else if (displayInput.equalsIgnoreCase("week")) {
                // Display all days and the weekly average
                System.out.println("\nTemperature for each day:");
                for (int i = 0; i < days.size(); i++) {
                    System.out.println(days.get(i) + ": " + temperatures.get(i) + "°C");
                }

                // Calculate and display the weekly average
                double weeklyAverage = totalTemp / 7;
                System.out.println("\nThe weekly average temperature is: " + weeklyAverage + "°C");
            } else {
                // Check if the user entered a valid day
                boolean found = false;
                for (int i = 0; i < weekDays.length; i++) {
                    if (displayInput.equalsIgnoreCase(weekDays[i])) {
                        System.out.println(weekDays[i] + ": " + temperatures.get(i) + "°C");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Invalid day entered, please try again.");
                }
            }
        }

        // Close the Scanner to free resources
        input.close();
    }
}
