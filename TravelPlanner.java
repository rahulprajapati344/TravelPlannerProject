import java.util.*;

class TravelItineraryPlanner {

    static class Destination {
        String name;
        String date;
        double budget;

        public Destination(String name, String date, double budget) {
            this.name = name;
            this.date = date;
            this.budget = budget;
        }

        @Override
        public String toString() {
            return "Destination: " + name + ", Date: " + date + ", Budget: $" + budget;
        }
    }

    static class TravelPlan {
        private List<Destination> destinations = new ArrayList<>();
        private double totalBudget = 0;

        public void addDestination(String name, String date, double budget) {
            Destination destination = new Destination(name, date, budget);
            destinations.add(destination);
            totalBudget += budget;
        }

        public void displayItinerary() {
            System.out.println("\n--- Travel Itinerary ---");
            if (destinations.isEmpty()) {
                System.out.println("No destinations added yet.");
            } else {
                for (Destination destination : destinations) {
                    System.out.println(destination);
                }
                System.out.println("Total Budget: $" + totalBudget);
            }
        }

        public void clearItinerary() {
            destinations.clear();
            totalBudget = 0;
            System.out.println("Itinerary cleared!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TravelPlan plan = new TravelPlan();

        while (true) {
            System.out.println("\n--- Travel Itinerary Planner ---");
            System.out.println("1. Add a Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Clear Itinerary");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Destination Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Travel Date (e.g., YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter Budget for Destination: $");
                    double budget = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    plan.addDestination(name, date, budget);
                    System.out.println("Destination added successfully!");
                    break;

                case 2:
                    plan.displayItinerary();
                    break;

                case 3:
                    plan.clearItinerary();
                    break;

                case 4:
                    System.out.println("Exiting Travel Itinerary Planner. Have a great trip!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
