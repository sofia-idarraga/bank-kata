package com.sofka.properties;

/**
 * Movement object, allows the bank to identify the action and date
 *  of a client's movement
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

public class Movement {
    Action action;
    public Date date;

    public Movement(Action action, Date date){
        this.action = action;
        this.date =  date;
    }

    public static Action findAction(Movement movement){
        return movement.action;
    }

}
