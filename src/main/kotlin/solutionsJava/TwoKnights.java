import java.util.Scanner;

public class TwoKnights {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        StringBuilder answers = new StringBuilder();
        for (long k = 1; k <= n; k++) {
            if (k > 1) answers.append("\n");
            answers.append(validCounts2(k));
        }

        System.out.println(answers);
    }

    // time com: O(n * k^4) ~ O(1^4 + 2^4 + ... n^4) ~ (n^4) NOT GOOD
    private static int validCounts(int k) {
        int ans = 0;

        int squares = k * k;
        for (int i = 0; i < squares; i++) {
            int iRow = i / k;
            int iCol = i % k;

            for (int j = i + 1; j < squares; j++) {
                int jRow = j / k;
                int jCol = j % k;

                if ((jRow == iRow + 1) && ((jCol == iCol - 2) || (jCol == iCol + 2))) continue;
                if ((jRow == iRow + 2) && ((jCol == iCol - 1) || (jCol == iCol + 1))) continue;
                ans++;
            }
        }

        return ans;
    }

    // O(k)
    private static long validCounts2(long k) {
        long squares = k * k;
        long totalPlacings = ((1 + (squares - 1)) * (squares - 1) / 2);

        long possiblePlacings = 0L;
        for (long col = 0; col < k; col++) {
            if ((col + 1) < k) {
                possiblePlacings += Math.max(0, k - 2);
                possiblePlacings += Math.max(0, k - 2);
            }

            if ((col + 2) < k) {
                possiblePlacings += Math.max(0, k - 1);
                possiblePlacings += Math.max(0, k - 1);
            }

//        if ((col - 1) >= 0) {
//            possiblePlacings += Math.max(0, k - 2);
//        }
//
//        if ((col - 2) >= 0) {
//            possiblePlacings += Math.max(0, k - 1);
//        }
        }

        return totalPlacings - possiblePlacings;
    }
}
