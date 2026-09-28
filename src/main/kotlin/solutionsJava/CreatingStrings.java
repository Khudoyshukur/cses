import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class CreatingStrings {
    static String s;
    static Set<String> res = new LinkedHashSet<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        s = scan.nextLine().trim();

        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        generate(chars, new StringBuilder());

        System.out.println(res.size());
        System.out.println(String.join("\n", res));
    }

    static void generate(int[] state, StringBuilder path) {
        if (path.length() == s.length()) {
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < state.length; i++) {
            if (state[i] == 0) continue;

            state[i]--;
            path.append((char) (i + 'a'));

            generate(state, path);

            state[i]++;
            path.deleteCharAt(path.length() - 1);
        }
    }
}
