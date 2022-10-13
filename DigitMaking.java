package RedHat_Assingment;

import java.util.ArrayList;
import java.util.List;

public class DigitMaking {
    private static final String DIGITS = "123456789";

    public static ArrayList<String> sumTo(int target) {
        ArrayList<String> result = new ArrayList<>();
        generate(0, 0, target, new StringBuilder(), result);
        return result;
    }

    private static void generate(int start, int sum, int target, StringBuilder path, List<String> result) {
        if (start == DIGITS.length()) {
            if (sum == target) {
                result.add(path.toString());
            }
            return;
        }

        int len = path.length();
        int num = 0;
        for (int i = start; i < DIGITS.length(); i++) {
            num = 10 * num + DIGITS.charAt(i) - '0';

            if (start != 0) path.append('+');
            path.append(num);
            generate(i + 1, sum + num, target, path, result);
            path.setLength(len);

            path.append('-');
            path.append(num);
            generate(i + 1, sum - num, target, path, result);
            path.setLength(len);
        }
    }

    public static void main(String[] args) {
        test(100);
//        test(9);
    }

    public static void test(int target) {
        System.out.println(String.format("Sum to %d -----------------", target));
//        int count = 1;
        for (String s : sumTo(target)) {
            System.out.println( s);
        }
    }
}