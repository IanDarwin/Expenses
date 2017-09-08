package com.darwinsys.expenses.model;

import java.time.LocalDate;

/**
 * One Expense Item
 */
public class ExpenseItem {
    public int id;
    public String description;
    public LocalDate date;
    public Double amount;
    public Double whereLat, whereLong;
    public String whereLoc;
    public String imagePath;
}
