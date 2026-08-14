import java.util.Scanner;

public class PalindromeReorder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        // the str only contains uppercase letters, so we can use IntArray of size 26 to count letters
        // to be able to form a palindrome, each letter should be even times in the str

        int[] letterCount = new int[26];
        for (int i = 0; i < str.length(); i++) {
            letterCount[str.charAt(i) - 'A']++;
        }

        int oddCount = 0;
        for (int i = 0; i < letterCount.length; i++) {
            if (letterCount[i] % 2 != 0) oddCount++;
        }
        if (oddCount > 1 || (oddCount == 1 && str.length() % 2 == 0)) {
            System.out.println("NO SOLUTION");
            return;
        }

        StringBuilder res = new StringBuilder(str);
        int currIndex = 0;
        for (int i = 0; i < letterCount.length; i++) {
            while (letterCount[i] > 1) {
                char ch = (char) ('A' + i);
                res.setCharAt(currIndex, ch);
                res.setCharAt(res.length() - 1 - currIndex, ch);

                currIndex++;
                letterCount[i] -= 2;
            }
        }
        for (int i = 0; i < letterCount.length; i++) {
            if (letterCount[i] == 1) {
                res.setCharAt(currIndex, (char) ('A' + i));
                break;
            }
        }

        System.out.println(res);
    }
}
