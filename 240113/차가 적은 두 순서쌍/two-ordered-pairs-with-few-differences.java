import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int n;
    public static int[] nums;

    public static void main(String[] args) throws IOException{
        input();
        Arrays.sort(nums);
        int[] gaps = getGaps();
        System.out.println(minSum(gaps));
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static int[] getGaps() {
        int[] gaps = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            gaps[i] = nums[i + 1] - nums[i];
        }
        return gaps;
    }

    private static int minSum(int[] gaps) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (j - i == 1) continue;
                result = Math.min(result, gaps[i] + gaps[j]);
            }
        }
        return result;
    }
}