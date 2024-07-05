import java.util.Arrays;

public class LongestCommonPrefix4 {
    public static void main(String[] args) {
        String[] input = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix4(input));
        System.out.println("10:08");
    }

    private static String longestCommonPrefix4(String strs[]) {
        Arrays.sort(strs);
        int l = strs.length;
        int i = 0;
        for (; i < strs[0].length(); i++) {
            if (strs[0].charAt(i) != strs[l - 1].charAt(i)) {
                break;
            }
        }
        return strs[0].substring(0, i);
    }
}
