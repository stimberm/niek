package com.skryv.vendingmachine;

public enum Coin {

    TWENTY_CENT(4, 0.20),
    FIFTY_CENT(5, 0.50),
    UNKNOWN(0, 0);

    final int weight;
    final double amount;

    Coin(final int weight, final double amount) {
        this.weight = weight;
        this.amount = amount;
    }

    public static Coin from(final int weight) {
        if (weight == TWENTY_CENT.weight) return TWENTY_CENT;
        if (weight == FIFTY_CENT.weight) return FIFTY_CENT;

        return UNKNOWN;
    }

}
