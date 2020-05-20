package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Get Calendar instance
        Calendar calendar = Calendar.getInstance();
        // Today
        Day Today = new Day(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));

        // Last birthday
        Day lastBirthday = new Day(2019, 8, 28);

        // Display the number of days between today and last birthday
        System.out.println("The number of days between today and last birthday is " + Today.daysFrom(lastBirthday));
        System.out.println();

        // Get 100 days after today
        Day aHundredDaysFromToday = Today.addDays(100);

        // Display the date, month, and year of the day 100 days after today
        System.out.println("100 Days after today is: ");
        System.out.println("Date: " + aHundredDaysFromToday.getDate());
        System.out.println("Month: " + aHundredDaysFromToday.getMonth());
        System.out.println("Year: " + aHundredDaysFromToday.getYear());
        System.out.println();

        // Ask user for input Day d
        int day, month, year, n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide a date.");

        // Validate input date
        boolean dateIsValid = false;
        do {
            day = getDay(scanner);
            month = getMonth(scanner);
            year = getYear(scanner);
            if (validateDate(day, month, year)) {
                dateIsValid = true;
            } else {
                System.out.println("Not a valid date. Try again.\n");
            }

        } while (!dateIsValid);

        Day d = new Day(year, month, day);


        // Ask user for input n, the number of days after d
        System.out.print("After how many days: ");
        n = scanner.nextInt();

        // Get n days after d
        Day resultingDay = d.addDays(n);

        // Display n days after d
        System.out.println();
        System.out.println("n = " + n);
        System.out.printf("d = %s/%s/%s\n", d.getMonth(), d.getDate(), d.getYear());
        System.out.println("n Days after d is: ");
        System.out.println("Date: " + resultingDay.getDate());
        System.out.println("Month: " + resultingDay.getMonth());
        System.out.println("Year: " + resultingDay.getYear());
        System.out.println();

        // Get the number of days between d and the resulting day
        int numberOfDaysBetweenResultingDayAndProvidedDay = resultingDay.daysFrom(d);

        // Display the number of days between d and the resulting day
        System.out.println("The number of days between d and the resulting day is: " + numberOfDaysBetweenResultingDayAndProvidedDay);

        // Get the number of days between d and the resulting day
        int numberOfDaysBetweenResultingDayAndProvidedDay1 = d.addDays(n).daysFrom(d);
        // Display the number of days between d and the resulting day
        System.out.println("The number of days between d and the resulting day is (combining answers to 3 and 4): " + numberOfDaysBetweenResultingDayAndProvidedDay1);

    }

    /**
     * @param day   Int value representing a day of a month.
     * @param month Int value representing a month.
     * @param year  Int value representing a year.
     * @return boolean Representing whether a date is valid.
     */
    private static boolean validateDate(int day, int month, int year) {
        final String DATE_FORMAT = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        df.setLenient(false);
        try {
            df.parse(year + "-" + month + "-" + day);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Get year from input
     *
     * @param scanner Scanner object for getting input from console
     */
    private static int getYear(Scanner scanner) {
        int year;
        do {
            System.out.print("Enter year (an int, not 0): ");
            getIntInput(scanner);
            year = scanner.nextInt();
            if (year == 0) {
                System.out.println("Year must not be 0.\n");
            }
        } while (year == 0);
        return year;
    }

    /**
     * Get month from input
     *
     * @param scanner Scanner object for getting input from console
     */
    private static int getMonth(Scanner scanner) {
        int month;
        do {
            System.out.print("Enter month (an int between 1 and 12): ");
            getIntInput(scanner);
            month = scanner.nextInt();
            if (month < 1 || month > 12) {
                System.out.println("Month must be between 1 and 12.\n");
            }
        } while (month < 1 || month > 12);
        return month;
    }

    /**
     * Get day from input
     *
     * @param scanner Scanner object for getting input from console
     */
    private static int getDay(Scanner scanner) {
        int day = 0;
        do {
            System.out.print("Enter day (an int between 1 and 31): ");
            getIntInput(scanner);
            day = scanner.nextInt();
            if (day < 1 || day > 31) {
                System.out.println("Day must be between 1 and 31.\n");
            }
        } while (day < 1 || day > 31);
        return day;
    }

    /**
     * Ensure that the input is an int
     *
     * @param scanner Scanner object for getting input from console
     */
    private static void getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Input must be an int. Try again: ");
            scanner.nextLine();
        }
    }

}
