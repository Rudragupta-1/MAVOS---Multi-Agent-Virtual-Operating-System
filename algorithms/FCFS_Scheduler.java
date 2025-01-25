package algorithms;

import java.util.*;
import models.Process;
public class FCFS_Scheduler {
    private List<Process> processes;

    public FCFS_Scheduler() {
        processes = new ArrayList<>();
    }

    // Method to add a process
    public void addProcess(int pid, int arrivalTime, int burstTime) {
        Process process = new Process(pid, arrivalTime, burstTime);
        processes.add(process);
    }

    // FCFS Scheduling Algorithm
    public void scheduleFCFS() {
        // Sort processes based on Arrival Time
        Collections.sort(processes, Comparator.comparingInt(Process::getArrivalTime));

        int currentTime = 0;
        int totalWaitTime = 0;
        int totalTurnaroundTime = 0;

        // Calculate Completion Time, Waiting Time, and Turnaround Time
        for (Process process : processes) {
            // If the process arrives after the current time, move the current time to its arrival time
            if (currentTime < process.getArrivalTime()) {
                currentTime = process.getArrivalTime();
            }

            // Completion time = current time + burst time
            process.setCompletionTime(currentTime + process.getBurstTime());

            // Turnaround time = Completion time - Arrival time
            process.setTurnaroundTime(process.getCompletionTime() - process.getArrivalTime());

            // Waiting time = Turnaround time - Burst time
            process.setWaitingTime(process.getTurnaroundTime() - process.getBurstTime());

            // Update total waiting time and total turnaround time
            totalWaitTime += process.getWaitingTime();
            totalTurnaroundTime += process.getTurnaroundTime();

            // Move current time forward by the burst time of the process
            currentTime += process.getBurstTime();
        }

        // Print Gantt Chart
        System.out.println("\nGantt Chart (FCFS): ");
        printGanttChart();

        // Print results
        printResults(totalWaitTime, totalTurnaroundTime);
    }

    // Print Gantt Chart for FCFS
    private void printGanttChart() {
        System.out.print("Timeline: ");
        for (Process process : processes) {
            System.out.print("| P" + process.getPid() + " ");
        }
        System.out.println("|");
        System.out.print("Time: ");
        int currentTime = 0;
        for (Process process : processes) {
            System.out.print(currentTime + "     ");
            currentTime += process.getBurstTime();
        }
        System.out.println(currentTime);
    }

    // Print average waiting time and turnaround time
    private void printResults(int totalWaitTime, int totalTurnaroundTime) {
        double avgWaitTime = (double) totalWaitTime / processes.size();
        double avgTurnaroundTime = (double) totalTurnaroundTime / processes.size();

        System.out.println("\nAverage Waiting Time = " + avgWaitTime);
        System.out.println("Average Turnaround Time = " + avgTurnaroundTime);
        System.out.println("\nDetailed Process Information:");
        for (Process process : processes) {
            process.displayProcessInfo();
        }
    }
}
