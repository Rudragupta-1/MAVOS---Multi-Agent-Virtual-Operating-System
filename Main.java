import java.util.Scanner;
import algorithms.FCFS_Scheduler;
import algorithms.SJF_Scheduler;
import algorithms.Priority_Scheduler;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose Scheduling Algorithm:");
        System.out.println("1. First-Come, First-Served (FCFS)");
        System.out.println("2. Shortest Job First (SJF)");
        System.out.println("3. Priority Scheduling");
        System.out.print("Enter choice (1/2/3): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            FCFS_Scheduler scheduler = new FCFS_Scheduler();
            executeScheduler(scanner, scheduler);
            scheduler.scheduleFCFS();
        } else if (choice == 2) {
            SJF_Scheduler scheduler = new SJF_Scheduler();
            executeScheduler(scanner, scheduler);
            scheduler.scheduleSJF();
        } else if (choice == 3) {
            Priority_Scheduler scheduler = new Priority_Scheduler();
            executeScheduler(scanner, scheduler);
            scheduler.schedulePriority();
        } else {
            System.out.println("Invalid choice! Exiting.");
        }

        scanner.close();
    }

    private static void executeScheduler(Scanner scanner, Object scheduler) {
        System.out.print("Enter number of processes: ");
        int numProcesses = scanner.nextInt();

        for (int i = 1; i <= numProcesses; i++) {
            System.out.println("Enter details for Process " + i + ":");
            System.out.print("Arrival Time: ");
            int arrivalTime = scanner.nextInt();
            System.out.print("Burst Time: ");
            int burstTime = scanner.nextInt();

            if (scheduler instanceof FCFS_Scheduler) {
                ((FCFS_Scheduler) scheduler).addProcess(i, arrivalTime, burstTime);
            } else if (scheduler instanceof SJF_Scheduler) {
                ((SJF_Scheduler) scheduler).addProcess(i, arrivalTime, burstTime);
            } else if (scheduler instanceof Priority_Scheduler) {
                System.out.print("Priority: ");
                int priority = scanner.nextInt();
                ((Priority_Scheduler) scheduler).addProcess(i, arrivalTime, burstTime, priority);
            }
        }
    }
}
