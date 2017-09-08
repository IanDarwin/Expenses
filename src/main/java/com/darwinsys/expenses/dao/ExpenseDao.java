package com.darwinsys.expenses.dao;

import com.darwinsys.expenses.model.ExpenseItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ExpenseDao {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<ExpenseItem> ITEMS = new ArrayList<ExpenseItem>();

    /**
     * A map of sample items, by ID.
     */
    public static final Map<String, ExpenseItem> ITEM_MAP = new HashMap<String, ExpenseItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createExpenseItem(i));
        }
    }

    private static ExpenseItem createExpenseItem(int i) {
        ExpenseItem it = new ExpenseItem();
        it.id = i;
        it.description = "Item#" + i;
        it.date = LocalDate.of(2017, 01, i);
        it.amount = 12.34*i;
        return it;
    }

    private static void addItem(ExpenseItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(String.valueOf(item.id), item);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }


}
