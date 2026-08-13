import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> result = permutations(n);
        if (!result.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.size(); i++) {
                if (i > 0) sb.append(" ");
                sb.append(result.get(i));
            }
            System.out.println(sb);
        } else {
            System.out.println("NO SOLUTION");
        }
    }

    private static List<Integer> permutations(int n) {
        if (n == 1) return Arrays.asList(1);

        List<Integer> list = new ArrayList<>();
        if (n <= 3) return list;

        for (int i = 2; i <= n; i += 2) { list.add(i); }
        for (int i = 1; i <= n; i += 2) { list.add(i); }

        return list;
    }
}
