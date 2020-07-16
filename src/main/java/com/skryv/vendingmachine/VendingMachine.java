package com.skryv.vendingmachine;

class VendingMachine {

    private static final String INSERT_COIN = "INSERT COIN";

    private int amount;

    public String getDisplay() {
        if(amount == 50) {
            return "€ 0,50";
        }

        if(amount > 50) {
            return "€ 1,00";
        }

        return INSERT_COIN;
    }

    public void acceptCoin() {
        amount += 50;
    }
}
