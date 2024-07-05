import java.util.Arrays;

public class FindNumberOfDays1 {
    public static void main(String[] args) {
        String from = "25-08-1998";
        String to = "27-09-2020";
        System.out.println(findNumberOfDays1(from, to));
        System.out.println("9:10");
    }

    private static int findNumberOfDays1(String from, String to) {
        String[] fromArr = from.split("-");
        String[] toArr = to.split("-");
        int days = 0;
        if (Integer.parseInt(toArr[2]) - Integer.parseInt(fromArr[2]) > 1) {
            int start = Integer.parseInt(fromArr[2]);
            int end = Integer.parseInt(toArr[2]);
            while (++start < end) {
                if (isLeap(start)) {
                    days += 366;
                } else {
                    days += 365;
                }
            }
        }
        if (Integer.parseInt(fromArr[2]) == Integer.parseInt(toArr[2])) {
            if (Integer.parseInt(fromArr[1]) == Integer.parseInt(toArr[1])) {
                days += Integer.parseInt(toArr[0]) - Integer.parseInt(fromArr[0]);
            } else {
                int year = Integer.parseInt(fromArr[2]);
                int start = Integer.parseInt(fromArr[1]);
                days += getDays(start, year) - Integer.parseInt(fromArr[0]);
                int end = Integer.parseInt(toArr[1]);
                while (++start < end) {
                    days += getDays(start, year);
                }
                days += Integer.parseInt(toArr[0]);
            }
        } else {
            int start = Integer.parseInt(fromArr[1]);
            int year = Integer.parseInt(fromArr[2]);
            days += getDays(start, year) - Integer.parseInt(fromArr[0]);
            while (++start <= 12) {
                days += getDays(start, year);
            }
            start = Integer.parseInt(toArr[1]);
            year = Integer.parseInt(toArr[2]);
            days += Integer.parseInt(toArr[0]);
            while (--start > 0) {
                days += getDays(start, year);
            }
        }
        return days;
    }

    private static int getDays(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if (isLeap(year)) {
                    return 29;
                }
                return 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
        }
        return 0;
    }

    private static boolean isLeap(int year) {
        return (year % 100 == 0 && year % 400 == 0) || year % 4 == 0;
    }
}
