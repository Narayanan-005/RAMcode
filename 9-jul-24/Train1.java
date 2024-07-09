import java.util.Arrays;
import java.util.Scanner;

public class Train1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        int nA = scanner.nextInt();
        int nB = scanner.nextInt();
        String[][] scheduleA = input(nA);
        String[][] scheduleB = input(nB);
        if (nA == 0) {
            System.out.println("Total Trains needed station A:" + 0);
            System.out.println("Total Trains needed station B:" + nB);
        } else if (nB == 0) {
            System.out.println("Total Trains needed station A:" + nA);
            System.out.println("Total Trains needed station B:" + 0);
        } else {
            int arr[] = calculate(scheduleA, scheduleB, t);
            System.out.println("Total Trains needed station A:" + arr[0]);
            System.out.println("Total Trains needed station B:" + arr[1]);
        }
        System.out.println("2:40");
    }

    private static String[][] input(int n) {
        String arr[][] = new String[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.next();
            arr[i][1] = scanner.next();
        }
        return arr;
    }

    private static int[] calculate(String[][] scheduleA, String[][] scheduleB, int t) {
        Arrays.sort(scheduleA, (a, b) -> a[0].compareTo(b[0]));
        Arrays.sort(scheduleB, (a, b) -> a[0].compareTo(b[0]));
        int ntA = findTrain(scheduleA, scheduleB, t);
        int ntB = findTrain(scheduleB, scheduleA, t);
        int arr[] = new int[]{ntA, ntB};
        return arr;
    }

    private static int findTrain(String[][] first, String[][] second, int t) {
        int noOfTrains = 0;
        for (int i = 0; i < first.length; i++) {
            int index = -1;
            int difference = 1;
            for (int j = 0; j < second.length; j++) {
                if (second[j][1] != null && second[j][1].compareTo(first[i][0]) < 0) {
                    String temp[] = second[j][1].split(":");
                    int min = Integer.parseInt(temp[1]);
                    String time = temp[0] + ":";
                    min += t;
                    if (min < 10) {
                        time += "0" + min;
                    } else {
                        time += min;
                    }
                    if (time.compareTo("24:00") < 0) {
                        int diff = time.compareTo(first[i][0]);
                        if (diff <= 0 && index == -1) {
                            index = j;
                            difference = diff;
                        } else if (diff <= 0 && difference > diff) {
                            index = j;
                            difference = diff;
                        }
                    }
                }
            }
            if (index == -1) {
                noOfTrains++;
            } else {
                second[index][1] = null;
            }
        }
        return noOfTrains;
    }
}
