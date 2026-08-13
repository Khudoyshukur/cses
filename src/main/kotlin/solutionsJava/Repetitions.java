import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();

        System.out.println(longestSubstringWithoutRepeatingChar(str));
    }

    private static int longestSubstringWithoutRepeatingChar(String str) {
        // the string only contains letters ACGT
        // lets map then as 0 1 2 3
        int[] lettersCount = new int[4];

        int left = 0;
        int right = 0;
        int res = 0;
        while (right < str.length()) {
            lettersCount[mIndex(str.charAt(right++))]++;

            if (isValid(lettersCount)) {
                res = Math.max(res, right - left);
            } else {
                while (!isValid(lettersCount)) {
                    lettersCount[mIndex(str.charAt(left++))]--;
                }
            }
        }
        res = Math.max(res, right - left);

        return res;
    }

    private static int mIndex(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            default: return 3;
        }
    }

    private static boolean isValid(int[] lettersCount) {
        int sum = 0;
        for (int count : lettersCount) {
            sum += count;
        }
        for (int count : lettersCount) {
            if (count == sum) return true;
        }
        return false;
    }
}
