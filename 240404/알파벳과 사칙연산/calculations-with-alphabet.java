import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        String formular = br.readLine();
        int cur = 4;
        for (int i = 1; i < formular.length(); i ++) {
            if (formular.charAt(i) == '+') {
                cur += 4;
                continue;
            }
            if (formular.charAt(i) == '-') {
                cur -= 1;
                continue;
            }
            if (formular.charAt(i) == '*') {
                if (cur >= 0) {
                    cur *= 4;
                    continue;
                } else {
                    cur *= 1;
                    continue;
                }
            } else continue;
        }
        System.out.println(cur);
    }
}