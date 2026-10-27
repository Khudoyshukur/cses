import java.util.Arrays;
import java.util.Scanner;

public class DistinctNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        String[] parts = scanner.nextLine().split(" ");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        Arrays.sort(nums);

        int ans = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
