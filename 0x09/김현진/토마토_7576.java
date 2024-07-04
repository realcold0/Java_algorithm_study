import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] dist;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    q.offer(new int[]{i, j}); // 익은 토마토면 queue에 넣음
                    dist[i][j] = 0; // 익은 토마토는 거리 0으로 설정
                } else {
                    dist[i][j] = -1; // 익지 않은 토마토와 빈 칸을 -1로 초기화
                }
            }
        }

        BFS();

        int max = 0;
        for (int i = 0; i < N; i++) { // 익지 않은 토마토가 있는지 확인
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0 && dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                if (dist[i][j] > max) {
                    max = dist[i][j];
                }
            }
        }
        System.out.println(max);
    }

    static void BFS() {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (dist[nx][ny] == -1 && arr[nx][ny] == 0) {
                        q.offer(new int[]{nx, ny});
                        dist[nx][ny] = dist[poll[0]][poll[1]] + 1;
                        arr[nx][ny] = 1; // 토마토를 익힘
                    }
                }
            }
        }
    }
}
