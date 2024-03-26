import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static Weather answer;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            CustomDate date = new CustomDate(st.nextToken());
            String dayOfWeek = st.nextToken();
            String type = st.nextToken();
            if (type.equals("Rain")) {
                if (answer == null) {
                    answer = new Weather(date, dayOfWeek, type);
                }
                if (answer.date.compareTo(date) > 0) {
                    answer = new Weather(date, dayOfWeek, type);
                }
            }
        }
        System.out.println(answer);
    }

    static class Weather {
        public CustomDate date;
        public String dayOfWeek;
        public String type;

        public Weather(CustomDate date, String dayOfWeek, String type) {
            this.date = date;
            this.dayOfWeek = dayOfWeek;
            this.type = type;
        }

        @Override
        public String toString() {
            return date.ymd + " " + dayOfWeek + " " + type;
        }
    }

    static class CustomDate implements Comparable<CustomDate> {
        public int year;
        public int month;
        public int day;
        public String ymd;


        public CustomDate(String ymd) {
            this.ymd = ymd;
            StringTokenizer st = new StringTokenizer(ymd, "-");
            this.year = Integer.parseInt(st.nextToken());
            this.month = Integer.parseInt(st.nextToken());
            this.day= Integer.parseInt(st.nextToken());
        }

        @Override
        public int compareTo(CustomDate other) {
            if (other.year != year) {
                return year - other.year;
            }
            if (other.month != month) {
                return month - other.month;
            }
            return day - other.day;
        }
    }
}