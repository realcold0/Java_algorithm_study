import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K;
    static int[][] arr;
    static boolean[][] visited;
    static int cnt;
    static List<Integer> area = new ArrayList<>(); // 넓이 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for (int j = ly; j < ry; j++) {
                for (int k = lx; k < rx; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    cnt++;
                    BFS(i, j);
                }
            }
        }

        Collections.sort(area);

        bw.write(cnt + "\n");
        for (Integer i : area) {
            bw.write(i.toString() + " ");
        }
        bw.flush();
        bw.close();

    }

    static void BFS(int x, int y) {
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int tmp = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = poll[0] + dx[k];
                int ny = poll[1] + dy[k];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (arr[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        tmp++;
                    }
                }
            }
        }
        area.add(tmp);
    }
}
