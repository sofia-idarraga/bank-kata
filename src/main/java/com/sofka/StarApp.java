package com.sofka;

import com.sofka.bank.Account;
import com.sofka.bank.Statement;
import com.sofka.properties.Action;

import static com.sofka.properties.Date.date;

/**
 *  Main method, allows to initialize the application
 *
 *@version 1.00.000 2022-07-12, The file corresponds to version 1 of the system,
 *                               it has suffered 0 refactorings during the
 *                               version, 0 minor changes were made after the
 *                               0 refactoring, the last change was made on
 *                               July 12, 2022.
 *
 * @author Sofía Idárraga <sofia.idarraga@outlool.com>
 *
 * @since 1.00.000
 */

public class StarApp {
    public static void main(String[] args) {
        Account account = new Account(new Statement());

        account.deposit(1000, date("10/01/2021"));
        account.deposit(2000, date("13/01/2021"));
        account.withdrawal(500, date("14/01/2021"));

        //account.printStatements();
        account.transfer(1000, date("14/01/2021"));
        account.printStatements();
        System.out.println("_________________________________________________");
        account.printsByAction(Action.WITHDRAWAL);


    }

}
