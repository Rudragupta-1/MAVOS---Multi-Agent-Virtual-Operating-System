package models;

public class Process {
    private int pid; // Process ID
    private int arrivalTime; // Arrival time
    private int burstTime; // CPU Burst time
    private int completionTime; // Completion time
    private int waitingTime; // Waiting time
    private int turnaroundTime; // Turnaround time

    // Constructor
    public Process(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }

    // Getters and Setters
    public int getPid() {
        return pid;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    // Display process info
    public void displayProcessInfo() {
        System.out.println("Process " + pid + ": Arrival Time = " + arrivalTime + ", Burst Time = " + burstTime +
                           ", Completion Time = " + completionTime + ", Waiting Time = " + waitingTime + 
                           ", Turnaround Time = " + turnaroundTime);
    }
}
