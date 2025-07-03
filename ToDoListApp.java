import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

    static ArrayList<String> todoList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n----- TO-DO LIST MENU -----");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Exiting To-Do List App. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose 1-5.");
            }
        } while (choice != 5);
    }

    // Add Task
    public static void addTask() {
        System.out.print("Enter task: ");
        String task = scanner.nextLine();
        todoList.add(task);
        System.out.println("Task added successfully.");
    }

    // View Tasks
    public static void viewTasks() {
        if (todoList.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("\nYour To-Do List:");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
        }
    }

    // Update Task
    public static void updateTask() {
        viewTasks();
        System.out.print("Enter task number to update: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // consume newline
        if (index >= 0 && index < todoList.size()) {
            System.out.print("Enter new task: ");
            String newTask = scanner.nextLine();
            todoList.set(index, newTask);
            System.out.println("Task updated.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Delete Task
    public static void deleteTask() {
        viewTasks();
        System.out.print("Enter task number to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // consume newline
        if (index >= 0 && index < todoList.size()) {
            todoList.remove(index);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
