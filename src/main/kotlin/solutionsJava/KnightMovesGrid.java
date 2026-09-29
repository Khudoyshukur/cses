import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KnightMovesGrid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        int[][] board = new int[n][n];
        for (int[] row : board) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean[] seen = new boolean[n * n];
        seen[0] = true;

        int[] r = {-2, -2, 2, 2, 1, -1, 1, -1};
        int[] c = {1, -1, 1, -1, -2, -2, 2, 2};

        while (!queue.isEmpty()) {
            int[] entry = queue.remove();
            int idx = entry[0];
            int moves = entry[1];
            int row = idx / n;
            int col = idx % n;
            board[row][col] = Math.min(board[row][col], moves);

            for (int i = 0; i < r.length; i++) {
                int newRow = row + r[i];
                int newCol = col + c[i];

                if (isValidIndex(newRow, newCol, n)) {
                    int newIdx = newRow * n + newCol;
                    if (!seen[newIdx]) {
                        queue.add(new int[]{newIdx, moves + 1});
                        seen[newIdx] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append("\n");
            for (int j = 0; j < n; j++) {
                if (j > 0) sb.append(" ");
                sb.append(board[i][j]);
            }
        }
        System.out.println(sb);
    }

    private static boolean isValidIndex(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}
