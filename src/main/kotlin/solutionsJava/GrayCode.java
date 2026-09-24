import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class GrayCode {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = 1 << n; // 2^n

        for (int i = 0; i < total; i++) {
            int g = i ^ (i >>> 1);

            // Append n bits from MSB to LSB
            for (int bit = n - 1; bit >= 0; bit--) {
                int b = (g >>> bit) & 1;
                bw.write(b == 1 ? '1' : '0');
            }
            bw.newLine();
        }
        bw.flush();
    }
}
