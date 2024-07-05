import java.util.HashSet;
import java.util.Set;

public class LongestChain2 {
    public static void main(String[] args) {
        int arr[][] = {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}};
        System.out.println(longestChain2(arr));
        System.out.println("9:59");
    }

    private static int longestChain2(int[][] arr) {
        int l = arr.length;
        Set<Integer> set = new HashSet();
        int length = 1;
        int minIndex = 0;
        for (int i = 1; i < l; i++) {
            if (arr[i][1] < arr[minIndex][1]) {
                minIndex = i;
            }
        }
        set.add(minIndex);
        while (true) {
            int index = -1;
            for (int i = 0; i < l; i++) {
                if (!set.contains(i) && arr[minIndex][1] < arr[i][0]) {
                    if (index == -1) {
                        index = i;
                    } else if (arr[i][0] < arr[index][0]) {
                        index = i;
                    }
                }
            }
            if (index == -1) {
                break;
            } else {
                length++;
                set.add(index);
                minIndex = index;
            }
        }
        return length;
    }
}
