import java.util.Scanner;

public class MissingNumber2 {
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

    // using set
    private static int missingNumber(int[] numbers) {
        boolean[] set = new boolean[numbers.length + 1];

        for (int num : numbers) {
            set[num - 1] = true;
        }

        for (int i = 0; i < set.length; i++) {
            if (!set[i]) return i + 1;
        }

        return set.length + 1;
    }
}
