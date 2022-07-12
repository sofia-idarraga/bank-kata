package com.sofka.properties;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Date object, allow the bank manage it own date type
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
