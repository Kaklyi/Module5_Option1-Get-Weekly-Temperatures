import java.util.ArrayList;
import java.util.Scanner;

public class weekTemp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temps = new ArrayList<>();

        // days of the week
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        // Ask for the temperatures from user input
        for (String day : days) {
            System.out.print("Please enter the average temperature for " + day + ": ");

            while (!input.hasNextDouble()) {
                System.out.println("Please enter a number.");
                input.next();
                System.out.print("Please enter the average temperature for " + day + ": ");
            }

            double temp = input.nextDouble();
            temps.add(temp);
        }

        input.nextLine();

        // loop to ask what they would like to be printed
        // options are specific day, whole week, or done to complete the loop
        while (true) {
            System.out.print(
                    "\nPlease enter the day you would like, or if you want the whole week please enter 'week', once done please enter 'done': ");
            String choice = input.nextLine().trim();

            // done will lead to the program to finish
            if (choice.equalsIgnoreCase("done")) {
                System.out.println("All done.");
                break;
            }

            // week will show all days with their temperature along the average for the
            // whole week
            if (choice.equalsIgnoreCase("week")) {
                double total = 0;

                System.out.println("\nTemperatures for the week:");
                for (int i = 0; i < days.size(); i++) {
                    System.out.println(days.get(i) + ": " + String.format("%.1f", temps.get(i)));
                    total += temps.get(i);
                }

                double average = total / temps.size();
                System.out.println("\nWeekly average temperature: " + String.format("%.1f", average));
                continue;
            }

            // Show the date and the avg temp for it
            String formatted = capitalize(choice);
            if (days.contains(formatted)) {
                int index = days.indexOf(formatted);
                System.out.println(formatted + ": " + String.format("%.1f", temps.get(index)));
            } else {
                System.out.println("Not a valid day. Try again.");
            }
        }

        input.close();
    }

    // Fix user input to avoid uncesary problems
    // makes lower and upper case match
    public static String capitalize(String str) {
        if (str.isEmpty())
            return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

}