package com.skryv.vendingmachine;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachineTest {

    @Test
    public void noCoinInserted() {
        VendingMachine vendingMachine = new VendingMachine();
        String message = vendingMachine.getDisplay();
        assertThat(message).isEqualTo("INSERT COIN");
    }

    @Test
    public void insert50Cents() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.acceptCoin(2);
        String message = vendingMachine.getDisplay();
        assertThat(message).isEqualTo("0,50 €");
    }

    @Test
    public void insert50Cents2Times() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.acceptCoin(2);
        vendingMachine.acceptCoin(2);
        String message = vendingMachine.getDisplay();
        assertThat(message).isEqualTo("1,00 €");
    }

    @Test
    public void insert20Cents() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.acceptCoin(1);
        String message = vendingMachine.getDisplay();
        assertThat(message).isEqualTo("0,20 €");
    }

}
