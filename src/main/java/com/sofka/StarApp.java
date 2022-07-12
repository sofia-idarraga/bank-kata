package com.sofka;

import com.sofka.bank.Account;
import com.sofka.bank.Statement;

import static com.sofka.properties.Date.date;

public class StarApp {
    public static void main(String[] args) {
        Account account = new Account(new Statement());

        account.deposit(1000, date("10/01/2021"));
        account.deposit(2000, date("13/01/2021"));
        account.withdrawal(500, date("14/01/2021"));

        account.printStatements();
        account.transfer(1000, date("15/01/2021"));
        account.printStatements();
    }

}
