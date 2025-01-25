import java.util.Scanner;
// import models.Process;
import algorithms.FCFS_Scheduler;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FCFS_Scheduler scheduler = new FCFS_Scheduler();

        // User input for number of processes
        System.out.print("Enter number of processes: ");
        int numProcesses = scanner.nextInt();

        // Input process details
        for (int i = 1; i <= numProcesses; i++) {
            System.out.println("Enter details for Process " + i + ":");
            System.out.print("Arrival Time: ");
            int arrivalTime = scanner.nextInt();
            System.out.print("Burst Time: ");
            int burstTime = scanner.nextInt();
            scheduler.addProcess(i, arrivalTime, burstTime);
        }

        // Schedule processes using FCFS
        scheduler.scheduleFCFS();

        scanner.close();
    }
}
