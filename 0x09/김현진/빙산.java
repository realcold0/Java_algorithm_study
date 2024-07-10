import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] melting; // 빙하 녹을 때 계산 용도
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N][M];
        melting = new int[N][M];
        visited = new boolean[N][M];
        int time = 0; // 걸린 시간

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            int cnt = 0; // 빙산의 개수
            for (int i = 0; i < N; i++) { // 빙산 개수 세기
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && arr[i][j] != 0) {
                        BFS(i,j);
                        cnt++;
                    }
                }
            }

            if (cnt > 1) {
                System.out.println(time);
                break;
            } else if (cnt == 0) { // 다 녹았을 경우
                System.out.println(0);
                break;
            }

            calMelt();
            time++;

        }
    }

    static void BFS(int x, int y) { // 빙산 개수 세는 함수
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (arr[nx][ny] != 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    static void calMelt() { // 녹는 정도를 계산에서 arr에서 빼기

    }
}
