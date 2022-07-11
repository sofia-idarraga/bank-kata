package com.sofka.bank;


import com.sofka.properties.Action;

import com.sofka.properties.Date;
import com.sofka.properties.Movement;


import java.util.ArrayList;

import static com.sofka.properties.Movement.findAction;
import static com.sofka.bank.Statement.actionOfStatement;


public class Account {


    private ArrayList<Statement> statements = new ArrayList<>();
    private int balance;

    public Account(Statement statement){
        statements.add(statement);
    }
    public void deposit(Integer amount, Date date) {
        Movement movement = new Movement(Action.DEPOSIT, date);
        Statement statement = new Statement(movement,amount);
        statements.add(statement);
        balance += amount;
        System.out.println(statement);
        System.out.println(balance);

    }

    public void withdrawal(Integer amount, Date date){
        Movement movement = new Movement(Action.WITHDRAWAL, date);
        Statement statement = new Statement(movement,amount);
        statements.add(statement);
        balance -= amount;
        System.out.println(statement);
        System.out.println(balance);

    }

    public void transfer(Integer amount, Date date){
        Movement movement = new Movement(Action.TRANSFERENCE, date);
        Statement statement = new Statement(movement,amount);
        statements.add(statement);
        balance -= amount;
        System.out.println(statement);
        System.out.println(balance);
    }

    public void printStatements() {
        System.out.println("------------------------");
        System.out.println("Date \t|"+"Credit \t|"+"Debit \t|"+ "Transfer \t|"+ "Balance \t|");

        for (Statement statement:statements) {
                Action action = actionOfStatement(statement);
        }

    }

    public void print creditStatements(Movement movement){
        System.out.println(movement.date+" \t"+"Debit | \t"+ "Transfer | \t"+ "Balance | \t");
    }


}
