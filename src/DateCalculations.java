import java.util.Scanner;

public class DateCalculations {
    public static String yearStr, monthStr, dateStr, fullDateStr;
    public static int year, month, date, currentTerm;
    public static String todaysDate() {
        Scanner read = new Scanner( System.in );

        //Date is entered seperately to add more flexibility when handling it.
        System.out.print( "Enter today's year in the foramt YYYY: " );
        yearStr = read.next();
        year = Integer.parseInt( yearStr );
        System.out.println();
        System.out.print( "Enter today's month in the format MM: " );
        monthStr = read.next();
        month = Integer.parseInt( monthStr );
        System.out.println();
        System.out.print( "Enter today's date in the format DD: " );
        dateStr = read.next();
        date = Integer.parseInt( dateStr );
        System.out.println();

        fullDateStr = dateStr + monthStr + yearStr;

        return fullDateStr;
    }

    public static int findCurrentTerm() {
        /**
         * Academic year is divided into three terms as follows
         * Term 1 -- June to August
         * Term 2 -- September to December
         * Term 3 -- January to March
         */
        if( monthStr.equals( "06" ) || monthStr.equals( "07" ) || monthStr.equals( "08" ) ) {
            currentTerm = 1;
            return 1;
        } else if ( monthStr.equals( "09" ) || monthStr.equals( "10" ) || monthStr.equals( "11" ) || monthStr.equals( "12" ) ) {
            currentTerm = 2;
            return 2;
        } else if( monthStr.equals( "01" ) || monthStr.equals( "02" ) || monthStr.equals( "03" ) ) {
            currentTerm = 3;
            return 3;
        } else {
            currentTerm = 0;
            return 0;
        }
    }

    public static boolean isDueDateOver() {
        if( findCurrentTerm() == 1 && ( monthStr.equals( "06" ) ||  monthStr.equals( "07" ) ||  monthStr.equals( "08" ) ) ) {
            return false;
        } else if( findCurrentTerm() == 2 && ( monthStr.equals( "09" ) ||  monthStr.equals( "10" ) ||  monthStr.equals( "11" ) || monthStr.equals( "12" ) ) ) {
            return false;
        } else if( findCurrentTerm() == 3 && ( monthStr.equals( "01" ) ||  monthStr.equals( "02" ) ||  monthStr.equals( "03" ) ) ) {
            return false;
        } else {
            return true;
        }
    }

    public static int findDaysLate() {
        //Yet to be written
        int daysLate, tempMonth = month - 1;
        if( tempMonth == 0 ) {
            tempMonth = 12;
        }
        switch( currentTerm ) {
            case 1:
                daysLate = date;
                while ( tempMonth != 8 ) {
                    daysLate += findDaysInMonth( tempMonth );
                    tempMonth--;
                    if( tempMonth == 0 ) {
                        tempMonth = 12;
                    }
                }
                break;
            case 2:
                daysLate = date;
                while ( tempMonth != 12 ) {
                    daysLate += findDaysInMonth( tempMonth );
                    tempMonth--;
                    if( tempMonth == 0 ) {
                        tempMonth = 12;
                    }
                }
                break;
            case 3:
                daysLate = date;
                while ( tempMonth != 3 ) {
                    daysLate += findDaysInMonth( tempMonth );
                    tempMonth--;
                    if( tempMonth == 0 ) {
                        tempMonth = 12;
                    }
                }
                break;
        }
    }

    public static int findDaysInMonth( int monthToFind ) {
        if( monthToFind == 1 || monthToFind == 3 || monthToFind == 7 || monthToFind == 8 || monthToFind == 10 || monthToFind == 12 ) {
            return 31;
        } else if( monthToFind == 4 || monthToFind == 6 || monthToFind == 9 || monthToFind == 11 ) {
            return 30;
        } else if ( monthToFind == 2 && year % 4 == 0 ) {
            return 29;
        } else if ( monthToFind == 2 &&  year % 4 != 0 ) {
            return 28;
        }
    }
}