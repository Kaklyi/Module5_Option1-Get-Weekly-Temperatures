import java.util.ArrayList;
import java.util.Scanner;

public class weekTemp {

    public static void main(String[] args) {

        // Create scanner for user input
        Scanner input = new Scanner(System.in);

        // ArrayList to store days of the week
        ArrayList<String> days = new ArrayList<>();

        // ArrayList to store temperatures for each day
        ArrayList<Double> temps = new ArrayList<>();

        // Add days of the week
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        // Ask user to enter temperature for each day
        for (String day : days) {

            System.out.print("Please enter the average temperature for " + day + ": ");

            // Validate that the input is a number
            while (!input.hasNextDouble()) {
                System.out.println("Please enter a number.");
                input.next(); // discard invalid input
                System.out.print("Please enter the average temperature for " + day + ": ");
            }

            // Store temperature
            double temp = input.nextDouble();
            temps.add(temp);
        }

        // Clear leftover newline from scanner
        input.nextLine();

        // Loop to ask user what information they want
        while (true) {

            System.out.print(
                    "\nEnter a day, 'week' for all temperatures, or 'done' to exit: ");

            String choice = input.nextLine().trim();

            // Exit program
            if (choice.equalsIgnoreCase("done")) {
                System.out.println("All done.");
                break;
            }

            // Display all temperatures and weekly average
            if (choice.equalsIgnoreCase("week")) {

                double total = 0;

                System.out.println("\nTemperatures for the week:");

                for (int i = 0; i < days.size(); i++) {

                    System.out.println(days.get(i) + ": "
                            + String.format("%.1f", temps.get(i)));

                    total += temps.get(i);
                }

                double average = total / temps.size();

                System.out.println("\nWeekly average temperature: "
                        + String.format("%.1f", average));

                continue;
            }

            // Format user input to match day format
            String formatted = capitalize(choice);

            // Check if day exists
            if (days.contains(formatted)) {

                int index = days.indexOf(formatted);

                System.out.println(formatted + ": "
                        + String.format("%.1f", temps.get(index)));

            } else {

                System.out.println("Not a valid day. Try again.");
            }
        }

        // Close scanner
        input.close();
    }

    // Helper method to capitalize first letter of user input
    public static String capitalize(String str) {

        if (str.isEmpty())
            return str;

        return str.substring(0, 1).toUpperCase()
                + str.substring(1).toLowerCase();
    }
}