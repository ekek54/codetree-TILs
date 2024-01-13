import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int n;
    public static String input;

    public static void main(String[] args) throws IOException {
        input();
        int l = -1;
        int r = -1;
        Map<Character, Integer> charCounter = new HashMap<>();
        int answer = 0;
        while (r < input.length()) {
            answer = Math.max(answer, r - l);
            // System.out.println(charCounter);
            // System.out.println(l);
            // System.out.println(r);
            if (r == input.length() - 1) break;
            char nxt = input.charAt(++r);
            if (charCounter.containsKey(nxt)) {
                charCounter.put(nxt, charCounter.get(nxt) + 1);
            } else {
                charCounter.put(nxt, 1);
                while (charCounter.size() > n) {
                    char removed = input.charAt(++l);
                    charCounter.put(removed, charCounter.get(removed) - 1);
                    if (charCounter.get(removed) == 0) {
                        charCounter.remove(removed);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        input = br.readLine();
    }
}