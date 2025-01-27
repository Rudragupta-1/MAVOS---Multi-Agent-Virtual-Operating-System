package algorithms;

import java.util.*;
import models.Process;

public class SJF_Scheduler {
    private List<Process> processes;

    public SJF_Scheduler() {
        processes = new ArrayList<>();
    }

    // Method to add a process
    public void addProcess(int pid, int arrivalTime, int burstTime) {
        Process process = new Process(pid, arrivalTime, burstTime);
        processes.add(process);
    }

    // SJF Scheduling Algorithm (Non-preemptive)
    public void scheduleSJF() {
        // Sort processes based on Arrival Time, then by Burst Time
        Collections.sort(processes, Comparator.comparingInt(Process::getArrivalTime)
                                              .thenComparingInt(Process::getBurstTime));

        int currentTime = 0;
        int totalWaitTime = 0;
        int totalTurnaroundTime = 0;
        List<Process> readyQueue = new ArrayList<>();
        List<Process> completed = new ArrayList<>();
        
        while (!processes.isEmpty() || !readyQueue.isEmpty()) {
            // Move processes to ready queue if they have arrived
            Iterator<Process> it = processes.iterator();
            while (it.hasNext()) {
                Process p = it.next();
                if (p.getArrivalTime() <= currentTime) {
                    readyQueue.add(p);
                    it.remove();
                } else {
                    break;
                }
            }

            if (!readyQueue.isEmpty()) {
                // Sort ready queue based on Burst Time
                readyQueue.sort(Comparator.comparingInt(Process::getBurstTime));
                Process process = readyQueue.remove(0);

                // Completion time = current time + burst time
                process.setCompletionTime(currentTime + process.getBurstTime());
                process.setTurnaroundTime(process.getCompletionTime() - process.getArrivalTime());
                process.setWaitingTime(process.getTurnaroundTime() - process.getBurstTime());
                
                totalWaitTime += process.getWaitingTime();
                totalTurnaroundTime += process.getTurnaroundTime();
                completed.add(process);

                // Move current time forward
                currentTime = process.getCompletionTime();
            } else {
                currentTime++;
            }
        }

        processes = completed;
        printResults(totalWaitTime, totalTurnaroundTime);
    }

    // Print results
    private void printResults(int totalWaitTime, int totalTurnaroundTime) {
        double avgWaitTime = (double) totalWaitTime / processes.size();
        double avgTurnaroundTime = (double) totalTurnaroundTime / processes.size();

        System.out.println("\nAverage Waiting Time (SJF) = " + avgWaitTime);
        System.out.println("Average Turnaround Time (SJF) = " + avgTurnaroundTime);
        
        System.out.println("\nDetailed Process Information:");
        for (Process process : processes) {
            process.displayProcessInfo();
        }
    }
}
