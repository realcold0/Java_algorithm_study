import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Line[] lines = new Line[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(lines);

        int x = lines[0].x;
        int y = lines[0].y;
        int len = 0;

        for (int i = 1; i < N; i++) {
            if (lines[i].x > y) { // 이전 선분과 겹치지 않는 경우
                len += y - x;
                x = lines[i].x;
                y = lines[i].y;
            } else if (lines[i].y > y) { // 겹치면서 현재 선분이 더 길 경우
                y = lines[i].y;
            }
        }

        len += y - x; // 마지막 선분 길이 더하기

        System.out.println(len);
    }

    static class Line implements Comparable<Line> {
        int x;
        int y;

        public Line(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Line o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
}
