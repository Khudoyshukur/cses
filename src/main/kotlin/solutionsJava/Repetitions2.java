import java.util.Scanner;

public class Repetitions2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();

        System.out.println(longestSubstringWithoutRepeatingChar(str));
    }

    private static int longestSubstringWithoutRepeatingChar(String str) {
        int left = 0;
        int right = 0;
        int res = 0;

        while (right < str.length()) {
            if (str.charAt(right) != str.charAt(left)) {
                res = Math.max(res, right - left);
                left = right;
            }
            right++;
        }
        res = Math.max(res, right - left);

        return res;
    }
}
