package com.sofka.properties;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {

    private final LocalDate date;


    public Date(LocalDate date) {
        this.date = date;
    }

    public static Date date(String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateParse = LocalDate.parse(dateString, formatter);
        return new Date(dateParse);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }
}
