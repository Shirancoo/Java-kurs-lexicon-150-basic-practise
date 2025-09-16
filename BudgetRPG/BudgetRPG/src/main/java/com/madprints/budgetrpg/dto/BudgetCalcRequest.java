package com.madprints.budgetrpg.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.ArrayList;
import java.util.List;

public class BudgetCalcRequest {
    @PositiveOrZero(message = "Inkomst får ej vara negativ")
    private int income;

    @PositiveOrZero(message = "Mål får ej vara negativt")
    private int goal;

    @NotNull(message = "Expenses får inte saknas (kan vara tom lista)")
    private List<@Valid ExpenseItem> expenses = new ArrayList<>();

    public int getIncome() { return income; }
    public void setIncome(int income) { this.income = income; }

    public int getGoal() { return goal; }
    public void setGoal(int goal) { this.goal = goal; }

    public List<ExpenseItem> getExpenses() { return expenses; }
    public void setExpenses(List<ExpenseItem> expenses) { this.expenses = expenses; }
}
