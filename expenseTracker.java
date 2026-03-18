import java.util.Scanner;
public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] dates = new String[100];
        String[] descriptions = new String[100];
        double[] amounts = new double[100];
        int count = 0;
        int choice;

        do {
            System.out.println("\n===== Expense Tracker Menu =====");
            System.out.println("1. Add Expense");
            System.out.println("2. Show All Expenses");
            System.out.println("3. Show Summary");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (count < 100) {
                        System.out.print("Enter date (YYYY-MM-DD): ");
                        dates[count] = sc.nextLine();
                        System.out.print("Enter description: ");
                        descriptions[count] = sc.nextLine();
                        System.out.print("Enter amount: ");
                        amounts[count] = sc.nextDouble();
                        count++;
                        System.out.println("Expense added successfully!");
                    } else {
                        System.out.println("Expense list is full!");
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No expenses added yet.");
                    } else {
                        System.out.println("\n--- Expense Details ---");
                        System.out.printf("%-12s %-20s %-10s%n", "Date", "Description", "Amount");
                        System.out.println("------------------------------------------------");
                        for (int i = 0; i < count; i++) {
                            System.out.printf("%-12s %-20s %-10.2f%n", dates[i], descriptions[i], amounts[i]);
                        }
                    }
                    break;

                case 3:
                    if (count == 0) {
                        System.out.println("No expenses to summarize.");
                    } else {
                        double total = 0, maxExpense = amounts[0];
                        for (int i = 0; i < count; i++) {
                            total += amounts[i];
                            if (amounts[i] > maxExpense)
                                maxExpense = amounts[i];
                        }
                        double average = total / count;
                        System.out.println("\n--- Summary ---");
                        System.out.printf("Total Expenses: %.2f%n", total);
                        System.out.printf("Average Expense: %.2f%n", average);
                        System.out.printf("Highest Expense: %.2f%n", maxExpense);
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Thank you for using Expense Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}




