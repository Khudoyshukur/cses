import java.util.Arrays;
import java.util.Scanner;

public class ChessBoardQueens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[8][8];
        for (char[] r : board) {
            Arrays.fill(r, '+');
        }

        int row = 0;
        while (row < 8) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                board[row][i] = line.charAt(i);
            }
            row++;
        }

        long ways = possibleWays(
                board,
                0,
                0,
                0,
                0,
                8,
                0
        );
        System.out.println(ways);
    }

    static int diaL(int row, int col) {
        if (col >= row) { // upper
            return col - row;
        } else { // lower
            return 7 + (row - col);
        }
    }

    static int diaR(int row, int col) {
        int newCol = row;
        int newRow = 7 - col;

        return diaL(newRow, newCol);
    }

    static int set(int num, int index) {
        return num | (1 << index);
    }

    static boolean isSet(int num, int index) {
        return (num & (1 << index)) != 0;
    }

    static long possibleWays(
            char[][] board,
            int rowPlacing,
            int colPlacing,
            int diaLeftPlacing,
            int diaRightPlacing,
            int remaining,
            int index
    ) {
        if (remaining == 0) return 1L;
        if (index >= board.length * board.length) {
            return 0L;
        }

        int row = index / board.length;
        int col = index % board.length;

        long possible = 0L;

        // put if possible
        if (board[row][col] == '.') {
            int diaL = diaL(row, col);
            int diaR = diaR(row, col);
            boolean canPlace = !isSet(rowPlacing, row) && !isSet(colPlacing, col) &&
                    !isSet(diaLeftPlacing, diaL) && !isSet(diaRightPlacing, diaR);

            if (canPlace) {
                board[row][col] = '+';

                possible += possibleWays(
                        board,
                        set(rowPlacing, row),
                        set(colPlacing, col),
                        set(diaLeftPlacing, diaL),
                        set(diaRightPlacing, diaR),
                        remaining - 1,
                        index + 1
                );

                board[row][col] = '.';
            }
        }

        // skip
        possible += possibleWays(board, rowPlacing, colPlacing, diaLeftPlacing, diaRightPlacing, remaining, index + 1);

        return possible;
    }
}
