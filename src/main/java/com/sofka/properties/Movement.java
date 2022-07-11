package com.sofka.properties;

import java.time.LocalDate;

public class Movement {
    public Action action;
    public Date date;

    public Movement(Action action, Date date){
        this.action = action;
        this.date =  date;
    }

    public static Action findAction(Movement movement){
        return movement.action;
    }

    public static Date findDate(Movement movement){
        return movement.date;
    }
}
