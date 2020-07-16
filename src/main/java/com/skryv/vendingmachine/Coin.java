package com.skryv.vendingmachine;

public enum Coin {

    TWENTY_CENT(1, 0.20),
    FIFTY_CENT(2, 0.50),
    UNKNOWN(0, 0);

    final int weight;
    final double amount;

    Coin(final int weight, final double amount) {
        this.weight = weight;
        this.amount = amount;
    }

    public static Coin from(final int weight) {
        if (weight == 1) return TWENTY_CENT;
        if (weight == 2) return FIFTY_CENT;

        return UNKNOWN;
    }

}
