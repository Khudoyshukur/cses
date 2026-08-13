import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] numbersLine = scanner.nextLine().trim().split(" ");
        long[] numbers = new long[n];
        for (int i = 0; i < numbersLine.length; i++) {
            numbers[i] = Long.parseLong(numbersLine[i]);
        }

        System.out.println(increasingArraySteps(numbers));
    }

    private static long increasingArraySteps(long[] arr) {
        long steps = 0L;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) continue;

            steps += (arr[i - 1] - arr[i]);
            arr[i] = arr[i - 1];
        }

        return steps;
    }
}
