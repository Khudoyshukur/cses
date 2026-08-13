import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BitStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int res = 0;
        int MOD = 1_000_000_007;

        Map<Integer, Integer> modMap = new HashMap<>();
        int calc = 1;
        for (int i = 0; i < n; i++) {
            modMap.put(i, calc);
            calc = ((calc % MOD) * (2 % MOD)) % MOD;
        }

        for (int i = 0; i < n; i++) {
            res = (res % MOD + modMap.get(i)) % MOD;
        }

        System.out.print(res + 1);
    }
}
