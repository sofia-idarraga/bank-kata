package com.sofka.bank;

import com.sofka.properties.Action;

import com.sofka.properties.Movement;

import java.time.LocalDate;

import static com.sofka.properties.Date.date;
import static com.sofka.properties.Movement.findAction;

public class Statement {
    Movement movement;
    Integer amount;


    public Statement(){
        LocalDate dateOfCreation = LocalDate.now();
        this.movement = new Movement(Action.CREATE, date("10/01/2020"));
        this.amount = 0;

    }
    public Statement(Movement movement, Integer amount){
        this.movement = movement;
        this.amount = amount;
    }

    public static Action actionOfStatement(Statement statement){
        return findAction(statement.movement);
    }

    @Override
    public String toString() {
        return "Statement{" +
                "movement=" + movement +
                ", amount=" + amount +
                '}';
    }
}
