import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leaders4 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int arr[] = input();
        System.out.println(leaders4(arr));
        System.out.println("3:10");
    }

    private static int[] input() {
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    private static List<Integer> leaders4(int[] arr) {
        int l = arr.length;
        List<Integer> list = new ArrayList<>();
        int max = -1;
        for (int i = l - 1; i >= 0; i--) {
            if (max == -1) {
                max = arr[i];
                list.add(0, max);
            } else if (max < arr[i]) {
                max = arr[i];
                list.add(0, max);
            }
        }
        return list;
    }
}
