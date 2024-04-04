import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> nums = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
            if (i % 2 == 0) {
                nums.sort(Integer::compareTo);
                sb.append(nums.get(i / 2)).append(' ');
            }
        }
        System.out.println(sb);
    }
}