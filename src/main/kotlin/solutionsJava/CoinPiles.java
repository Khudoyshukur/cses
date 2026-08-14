import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoinPiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        List<String> res = new ArrayList<>();
        for (int it = 0; it < t; it++) {
            String[] test = scanner.nextLine().trim().split(" ");
            int left = Integer.parseInt(test[0]);
            int right = Integer.parseInt(test[1]);

            res.add(possible(left, right) ? "YES" : "NO");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            if (i > 0) sb.append("\n");
            sb.append(res.get(i));
        }
        System.out.println(sb);
    }

    // in one step, i can either take 2 from left and 1 from right, or 2 from right and 1 from left
    // can i empty both piles????

    // the sum of them should be divisible by 3. because in each step i am removing 3 piles
    // also, moreSide/2 should not be greater than anotherSide
    private static boolean possible(int left, int right) {
        if ((left + right) % 3 != 0) return false;

        // a = 2 * k + 1 * l
        // b = 2 * l + 1 * k
        // a + b = 3 * k + 3 * l => a + b = 3 * (k + l) => k + l = steps

        // a - b = 2k + 1l - 2l - 1k=  k - l
        // k - l = a - b
        // k + l = (a + b) / 2 => k + l = steps

        // a = 8 b = 1
        // => k = (a - b + steps) / 2   => k = 5
        // => l = (steps - (a - b)) / 2 => l = -2

        // a = 8, b = 1 => steps = 3  => k + l = 3
        int steps = (left + right) / 3;
        int aMinusB = left - right;

        int k = (aMinusB + steps) / 2;
        int l = (steps - aMinusB) / 2;

        return k >= 0 && l >= 0;
    }
}
