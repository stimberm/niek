package com.skryv.vendingmachine;

class VendingMachine {

    private static final String INSERT_COIN = "INSERT COIN";

    private int amount;

    public String getDisplay() {
        return amount > 0 ? "€ 0,50" : INSERT_COIN;
    }

    public void acceptCoin() {
        amount = 50;
    }
}
