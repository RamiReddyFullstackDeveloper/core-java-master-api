package com.slns;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateConverterExamples {

    public static void main(String[] args) throws ParseException {

        getCurrentLocalDate();
        addPlusDaysToLocalDate();
        minusDaysToLocalDate();
        getCurrentLocalDateTime();
        addPlusDaysToLocalDateTime();
        minusDaysToLocalDateTime();
        getCurrentDateTimeIn_UTC_Format();
        addPlusDaysToCurrentDateTimeIn_UTC_Format();
        minusDaysToCurrentDateTimeIn_UTC_Format();
        convertStringDateToLocalDate();
        convertStringToInstant();
        convertStringToDifferentDateFormatters();
    }

    static void getCurrentLocalDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println("Local Current Date :" + localDate); //Output : 2023-09-07
    }

    static void addPlusDaysToLocalDate() {
        LocalDate localDate = LocalDate.now().plusDays(5);
        System.out.println("Adding plus days to Local Current Date :" + localDate); //Output : 2023-09-12
    }

    static void minusDaysToLocalDate() {
        LocalDate localDate = LocalDate.now().plusDays(5);
        System.out.println("minus days to Local Current Date :" + localDate); //Output : 2023-09-02
    }

    static void getCurrentLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Local Current Date Time:" + localDateTime); //Output : 2023-09-07T11:32:35.439869
    }

    static void addPlusDaysToLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(5);
        System.out.println("Adding plus days to LocalDateTime:" + localDateTime); //Output : 2023-09-12T11:32:35.439869
    }

    static void minusDaysToLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now().minusDays(5);
        System.out.println("minus days to LocalDateTime:" + localDateTime); //Output : 2023-09-02T11:32:35.439869
    }

    static void getCurrentDateTimeIn_UTC_Format() {
        Instant instant = Instant.now();
        System.out.println("Instant Date Time in UTC format:" + instant); //Output : 2023-09-07T11:32:35.4398692023-09-07T11:32:35.439869Z
    }

    static void addPlusDaysToCurrentDateTimeIn_UTC_Format() {
        Instant instant = Instant.now().plus(Duration.ofDays(5));
        System.out.println("Adding plus days to Instant Date Time in UTC format:" + instant); //Output : 2023-09-07T11:32:35.4398692023-09-07T11:32:35.439869Z
    }

    static void minusDaysToCurrentDateTimeIn_UTC_Format() {
        Instant instant = Instant.now().minus(Duration.ofDays(5));
        System.out.println("minus days to Instant Time in UTC format:" + instant); //Output : 2023-09-07T11:32:35.4398692023-09-07T11:32:35.439869Z
    }

    static void convertStringDateToLocalDate() {
        String date = LocalDate.now().toString();
        System.out.println("String date = " + date); //2023-09-09
        //convert string date to LocalDate
        LocalDate localDate = LocalDate.parse(date);
        System.out.println("Converted Date = " + localDate); //2023-09-09
    }

    static void convertStringToInstant() throws ParseException {
        //Method1: Using Instant.parse() Method
        String dateString = "2023-07-08T10:30:00Z";
        Instant instant = Instant.parse(dateString);
        System.out.println("Method1: Using Instant.parse() = " + instant); //output: 2023-07-08T10:30:00Z

        //Method 2: Using DateTimeFormatter
        dateString = "2023-07-08T10:30:00Z";
        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
        instant = Instant.from(formatter.parse(dateString));
        System.out.println("Method2 = " + instant);

        //Method 3: Using SimpleDateFormat (Legacy Approach)
        dateString = "2023-07-08T10:30:00Z";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX"); //here x will be replaced to Z automatically
        Date date = sdf.parse(dateString);
        instant = date.toInstant();
        System.out.println("Method3 = " + instant);  //2023-07-08T10:30:00Z
    }


    static void convertStringToDifferentDateFormatters() throws ParseException {
        //String date = "09-09-2023";  //yyyy-MM-dd format  //will throw error DateTimeParseException
        String date = "2023-09-09";
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println("***********convertStringToDateFormat**************");
        System.out.println("localDate (yyyy-MM-dd) = " + localDate); //2023-09-09
        date = "09-09-2023";
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        localDate = LocalDate.parse(date, formatter);
        System.out.println("***********convertStringToDateFormat**************");
        System.out.println("localDate (yyyy-MM-dd) = " + localDate); //2023-09-09


        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = localDate.format(formatter);
        // localDate = LocalDate.parse(formattedDate);
        System.out.println("localDate (dd-MM-yyyy) = " + formattedDate);

        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        formattedDate = localDate.format(formatter);
        System.out.println("localDate (dd/MM/yyyy) = " + formattedDate);


        String pattern = "MM-dd-yyyy";
        DateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date d = new Date();
        System.out.println("Before Converting " + d);
        date = simpleDateFormat.format(d);
        System.out.println("After Converting Date to MM-dd-yyyy " + date);

        pattern = "dd-MM-yyyy";
        simpleDateFormat = new SimpleDateFormat(pattern);
        date = simpleDateFormat.format(d);
        System.out.println("After Converting Date to dd-MM-yyyy " + date);

        //covet String to Date
        pattern = "dd-MM-yyyy";
        simpleDateFormat = new SimpleDateFormat(pattern);
        date = simpleDateFormat.format(d);
        Date dt = simpleDateFormat.parse(date);
        System.out.println("convert string to date  " + dt);
    }
}
