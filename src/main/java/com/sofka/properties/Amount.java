package com.sofka.properties;

public class Amount {

    private final Integer STATEMENT_AMOUNT;

    public Amount(int accountAmount){
        this.STATEMENT_AMOUNT = accountAmount;
    }

    public static Amount amountOf(int amount){
        return new Amount(amount);
    }

    public Integer depositAmount(Integer balance){
        return balance - STATEMENT_AMOUNT;
    }


}
