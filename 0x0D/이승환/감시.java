import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map2;
    static int n, m;
    static int min = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<int[]> cctv = new ArrayList<>();
        map = new int[n][m];
        map2 = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st2.nextToken());
                map[i][j] = tmp;
                if (tmp > 0 && tmp <= 5) {
                    cctv.add(new int[]{i, j});
                }
                if (tmp == 0) {
                    count++;
                }
            }
        }
        //cctv가 없다면
        if (cctv.size() == 0) {
            bw.write(String.valueOf(count));
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        for (int tmp = 0; tmp < (int) Math.pow(4, cctv.size()); tmp++) {
            //임시 맵을 만들어준다.
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map2[i][j] = map[i][j];
                }
            }
            int directionByTen = tmp;
            //cctv돌면서 하나씩 방향에따라서
            for (int i = 0; i < cctv.size(); i++) {
                int direction = directionByTen % 4;
                directionByTen = directionByTen / 4;
                int x = cctv.get(i)[0];
                int y = cctv.get(i)[1];
                switch (map[x][y]) {
                    case 1:
                        checkSight(x, y, direction);
                        break;
                    case 2:
                        checkSight(x, y, direction);
                        checkSight(x, y, direction + 2);
                        break;
                    case 3:
                        checkSight(x, y, direction);
                        checkSight(x, y, direction + 1);
                        break;
                    case 4:
                        checkSight(x, y, direction);
                        checkSight(x, y, direction + 1);
                        checkSight(x, y, direction + 2);
                        break;
                    case 5:
                        checkSight(x, y, direction);
                        checkSight(x, y, direction + 1);
                        checkSight(x, y, direction + 2);
                        checkSight(x, y, direction + 3);
                        break;
                }

            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map2[i][j] == 0) {
                        result += 1;
                    }
                }
            }
            min = Math.min(min, result);
        }

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void checkSight(int x, int y, int direction) {
        //3에서 +1했을 수도 있으니
        direction %= 4;
        while (true) {
            x += dx[direction];
            y += dy[direction];

            //나가거나 벽 만나면
            if (x < 0 || x >= n || y < 0 || y >= m || map2[x][y] == 6) {
                return;
            }
            //카메라 라면
            if (x > 0 && x < n && y > 0 && y < m && map2[x][y] > 0 && map2[x][y] < 6) {
                continue;
            }
            map2[x][y] = 7;
        }
    }

    public static int pow(int n, int x) {
        int result = 1;
        for (int i = 0; i < x; i++) {
            result *= n;
        }
        return result;
    }
}
