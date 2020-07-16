package com.skryv.vendingmachine;

import org.junit.Test;

import static com.skryv.vendingmachine.Coin.FIFTY_CENT;
import static com.skryv.vendingmachine.Coin.TWENTY_CENT;
import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachineTest {

    private static final int UNKNOWN_COIN_WEIGHT = 999;

    @Test
    public void noCoinInserted() {
        VendingMachine vendingMachine = new VendingMachine();
        String message = vendingMachine.getDisplay();
        assertThat(message).isEqualTo("INSERT COIN");
    }

    @Test
    public void insert50Cents() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.acceptCoin(FIFTY_CENT.weight);
        String message = vendingMachine.getDisplay();
        assertThat(message).isEqualTo("0,50 €");
    }

    @Test
    public void insert50Cents2Times() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.acceptCoin(FIFTY_CENT.weight);
        vendingMachine.acceptCoin(FIFTY_CENT.weight);
        String message = vendingMachine.getDisplay();
        assertThat(message).isEqualTo("1,00 €");
    }

    @Test
    public void insert20Cents() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.acceptCoin(TWENTY_CENT.weight);
        String message = vendingMachine.getDisplay();
        assertThat(message).isEqualTo("0,20 €");
    }

    @Test
    public void insert20Cents2Times() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.acceptCoin(TWENTY_CENT.weight);
        vendingMachine.acceptCoin(TWENTY_CENT.weight);
        String message = vendingMachine.getDisplay();
        assertThat(message).isEqualTo("0,40 €");
    }

    @Test
    public void insertUnknown() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.acceptCoin(UNKNOWN_COIN_WEIGHT);
        String message = vendingMachine.getDisplay();
        assertThat(message).isEqualTo("INSERT COIN");
    }

    @Test
    public void insertUnknownThen20CentsThenUnknown() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.acceptCoin(UNKNOWN_COIN_WEIGHT);
        vendingMachine.acceptCoin(TWENTY_CENT.weight);
        vendingMachine.acceptCoin(UNKNOWN_COIN_WEIGHT);
        String message = vendingMachine.getDisplay();
        assertThat(message).isEqualTo("0,20 €");
    }
}
