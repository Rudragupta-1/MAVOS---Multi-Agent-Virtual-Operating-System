package models;

public class Process {
    private int pid;
    private int arrivalTime;
    private int burstTime;
    private int completionTime;
    private int waitingTime;
    private int turnaroundTime;
    private int priority; // Added priority attribute

    // Constructor for Priority Scheduling
    public Process(int pid, int arrivalTime, int burstTime, int priority) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }
    // For SJF and FCFS
    public Process(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = Integer.MAX_VALUE; // Default priority for SJF/FCFS
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    // Display process info
    public void displayProcessInfo() {
        System.out.println("Process " + pid + ": Arrival Time = " + arrivalTime + ", Burst Time = " + burstTime +
                           ", Priority = " + priority + ", Completion Time = " + completionTime +
                           ", Waiting Time = " + waitingTime + ", Turnaround Time = " + turnaroundTime);
    }
}
