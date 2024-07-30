import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int n;
    static int m;
    static ArrayList<Point> list;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max = Integer.MIN_VALUE;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        list = new ArrayList<>();
        ArrayList<Point> viruses = new ArrayList<>(); //바이러스는 최대 10개

        //map에서 3개를 고름 64 * 63 * 62
        //for문 3번 8 * 8 * 10
        //1억 5천
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st2.nextToken());
                if (tmp == 0) {
                    list.add(new Point(i, j));
                } else if (tmp == 2) {
                    viruses.add(new Point(i, j));
                }
                map[i][j] = tmp;
            }
        }
        dfs(viruses);

        max -= 3; //블럭 꽃은거 빼기

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(List<Point> viruses) {
        for (int i = 0; i < list.size() - 2; i++) {
            for (int j = i + 1; j < list.size() - 1; j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    //1로 바꾸고 bfs
                    //갯수 샌다.
                    //다시 0으로 바꾼다.
                    Point first = list.get(i);
                    Point sec = list.get(j);
                    Point third = list.get(k);

                    map[first.x][first.y] = map[sec.x][sec.y] = map[third.x][third.y] = 1;
                    int result = list.size();
                    for (Point point : viruses) {
                        result = bfs(point, result);
                    }
                    max = Math.max(result, max);
                    //다시 돌려줌
                    //바이러스 퍼진데
                    for (Point point : list) {
                        map[point.x][point.y] = 0;
                    }
                    //블럭 세웠던데
                    map[first.x][first.y] = map[sec.x][sec.y] = map[third.x][third.y] = 0;
                }
            }
        }
    }

    public static int bfs(Point start, int result) {
        Deque<Point> deque = new ArrayDeque<>();
        deque.add(start);
        while (!deque.isEmpty()) {
            Point current = deque.poll();
            for (int i = 0; i < 4; i++) {
                Point next = new Point(current.x + dx[i], current.y + dy[i]);
                if (next.x >= 0 && next.x < n && next.y >= 0 && next.y < m && map[next.x][next.y] == 0) {
                    map[next.x][next.y] = 2;
                    result--;
                    deque.add(next);
                }
            }
        }

        return result;
    }
}
