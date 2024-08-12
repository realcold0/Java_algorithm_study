import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) { // 배열에 값 입력
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0'; // char -> int
                dist[i][j] = -1; // -1로 초기화 (방문 x)
            }
        }

        BFS(0,0);
        System.out.println(dist[N-1][M-1]);
    }

    static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        queue.offer(new int[] {x, y});
        dist[x][y] = 1; // 시작점의 거리를 1로 설정

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (arr[nx][ny] == 1 && dist[nx][ny] == -1) {
                        queue.offer(new int[] {nx, ny});
                        dist[nx][ny] = dist[poll[0]][poll[1]] + 1;
                    }

                }
            }
        }
    }
}
