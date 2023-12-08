package jm.exercises.set03;

import rl.util.terminal.Terminal;

public class ExerciseSet03 {
    public static void main(String[] args) {
        String name = Terminal.readString("Enter your name");
        for (int i = 0; i < 3; i++) {
            System.out.println(name);
        }
        planProject();

        int year = Terminal.readInt("Year");
        int month = Terminal.readInt("Month");
        int day = Terminal.readInt("Day");

        System.out.println("days in Month: " + getDaysOfMonth(month,year));
        System.out.println("Day of the week: " + getDayOfTheWeek(day,month,year));
        printCalendar(month,year);
    }
    public static void planProject() {
        double workHours = Terminal.readDouble("Enter estimated hours of work needed");
        int wage = Terminal.readInt("Enter Wage per hour");
        int workers = Terminal.readInt("Enter the number of available workers");

        double hours = workHours / workers;
        double totalCost = hours * wage;
        int days = (int)Math.ceil(hours / 8);

        System.out.println("Total Cost: " + totalCost);
        System.out.println("Workdays required: " + days);

    }
    public static int getDaysOfMonth(int month, int year) {
        int days;
        boolean isLeapYear = false;
        
        //leap year calculation
        if (year%4 == 0) {
            if (year%100 == 0) {
                isLeapYear = year % 400 == 0;
            }
        }
        
        // day calculation
        if(month == 2) {
            //February
            days = 28;
            if (isLeapYear){
                days++;
            }
        }
        else {
            if (month < 8) {
                if ((month % 2) == 0) {
                    days = 30;
                }
                else {
                    days = 31;
                }
            }
            else {
                if ((month % 2) == 0){
                    days = 31;
                }
                else {
                    days = 30;
                }
            }

        }
        return days;
    }
    public static int getDayOfTheWeek(int day, int month, int year) {

        int m = month;
        if (m < 3) {
            m += 12;
            year--;
        }
        int j = year / 100;
        int k = year % 100;

        int h = (day + (13*(m+1))/5 + k + k/4 + j/4 + 5*j) % 7; //calculation of weekday according to https://de.wikipedia.org/wiki/Zellers_Kongruenz

        h = ((h + 5) % 7) + 1; //reformation to correct weekday format
        return h;
    }
    public static void printCalendar(int month, int year) {
        int firstDay = getDayOfTheWeek(1,month,year) - 2;
        int days = getDaysOfMonth(month, year);

        int[][] calendar = new int[6][7];
        //fill array with corresponding dates
        for (int row = 0; row < 6; row++) {
            for (int column = 0; column < 7; column++) {
                calendar[row][column] = 7*row + column - firstDay;
            }
        }
        //print calender
        System.out.println("Mo Tu We Th Fr Sa Su");
        for (int row = 0; row < 6; row++) {
            for (int column = 0; column < 7; column++) {
                if ((calendar[row][column] <= 0) || (calendar[row][column] > days)) {
                    System.out.print("   "); //print blank space if out of bounds
                } else if (calendar[row][column] < 10) {
                    System.out.print(" " + calendar[row][column] + " "); // print blanks around date
                } else {
                    System.out.print(calendar[row][column] + " ");
                }
            }
            System.out.println(); // print new line after each row
        }

    }
}
