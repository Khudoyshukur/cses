import java.util.Scanner;

public class DigitQueries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        long[] queries = new long[n];
        for (int i = 0; i < n; i++) {
            queries[i] = Long.parseLong(scanner.nextLine().trim());
        }

        for (long q : queries) {
            System.out.println(atK(q));
        }
    }

    private static long atK(long k) {
        // ranges like [1..9] [10..(10 + 179)] [190..]
        // after finding the number of digits, find the exact number,
        // then use the remainder to pick the exact digit

        long range = k;
        long curr = 9L;
        int digits = 1;
        while (range > (curr * digits)) {
            range -= (curr * digits);

            digits++;
            curr *= 10;
        }

        long minNum = 1L;
        for (int i = 0; i < digits - 1; i++) {
            minNum *= 10;
        }
        long num = (range % digits == 0L ? (range / digits) - 1 : (range / digits)) + minNum;
        long rem = range % digits;

        if (rem == 0L) return num % 10;
        for (int i = 0; i < digits - (int) rem; i++) {
            num /= 10;
        }

        return num % 10;
    }
}
