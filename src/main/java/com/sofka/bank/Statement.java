package com.sofka.bank;

import com.sofka.properties.Action;
import com.sofka.properties.Movement;
import java.time.LocalDate;

import static com.sofka.properties.Date.date;
import static com.sofka.properties.Movement.findAction;

/**
 * Statement object with all its methods
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
