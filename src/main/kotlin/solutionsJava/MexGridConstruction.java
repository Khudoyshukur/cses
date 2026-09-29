import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MexGridConstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        int[][] matrix = new int[n][n];
        for (int[] row : matrix) {
            Arrays.fill(row, -1);
        }
        matrix[0][0] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] added = new boolean[n * n];
        added[0] = true;

        int[] r = {0, 1};
        int[] c = {1, 0};

        while (!queue.isEmpty()) {
            int idx = queue.remove();
            int row = idx / n;
            int col = idx % n;

            List<Integer> nums = new ArrayList<>();
            for (int cc = 0; cc < col; cc++) {
                nums.add(matrix[row][cc]);
            }

            for (int rr = 0; rr < row; rr++) {
                nums.add(matrix[rr][col]);
            }

            Collections.sort(nums);
            int target = nums.size();
            for (int i = 0; i < nums.size(); i++) {
                if (i != nums.get(i)) {
                    target = i;
                    break;
                }
            }
            matrix[row][col] = target;

            for (int k = 0; k < 2; k++) {
                int newRow = row + r[k];
                int newCol = col + c[k];

                if (isValidIndex(newRow, newCol, n)) {
                    int newIdx = newRow * n + newCol;
                    if (!added[newIdx]) {
                        queue.add(newIdx);
                        added[newIdx] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append("\n");
            for (int j = 0; j < n; j++) {
                if (j > 0) sb.append(" ");
                sb.append(matrix[i][j]);
            }
        }
        System.out.println(sb);
    }

    private static boolean isValidIndex(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}
