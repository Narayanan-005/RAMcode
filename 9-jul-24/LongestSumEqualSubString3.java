import java.util.Scanner;

public class LongestSumEqualSubString3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(longestSumEqualSubString3(scanner.next()));
        System.out.println("4:11");
    }

    private static String longestSumEqualSubString3(String str) {
        int l = str.length();
        int size = (l % 2 == 0) ? l : l - 1;
        while (true) {
            if (size == 0) {
                break;
            }
            for (int i = 0; i <= l - size; i++) {
                String temp = str.substring(i, i + size);
                if (isEvenSum(temp)) {
                    return temp;
                }
            }
            size -= 2;
        }
        return "";
    }

    private static boolean isEvenSum(String str) {
        int l = str.length();
        int sum1 = 0, sum2 = 0;
        int i = 0, j = l / 2;
        while (j < l) {
            sum1 += str.charAt(i++) - '0';
            sum2 += str.charAt(j++) - '0';
        }
        return sum1 == sum2;
    }
}
