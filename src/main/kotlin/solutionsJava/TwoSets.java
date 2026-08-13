import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoSets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long leftSum = 0L;
        long rightSum = 0L;
        List<Integer> leftNums = new ArrayList<>();
        List<Integer> rightNums = new ArrayList<>();

        for (int i = n; i >= 1; i--) {
            if (leftSum <= rightSum) {
                leftNums.add(i);
                leftSum += i;
            } else {
                rightNums.add(i);
                rightSum += i;
            }
        }

        if (leftSum != rightSum) {
            System.out.println("NO");
        } else {
            System.out.println("YES");

            System.out.println(leftNums.size());
            StringBuilder leftLine = new StringBuilder();
            for (int i = 0; i < leftNums.size(); i++) {
                if (i > 0) leftLine.append(" ");
                leftLine.append(leftNums.get(i));
            }
            System.out.println(leftLine);

            System.out.println(rightNums.size());
            StringBuilder rightLine = new StringBuilder();
            for (int i = 0; i < rightNums.size(); i++) {
                if (i > 0) rightLine.append(" ");
                rightLine.append(rightNums.get(i));
            }
            System.out.println(rightLine);
        }
    }
}
