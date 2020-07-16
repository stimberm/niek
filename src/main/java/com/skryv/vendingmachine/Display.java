package com.skryv.vendingmachine;

import java.text.DecimalFormat;
import java.util.Locale;

public class Display {

    private String message = "INSERT COIN";

    public String getMessage() {
        return message;

    }

    public void update(final double amount) {
        if (amount > 0) {
            message = DecimalFormat.getCurrencyInstance(Locale.GERMANY).format(amount);
        }
    }
}
