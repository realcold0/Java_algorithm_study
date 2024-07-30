import java.io.*;
import java.util.*;

public class 감시 {
    static int N, M;
    static int[][] office;
    static List<int[]> cctvs = new ArrayList<>();
    static int minBlindSpot = Integer.MAX_VALUE;

    static int[][][] directions = {
        {},
        {{0}, {1}, {2}, {3}}, // 1번 CCTV
        {{0, 2}, {1, 3}},     // 2번 CCTV
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번 CCTV
        {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4번 CCTV
        {{0, 1, 2, 3}} // 5번 CCTV
    };

    static int[] dx = {0, 1, 0, -1}; // 동, 남, 서, 북
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        office = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] > 0 && office[i][j] < 6) {
                    cctvs.add(new int[]{i, j, office[i][j]});
                }
            }
        }

        dfs(0, office);
        bw.write(minBlindSpot + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int idx, int[][] map) {
        if (idx == cctvs.size()) {
            minBlindSpot = Math.min(minBlindSpot, countBlindSpot(map));
            return;
        }

        int[] cctv = cctvs.get(idx);
        int x = cctv[0], y = cctv[1], type = cctv[2];

        for (int[] dir : directions[type]) {
            int[][] tempMap = copyMap(map);
            for (int d : dir) {
                watch(tempMap, x, y, d);
            }
            dfs(idx + 1, tempMap);
        }
    }

    static void watch(int[][] map, int x, int y, int d) {
        int nx = x, ny = y;
        while (true) {
            nx += dx[d];
            ny += dy[d];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 6) break;
            if (map[nx][ny] == 0) map[nx][ny] = 7;
        }
    }

    static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
            }
        }
        return newMap;
    }

    static int countBlindSpot(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }
}
