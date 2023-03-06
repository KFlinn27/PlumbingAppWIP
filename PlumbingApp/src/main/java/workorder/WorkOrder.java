package workorder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class WorkOrder {
    private List<Assignable> tasks;
    private int personId;
    private String issue;
    private LocalDate scheduledFor;
    private String repair;

    public WorkOrder(int personId, String issue, LocalDate scheduled){
        this.personId = personId;
        this.issue = issue;
        this.scheduledFor = scheduled;
    }

    public BigDecimal getCost(){
        BigDecimal totalCost = BigDecimal.valueOf(0);
        for(Assignable current: tasks){
            totalCost = totalCost.add(current.getCost());
        }
        return totalCost;
    }

    public void addTask(Task taskToAdd){
        tasks.add(taskToAdd);
    }

    public List<Assignable> getTasks() {
        return tasks;
    }

    public void setTasks(List<Assignable> tasks) {
        this.tasks = tasks;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public LocalDate getScheduledFor() {
        return scheduledFor;
    }

    public void setScheduledFor(LocalDate scheduledFor) {
        this.scheduledFor = scheduledFor;
    }

    public String getRepair() {
        return repair;
    }

    public void setRepair(String repair) {
        this.repair = repair;
    }
}
