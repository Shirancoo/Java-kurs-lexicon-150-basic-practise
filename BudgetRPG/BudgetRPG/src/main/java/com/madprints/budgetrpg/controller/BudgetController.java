package com.madprints.budgetrpg.controller;

import com.madprints.budgetrpg.dto.BudgetCalcRequest;
import com.madprints.budgetrpg.dto.BudgetCalcResult;
import com.madprints.budgetrpg.dto.ExpenseItem;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/budget")
public class BudgetController {

    @PostMapping("/calculate")
    public ResponseEntity<BudgetCalcResult> calculate(@Valid @RequestBody BudgetCalcRequest request) {
        int sum = request.getExpenses().stream().mapToInt(ExpenseItem::getAmount).sum();
        int income = request.getIncome();
        int remaining = income - sum;
        int goal = request.getGoal();
        int percent = 0;
        String status = "UNDER";

        if (goal > 0) {
            percent = (int) Math.floor((double) remaining / goal * 100.0);
            if (remaining < goal) {
                status = "UNDER";
            } else if (remaining == goal) {
                status = "MET";
            } else {
                status = "EXCEEDED";
            }
        } else {
            percent = 100;
            status = "EXCEEDED";
        }
        if (percent < 0) {
            percent = 0;
        }
        if (percent > 100) {
            percent = 100;
        }

        int headroomToGoal = goal - remaining;
        int headroomToBlow = remaining;
        int expensesPercentOfIncome = 0;
        if (income > 0) {
            expensesPercentOfIncome = (int) Math.floor(((double) sum / income) * 100.0);
        }

        BudgetCalcResult result = new BudgetCalcResult(sum, remaining, goal, percent, status,
                                                       headroomToGoal, headroomToBlow, expensesPercentOfIncome);
        return ResponseEntity.ok(result);
    }
}
