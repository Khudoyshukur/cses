import java.util.Scanner;

public class AppleDivision {
    static int n;
    static long[] w;
    static long total;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();
        String[] parts = scanner.nextLine().trim().split(" ");
        w = new long[parts.length];
        for (int i = 0; i < parts.length; i++) {
            w[i] = Long.parseLong(parts[i]);
        }

        total = 0;
        for (long x : w) {
            total += x;
        }

        System.out.println(minDiff(0, 0L));
    }

    static long minDiff(int index, long currSum) {
        if (index >= n) return Math.abs(currSum - (total - currSum));

        // include
        long include = minDiff(index + 1, currSum + w[index]);

        // skip
        long skip = minDiff(index + 1, currSum);

        return Math.min(skip, include);
    }
}
