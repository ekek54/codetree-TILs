import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String A = br.readLine();
        int answer = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != '(') continue;
            for (int j = i + 1; j < A.length(); j++) {
                if (A.charAt(j) == ')') answer++;
            }
        }
        System.out.println(answer);
    }
}