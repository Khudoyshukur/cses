import java.util.Scanner;

public class NumberSpiral {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] test = scanner.nextLine().trim().split(" ");
            long row = Long.parseLong(test[0]);
            long col = Long.parseLong(test[1]);

            long max = Math.max(row, col);

            long answer;
            if (max % 2 == 1L) {
                if (row == col) {
                    answer = (row * row) - (row - 1);
                } else if (row > col) {
                    answer = ((row - 1) * (row - 1)) + col;
                } else {
                    answer = (col * col) - (row - 1);
                }
            } else {
                if (row == col) {
                    answer = (row * row) - (row - 1);
                } else if (row > col) {
                    answer = (row * row) - (col - 1);
                } else {
                    answer = ((col - 1) * (col - 1)) + row;
                }
            }

            if (i > 0) res.append("\n");
            res.append(answer);
        }

        System.out.println(res);
    }
}
