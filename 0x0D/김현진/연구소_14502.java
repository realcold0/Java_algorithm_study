import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] copyMap;
    static int n, m;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        walls(0);
        System.out.println(ans);
    }

    // 벽 세우기
    static void walls(int wall) {
        if (wall == 3) {
            virus();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    walls(wall + 1);
                    map[i][j] = 0;
                }
            }
        }

    }

    // 바이러스
    static void virus() {
        Queue<int[]> queue = new LinkedList<>();
        copyMap = new int[n][m]; // 벽이 다 세워질 때마다 virus 실행해야 하므로 초기화 용도

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
                if (copyMap[i][j] == 2) { // 바이러스
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && copyMap[nx][ny] == 0) {
                    copyMap[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        int tmp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    tmp++;
                }
            }
        }
        ans = Math.max(tmp, ans);
    }
}
