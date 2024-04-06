import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static List<Dot> dots = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Dot dot = new Dot(x, y);
            dots.add(dot);
        }
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int cnt) {
        if (cnt == m) {
            answer = Math.min(answer, minDs());
            // System.out.println(stack);
            // System.out.println(answer);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && stack.peek() >= i) continue;
            stack.push(i);
            dfs(cnt + 1);
            stack.pop();
        }
    }

    private static int minDs() {
        int result = Integer.MAX_VALUE;
        for(int i: stack) {
            for (int j: stack) {
                if(i == j) continue;
                Dot a = dots.get(i);
                Dot b = dots.get(j);
                result = Math.min(result, a.dsFrom(b));
            }
        }
        return result;
    }

    static class Dot{
        public int x, y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        //ds: DistanceSquare
        public int dsFrom(Dot d) {
            return (int)Math.pow(x - d.x, 2) + (int)Math.pow(y - d.y, 2);
        }

        @Override
        public String toString() {
            return x + ", " + y;
        }
    }
}