import java.util.Scanner;

public class MissingNumber3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] numbersLine = scanner.nextLine().split(" ");

        long sum = 0L;
        for (int i = 0; i < numbersLine.length; i++) {
            sum += Integer.parseInt(numbersLine[i]);
        }

        long actualSum = ((1L + n) * n) / 2;

        System.out.println(actualSum - sum);
    }
}
