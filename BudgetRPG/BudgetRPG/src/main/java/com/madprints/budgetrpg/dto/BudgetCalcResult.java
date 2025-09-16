package com.madprints.budgetrpg.dto;

public class BudgetCalcResult {
    private int sumExpenses;
    private int remaining;
    private int goal;
    private int progressPercent;
    private String status;
    private int headroomToGoal;
    private int headroomToBlow;
    private int expensesPercentOfIncome;

    public BudgetCalcResult(int sumExpenses, int remaining, int goal, int progressPercent,
                            String status, int headroomToGoal, int headroomToBlow,
                            int expensesPercentOfIncome) {
        this.sumExpenses = sumExpenses;
        this.remaining = remaining;
        this.goal = goal;
        this.progressPercent = progressPercent;
        this.status = status;
        this.headroomToGoal = headroomToGoal;
        this.headroomToBlow = headroomToBlow;
        this.expensesPercentOfIncome = expensesPercentOfIncome;
    }

    public int getSumExpenses() { return sumExpenses; }
    public int getRemaining() { return remaining; }
    public int getGoal() { return goal; }
    public int getProgressPercent() { return progressPercent; }
    public String getStatus() { return status; }
    public int getHeadroomToGoal() { return headroomToGoal; }
    public int getHeadroomToBlow() { return headroomToBlow; }
    public int getExpensesPercentOfIncome() { return expensesPercentOfIncome; }
}
