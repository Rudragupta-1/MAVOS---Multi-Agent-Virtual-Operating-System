package algorithms;

import java.util.*;
import models.Process;

public class Priority_Scheduler {
    private List<Process> processes;

    public Priority_Scheduler() {
        processes = new ArrayList<>();
    }

    // Method to add a process with priority
    public void addProcess(int pid, int arrivalTime, int burstTime, int priority) {
        Process process = new Process(pid, arrivalTime, burstTime, priority);
        processes.add(process);
    }

    // Priority Scheduling Algorithm
    public void schedulePriority() {
        // Sort processes by Priority (Lower value = Higher priority)
        Collections.sort(processes, Comparator.comparingInt(Process::getPriority));

        int currentTime = 0;
        int totalWaitTime = 0;
        int totalTurnaroundTime = 0;

        // Calculate Completion Time, Waiting Time, and Turnaround Time
        for (Process process : processes) {
            if (currentTime < process.getArrivalTime()) {
                currentTime = process.getArrivalTime();
            }

            process.setCompletionTime(currentTime + process.getBurstTime());
            process.setTurnaroundTime(process.getCompletionTime() - process.getArrivalTime());
            process.setWaitingTime(process.getTurnaroundTime() - process.getBurstTime());

            totalWaitTime += process.getWaitingTime();
            totalTurnaroundTime += process.getTurnaroundTime();

            currentTime += process.getBurstTime();
        }

        // Print Gantt Chart
        System.out.println("\nGantt Chart (Priority Scheduling): ");
        printGanttChart();

        // Print results
        printResults(totalWaitTime, totalTurnaroundTime);
    }

    // Print Gantt Chart for Priority Scheduling
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
