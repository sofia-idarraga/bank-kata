package com.sofka.bank;


import com.sofka.properties.Action;
import com.sofka.properties.Date;
import com.sofka.properties.Movement;
import java.util.ArrayList;
import static com.sofka.bank.Statement.actionOfStatement;


public class Account {


    private ArrayList<Statement> statements = new ArrayList<>();

    public Account(Statement statement){
        statements.add(statement);
    }
    public void deposit(Integer amount, Date date) {
        Movement movement = new Movement(Action.DEPOSIT, date);
        Statement statement = new Statement(movement,amount);
        statements.add(statement);
        System.out.println(statement);


    }

    public void withdrawal(Integer amount, Date date){
        Movement movement = new Movement(Action.WITHDRAWAL, date);
        Statement statement = new Statement(movement,amount);
        statements.add(statement);
        System.out.println(statement);


    }

    public void transfer(Integer amount, Date date){
        Movement movement = new Movement(Action.TRANSFERENCE, date);
        Statement statement = new Statement(movement,amount);
        statements.add(statement);
        System.out.println(statement);

    }

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

    public void printCreditStatements(Movement movement, Statement statement, int balance){
        System.out.format("%10s %10s %10s %10s %10s",movement.date, statement.amount, "", "", balance);
        System.out.println();
    }

    public void printDebitStatements(Movement movement, Statement statement, int balance){
        System.out.format("%10s %10s %10s %10s %10s", movement.date,"",statement.amount,"",balance);
        System.out.println();
    }

    public void printTransferStatements(Movement movement, Statement statement, int balance){
        System.out.format("%10s %10s %10s %10s %10s", movement.date,"","",statement.amount, balance);
        System.out.println();
    }

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


}
