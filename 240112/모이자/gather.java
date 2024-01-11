import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int n;
    public static int[] A;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int distSum = 0;
            for (int j = 0; j < n; j++) {
                distSum += A[j] * Math.abs(i - j);
            }
            // System.out.println(distSum);
            answer = Math.min(answer, distSum);
        }
        System.out.println(answer);
    }
}