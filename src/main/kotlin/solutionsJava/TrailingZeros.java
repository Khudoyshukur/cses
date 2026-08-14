import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrailingZeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // if the number is divided by 5, then it will add one 0
        // if the number is divided by 25, then it will add two 0

        List<Integer> fiveDividers = new ArrayList<>();
        int initial = 5;
        while (initial <= n) {
            fiveDividers.add(initial);

            initial *= 5;
        }

        // lets say we have n numbers divided by 5
        // k numbers are divided by 25
        // z numbers divided by 125 etc.

        int[] countByDividers = new int[fiveDividers.size()];
        int sum = 0;
        for (int i = fiveDividers.size() - 1; i >= 0; i--) {
            countByDividers[i] = n / fiveDividers.get(i) - sum;

            sum += countByDividers[i];
        }

        int res = 0;
        for (int i = 0; i < countByDividers.length; i++) {
            res += countByDividers[i] * (i + 1);
        }

        System.out.println(res);
    }
}
