package com.skryv.vendingmachine;

import java.text.DecimalFormat;
import java.util.Locale;

class VendingMachine {

    private static final String INSERT_COIN = "INSERT COIN";

    private double amount;

    public String getDisplay() {
        String amountString = DecimalFormat.getCurrencyInstance(Locale.GERMANY).format(amount);
        if(amount > 0) {
            return amountString;
        }
        return INSERT_COIN;
    }

    public void acceptCoin() {
        amount += 0.50;
    }
}
