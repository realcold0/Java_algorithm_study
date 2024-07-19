
import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class 소문난_칠공주 {
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static int ans = 0;
    static HashSet<ArrayList<Point>> hs = new HashSet<>();

    // Point 클래스 정의
    static class Point implements Comparable<Point> {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        @Override
        public int compareTo(Point o) {
            return x - o.x;
        }
    }

    // cnt = 이다솜파 수
    static void backtrack(char[][] map, ArrayList<Point> curr, boolean[][] visited, int cnt, int x, int y) {
        if (0 <= x && x < 5 && 0 <= y && y < 5 && !visited[y][x]) {
            // break case
            if (curr.size() == 7 && cnt >= 4) {
                Collections.sort(curr);
                hs.add(new ArrayList<>(curr));
                ans++;
                return;
            }
            // curr에 값 넣기
            curr.add(new Point(x, y));
            if (map[y][x] == 'S') {
                cnt++;
            }
            visited[y][x] = true;
            // recur
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                backtrack(map, curr, visited, cnt, nx, ny);
            }
            visited[y][x] = false;
            curr.remove(curr.size() - 1);
            if (map[y][x] == 'S') {
                cnt++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[][] map = new char[5][5];
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        boolean[][] visited = new boolean[5][5];
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                backtrack(map, new ArrayList<>(), visited, cnt, i, j);
            }
        }

        System.out.println(hs.size());
    }
}