package com.skryv.vendingmachine;

public enum Coin {

    TWENTY_CENT(1, 0.20),
    FIFTY_CENT(2, 0.50);

    final int weight;
    final double amount;

    Coin(final int weight, final double amount) {
        this.weight = weight;
        this.amount = amount;
    }

    public static Coin from(final int weight) {
        if (weight == 2) {
            return FIFTY_CENT;
        }

        return TWENTY_CENT;
    }

}
