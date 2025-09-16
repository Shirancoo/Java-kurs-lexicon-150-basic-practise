package com.madprints.budgetrpg.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class ExpenseItem {
    @NotBlank(message = "Namn på utgift saknas")
    @Size(max = 100, message = "Namnet får vara max 100 tecken")
    private String name;

    @PositiveOrZero(message = "Belopp måste vara >= 0")
    private int amount;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }
}
