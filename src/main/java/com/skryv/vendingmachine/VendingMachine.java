package com.skryv.vendingmachine;

class VendingMachine {

    private Display display = new Display();

    private double currentAmount = 0;

    public String getDisplay() {
        return display.getMessage();
    }

    public void acceptCoin(final int weight) {
        Coin coin = Coin.from(weight);
        currentAmount += coin.amount;
        display.update(currentAmount);
    }
}
