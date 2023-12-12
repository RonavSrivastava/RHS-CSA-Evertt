import java.util.Scanner;
import java.time.*;

public class AppMain {
    public static void main(String[] args) {
        // Create a Scanner object.
        // Asks the user to type their age, the current year, a future year, and their name.
        // Print out "<Name> will be <computed age> years old in <future year>".
        LocalDate today = LocalDate.now();

        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        Scanner scan = new Scanner(System.in);


        //get users name and birthday
        System.out.println("What is your name?");
        String name = scan.next();
        System.out.println("When is your birthday?");
        System.out.print("Year: ");
        int userYear = scan.nextInt();
        System.out.print("Month: ");
        int userMonth = scan.nextInt();
        System.out.print("Day: ");
        int userDay = scan.nextInt();


        //get the future date to calculate
        System.out.println("Enter a future time");
        System.out.print("Year: ");
        int ftYear = scan.nextInt();
        System.out.print("Month: ");
        int ftMonth = scan.nextInt();
        System.out.print("Day: ");
        int ftDay = scan.nextInt();

        //find the difference
        int yrDiff = ftYear - userYear;
        int monthDiff = ftMonth - userMonth;
        int dayDiff = ftDay - userDay;


        //account for negative values (for example, user is born in april and future date is in march, future minus user will give a negative)
        if (monthDiff < 0) {
            yrDiff -= 1;
            monthDiff += 12;
        }
        if (dayDiff < 0) {
            monthDiff -= 1;
            if (userMonth == 1 || userMonth == 3 || userMonth == 5 || userMonth == 7 || userMonth == 8 || userMonth == 10 || userMonth == 12) {
                dayDiff += 31;
            }
            else {
                dayDiff += 30;
            }
        }

        //neatly print it out, format: On the (future day) of (future month name), (future year), (name) will be (year) Years, (month) Months, and (day) Days old.
        System.out.println(printStr(ftDay, monthstr(ftMonth), ftYear) + ", " + name + " will be " + yrDiff + " Years, " + monthDiff + " Months, and " + dayDiff + " Days old.");


        //do it again with the current date for fun
        int yrDiff2 = year - userYear;
        int monthDiff2 = month - userMonth;
        int dayDiff2 = day - userDay;

        //account for negatives
        if (monthDiff2 < 0) {
            yrDiff2 -= 1;
            monthDiff2 += 12;
        }
        if (dayDiff2 < 0) {
            monthDiff2 -= 1;
            if (userMonth == 1 || userMonth == 3 || userMonth == 5 || userMonth == 7 || userMonth == 8 || userMonth == 10 || userMonth == 12) {
                dayDiff2 += 31;
            }
            else {
                dayDiff2 += 30;
            }
        }

        //neatly print it out
        System.out.println();
        System.out.println(name + " is currently " + yrDiff2 + " Years, " + monthDiff2 + " Months, and " + dayDiff2 + " Days old.");

        scan.close();
    }


    /**
     * 
     * @param month - Takes in the month's number (1 = jan, 2 = feb, ...)
     * @return String with the name of the month
     */
    public static String monthstr(int month) {
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
        }
        //im too lazy to add an exception so just dont enter anything above 12 or below 0
        return "die";
    }


    /**
     * 
     * @param ftDay - a day
     * @param ftMonthstr - a month
     * @param ftYear - a year
     * @return A neatly formatted string with the date given
     */
    public static String printStr(int ftDay, String ftMonthstr, int ftYear) {
        switch (ftDay) {
            case 1:
                return "On the " + ftDay + "st of " + ftMonthstr + ", " + ftYear;
            case 21:
                return "On the " + ftDay + "st of " + ftMonthstr + ", " + ftYear;
            case 31:
                return "On the " + ftDay + "st of " + ftMonthstr + ", " + ftYear;
            case 2:
                return "On the " + ftDay + "nd of " + ftMonthstr + ", " + ftYear;
            case 22:
                return "On the " + ftDay + "nd of " + ftMonthstr + ", " + ftYear;
            case 3:
                return "On the " + ftDay + "rd of " + ftMonthstr + ", " + ftYear;
            case 33:
                return "On the " + ftDay + "rd of " + ftMonthstr + ", " + ftYear;
        }
        return "On the " + ftDay + "th of " + ftMonthstr + ", " + ftYear;
    }

}
