import java.util.Arrays;
import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] numbers = new int[n - 1];
        String[] numbersLine = scanner.nextLine().split(" ");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersLine[i]);
        }

        System.out.println(missingNumber(numbers));
    }

    // sort the array, and find a missing number
    private static int missingNumber(int[] numbers) {
        int[] sorted = numbers.clone();
        Arrays.sort(sorted);

        if (sorted[0] != 1) return 1;

        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] - sorted[i - 1] != 1) {
                return sorted[i] - 1;
            }
        }

        return numbers.length + 1;
    }
}
