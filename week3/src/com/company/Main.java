package com.company;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
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

        day = getDay(scanner);
        month = getMonth(scanner);
        year = getYear(scanner);
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
     * Get year from input
     * @param scanner Scanner object for getting input from console
     */
    private static int getYear(Scanner scanner) {
        int year;
        do {
            System.out.print("Enter year (an int, not 0): ");
            inputIsInt(scanner);
            year = scanner.nextInt();
        } while (year == 0);
        return year;
    }

    /**
     * Get month from input
     * @param scanner Scanner object for getting input from console
     */
    private static int getMonth(Scanner scanner) {
        int month;
        do {
            System.out.print("Enter month (an int between 1 and 12): ");
            inputIsInt(scanner);
            month = scanner.nextInt();
        } while (month < 1 || month > 12);
        return month;
    }

    /**
     * Get day from input
     * @param scanner Scanner object for getting input from console
     */
    private static int getDay(Scanner scanner) {
        int day;
        do {
            System.out.print("Enter day (an int between 1 and 31): ");
            inputIsInt(scanner);
            day = scanner.nextInt();
        } while (day < 1 || day > 31);
        return day;
    }

    /**
     * Check if input is an int
     * @param scanner Scanner object for getting input from console
     */
    private static void inputIsInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Input must be an int: ");
            String input = scanner.next();
        }
    }

}
