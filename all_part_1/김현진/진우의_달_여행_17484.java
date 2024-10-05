import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ans = Integer.MAX_VALUE;
    static int n, m;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                DFS(0, i, arr[0][i], j);
            }
        }
        System.out.println(ans);
    }

    static void DFS(int x, int y, int sum, int dir) {
        if (x == n - 1) {
            ans = Math.min(ans, sum);
            return;
        }

        int[][] dxy = {{1, 0}, {1, -1}, {1, 1}};

        for (int i = 0; i < 3; i++) {
            if (dir == i) continue; // 같은 방향 연속 불가
            int nx = x + dxy[i][0];
            int ny = y + dxy[i][1];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            DFS(nx, ny, sum + arr[nx][ny], i);
        }
    }
}
