import java.util.Scanner;

public class BitStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int res = 0;
        int MOD = 1_000_000_007;

        int calc = 1;
        for (int i = 0; i < n; i++) {
            res = (res % MOD + calc) % MOD;
            calc = ((calc % MOD) * (2 % MOD)) % MOD;
        }

        System.out.print(res + 1);
    }
}
