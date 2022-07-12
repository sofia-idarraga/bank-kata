package com.sofka.bank;

import com.sofka.properties.Action;
import com.sofka.properties.Date;
import com.sofka.properties.Movement;
import java.util.ArrayList;
import static com.sofka.bank.Statement.actionOfStatement;


/**
 * Account object with all its methods
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


public class Account {

    /**
     * Attribute of account
     */
    private ArrayList<Statement> statements = new ArrayList<>();

    public Account(Statement statement){
        statements.add(statement);
    }

    /**
     * Set the statement as a deposit
     * @param amount Amount of money deposited by the client
     * @param date Date of the deposit
     */
    public void deposit(Integer amount, Date date) {
        Movement movement = new Movement(Action.DEPOSIT, date);
        Statement statement = new Statement(movement,amount);
        statements.add(statement);
        System.out.println(statement);
    }

    /**
     * Set the statement as a withdrawal
     * @param amount Amount of money withdrawaled by the client
     * @param date Date of the withdrawal
     */
    public void withdrawal(Integer amount, Date date){
        Movement movement = new Movement(Action.WITHDRAWAL, date);
        Statement statement = new Statement(movement,amount);
        statements.add(statement);
        System.out.println(statement);
    }

    /**
     * Set the statement as a transfer
     * @param amount Amount of money transfered by the client
     * @param date Date of the transfer
     */
    public void transfer(Integer amount, Date date){
        Movement movement = new Movement(Action.TRANSFERENCE, date);
        Statement statement = new Statement(movement,amount);
        statements.add(statement);
        System.out.println(statement);

    }

    /**
     * Prints all the statements
     */
    public void printStatements() {
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%10s %10s %10s %10s %10s", "Date", "Credit", "Debit ", "Transfer", "Balance");
        System.out.println();
        System.out.println("-------------------------------------------------------------");

        int balance = 0;
        for (Statement statement:statements) {
            Action action = actionOfStatement(statement);
            balance = calculateNewBalance(action, statement, balance);
            evaluateStatement(action, statement, balance);
        }

    }
    /**
     * Prints the credit statements
     */
    public void printCreditStatements(Movement movement, Statement statement, int balance){
        System.out.format("%10s %10s %10s %10s %10s",movement.date, statement.amount, "", "", balance);
        System.out.println();
    }

    /**
     * Prints the debit statements
     */
    public void printDebitStatements(Movement movement, Statement statement, int balance){
        System.out.format("%10s %10s %10s %10s %10s", movement.date,"",statement.amount,"",balance);
        System.out.println();
    }

    /**
     * Prints the transfer statements
     */
    public void printTransferStatements(Movement movement, Statement statement, int balance){
        System.out.format("%10s %10s %10s %10s %10s", movement.date,"","",statement.amount, balance);
        System.out.println();
    }

    /**
     * Calculates the balance according to the action
     */
    private int calculateNewBalance(Action action, Statement statement, int balance){
        if (action == Action.CREATE){
            return 0;
        }
        if(action == Action.DEPOSIT){
            return balance+statement.amount;
        }
        if(action == Action.WITHDRAWAL ){
            return balance-statement.amount;
        }
        if (action == Action.TRANSFERENCE){
            return balance-statement.amount;

        }
        return 0;
    }

    /**
     * Organize the print statement according to its action
     */
    public void evaluateStatement(Action action, Statement statement, int balance){
        if(action == Action.DEPOSIT){
            printCreditStatements(statement.movement, statement, balance);
        }
        if(action == Action.WITHDRAWAL){
            printDebitStatements(statement.movement, statement, balance);
        }
        if (action == Action.TRANSFERENCE){
            printTransferStatements(statement.movement, statement, balance);
        }
    }

    /**
     *
     * Filter the statements according to a given action
     */
    public void filterByAction(Statement statement, Action filter, int balance){
        Action action = actionOfStatement(statement);
        if (action == filter){
            evaluateStatement(action, statement, balance);
        }
    }

    /**
     * Prints the statements of a given action
     */
    public void printsByAction(Action filter){
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%10s %10s %10s %10s %10s", "Date", "Credit", "Debit ", "Transfer", "Balance");
        System.out.println();
        System.out.println("-------------------------------------------------------------");
        int balance = 0;
        for (Statement statement:statements) {
            Action action = actionOfStatement(statement);
            balance = calculateNewBalance(action, statement, balance);
            filterByAction(statement, filter, balance);
        }
    }



}
