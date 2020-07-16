package com.skryv.vendingmachine;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.skryv.vendingmachine.Coin.FIFTY_CENT;
import static com.skryv.vendingmachine.Coin.TEN_CENT;
import static com.skryv.vendingmachine.Coin.TWENTY_CENT;
import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachineTest {

    private static final int UNKNOWN_COIN_WEIGHT = 999;

    private static Stream<Arguments> acceptCoinsInput() {
        return Stream.of(
                Arguments.of(List.of(), "INSERT COIN"),
                Arguments.of(List.of(FIFTY_CENT.weight), "0,50 €"),
                Arguments.of(List.of(FIFTY_CENT.weight, FIFTY_CENT.weight), "1,00 €"),
                Arguments.of(List.of(TWENTY_CENT.weight), "0,20 €"),
                Arguments.of(List.of(TWENTY_CENT.weight, TWENTY_CENT.weight), "0,40 €"),
                Arguments.of(List.of(UNKNOWN_COIN_WEIGHT), "INSERT COIN"),
                Arguments.of(List.of(UNKNOWN_COIN_WEIGHT, TWENTY_CENT.weight, UNKNOWN_COIN_WEIGHT), "0,20 €"),
                Arguments.of(List.of(TEN_CENT.weight), "0,10 €"),
                Arguments.of(List.of(TEN_CENT.weight, TEN_CENT.weight), "0,20 €"),
                Arguments.of(List.of(TEN_CENT.weight, TWENTY_CENT.weight, UNKNOWN_COIN_WEIGHT, FIFTY_CENT.weight), "0,80 €")
        );
    }

    @ParameterizedTest
    @MethodSource("acceptCoinsInput")
    public void acceptCoins(List<Integer> coinsToInsert, String expectedDisplay) {
        VendingMachine vendingMachine = new VendingMachine();
        coinsToInsert.forEach(vendingMachine::acceptCoin);
        assertThat(vendingMachine.getDisplay()).isEqualTo(expectedDisplay);
    }
}
