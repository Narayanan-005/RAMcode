import java.util.Scanner;

public class FindElementInRotatedArray5 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int arr[] = input();
        int k = scanner.nextInt();
        System.out.println(findElementInRotatedArray5(arr, k));
        System.out.println("3:55");
    }

    private static int[] input() {
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    private static int findElementInRotatedArray5(int[] arr, int k) {
        int l = arr.length - 1;
        int breakPoint = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid < l && arr[mid] > arr[mid + 1]) {
                breakPoint = mid;
                break;
            } else if (arr[0] > arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(breakPoint);
        if (breakPoint != -1 && breakPoint != 0) {
            if (arr[0] > k) {
                return search(arr, breakPoint + 1, l, k);
            }
            return search(arr, 0, breakPoint, k);
        }
        return search(arr, 0, l, k);
    }

    private static int search(int arr[], int start, int end, int k) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
