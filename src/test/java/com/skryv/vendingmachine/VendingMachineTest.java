package com.skryv.vendingmachine;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachineTest {

    @Test
    public void noCoinsDisplaysInsertCoin() {
        VendingMachine vendingMachine = new VendingMachine();
        String message = vendingMachine.getDisplay();
        assertThat(message).isEqualTo("INSERT COIN");
    }

    @Test
    public void acceptFiftyCentsShowsAmount() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.acceptCoin(2);
        String message = vendingMachine.getDisplay();
        assertThat(message).isEqualTo("0,50 €");
    }

    @Test
    public void acceptFiftyCentsTwice() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.acceptCoin(2);
        vendingMachine.acceptCoin(2);
        String message = vendingMachine.getDisplay();
        assertThat(message).isEqualTo("1,00 €");
    }

    @Test
    public void acceptTwentyCents() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.acceptCoin(1);
        String message = vendingMachine.getDisplay();
        assertThat(message).isEqualTo("0,20 €");
    }

}
