import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            Student s = new Student(h, w, i + 1);
            students.add(s);
        }
        Collections.sort(students);
        for (Student s: students) {
            System.out.println(s);
        }
    }

    static class Student implements Comparable{
        private int height;
        private int weight;
        private int number;

        public Student(int height, int weight, int number) {
            this.height = height;
            this.weight = weight;
            this.number = number;
        }

        public int getHeight() {
            return height;
        }

        public int getWeight() {
            return weight;
        }

        public int getNumber() {
            return number;
        }

        @Override
        public int compareTo(Object o) {
            Student s = (Student) o;
            if (height == s.height) {
                return weight - s.weight;
            }
            return height - s.height;
        }

        @Override
        public String toString() {
            return height + " " + weight + " " + number;
        }
    }
}