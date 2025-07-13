import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Day of birth: ");
        int bDay = scanner.nextInt();
        System.out.println("Month of birth: ");
        int bMonth = scanner.nextInt();
        System.out.println("Year of birth? ");
        int bYear = scanner.nextInt();

        System.out.println("Today's date: ");
        int tDay = scanner.nextInt();
        System.out.println("Today's month: ");
        int tMonth = scanner.nextInt();
        System.out.println("Today's year: ");
        int tYear = scanner.nextInt();


        System.out.println(sum(bDay, tDay, bMonth, tMonth, bYear, tYear));


    }


    public static int Day2Day(int bDay, int tDay){

        return tDay - bDay;

    }


    public static int Month2Month(int bMonth, int tMonth, int tYear){

        int totalDays = 0;

        if (bMonth < tMonth){
            for (int i = bMonth ; i < tMonth ; i++){
                totalDays = totalDays + cases(i, tYear);
            }
        }
        else if(bMonth > tMonth){
            for (int i = tMonth ; i < bMonth ; i++){
                totalDays = totalDays - cases(i, tYear);
            }
        }
        return totalDays;
    }

    public static int Year2Year(int bYear, int tYear){

        int totalDays = 0;

        for (int i = bYear ; i < tYear; i++){
            if (i % 4 == 0){
                if (i % 100 == 0){
                    if (i % 400 == 0){
                        totalDays = totalDays + 366;
                    }
                }
                else {
                    totalDays = totalDays + 366;
                }
            }
            else {
                totalDays = totalDays + 365;
            }
        }
        return totalDays;
    }

    public static int cases(int month, int tYear){

        if (tYear % 4 == 0){
            if (tYear % 100 == 0){
                if (tYear % 400 == 0){
                    switch (month){

                        case 2: return 29;
                        case 4, 6, 9, 11: return 30;
                        default: return 31;
                    }
                }
            }
            else {
                switch (month){
                    case 2: return 29;
                    case 4, 6, 9, 11: return 30;
                    default: return 31;
                }
            }
        }
        else {
            switch (month){

                case 2: return 28;
                case 4, 6, 9, 11: return 30;
                default: return 31;
            }
        }
        return month;

    }

    public static int sum(int bDay, int tDay, int bMonth, int tMonth, int bYear, int tYear){


        return Day2Day(bDay, tDay) + Month2Month(bMonth, tMonth, tYear) + Year2Year(bYear, tYear);

    }





}