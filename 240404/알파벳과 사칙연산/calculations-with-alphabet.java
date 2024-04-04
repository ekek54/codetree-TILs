import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer = Integer.MIN_VALUE;
    private static int NUMS_SIZE = 6;
    private static Stack<Integer> nums = new Stack<>();
    private static String formular = "";

    public static void main(String[] args) throws IOException{
        formular = br.readLine();
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int cnt) {
        if (cnt == NUMS_SIZE) {
            answer = Math.max(answer, calcForm());
            return;
        }

        for (int i = 1; i <= 4; i++) {
            nums.add(i);
            dfs(cnt + 1);
            nums.pop();
        }
    }

    private static int calcForm() {
        int cur = nums.get(idxByAlpha(formular.charAt(0)));
        for (int i = 1; i < formular.length() - 1; i += 2) {
            char operator = formular.charAt(i);
            char operand = formular.charAt(i + 1);
            int operandNum = nums.get(idxByAlpha(operand));
            if (operator == '+') {
                cur += operandNum;
                continue;
            }
            if (operator == '-') {
                cur -= operandNum;
                continue;
            }
            if (operator == '*') {
                cur *= operandNum;
                continue;
            }
        }
        return cur;
    }

    private static int idxByAlpha(char alpha) {
        return (int)(alpha - 'a');
    }
}