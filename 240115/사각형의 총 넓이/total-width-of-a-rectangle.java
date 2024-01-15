import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static Square[] squares;

    public static void main(String[] args) throws IOException {
        input();
        int answer = 0;
        for (Square s : squares) {
            answer += s.getArea();
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                answer -= squares[i].intersectionArea(squares[j]);
            }
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        squares = new Square[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            squares[i] = new Square(l, t, r, b);
        }
    }

    static class Square {
        public int[] lt, rb;

        Square (int left, int top, int right, int bottom) {
            this.lt = new int[] {left, top};
            this.rb = new int[] {right, bottom};
        }

        Square (int[] lt, int[] rb) {
            this.lt = lt;
            this.rb = rb;
        }

        public int getArea() {
            return (rb[0] - lt[0]) * (lt[1] - rb[1]);
        }

        public int intersectionArea(Square square) {
            int[] interLt = new int[2];
            int[] interRb = new int[2];
            interLt[0] = Math.max(lt[0], square.lt[0]);
            interLt[1] = Math.min(lt[1], square.lt[1]);
            interRb[0] = Math.min(rb[0], square.rb[0]);
            interRb[1] = Math.max(rb[1], square.rb[1]);

            // System.out.println(Arrays.toString(interLt));
            // System.out.println(Arrays.toString(interRb));

            if (interLt[0] < interRb[0] && interLt[1] > interRb[1]) {
                Square intersection = new Square(interLt, interRb);
                return intersection.getArea();
            }
            return 0;
        }
    }
}