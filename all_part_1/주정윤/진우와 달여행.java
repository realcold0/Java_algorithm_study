import java.io.*;
import java.util.*;

public class 진우와 달여행 {
    static int[][] map;
    static int[][][] dp;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for (int j = 0; j < m; j++) {
            dp[0][j][0] = dp[0][j][1] = dp[0][j][2] = map[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j > 0) {
                    dp[i][j][0] = Math.min(dp[i][j][0], dp[i - 1][j - 1][1] + map[i][j]);
                }
                dp[i][j][1] = Math.min(dp[i][j][1], dp[i - 1][j][0] + map[i][j]);
                if (j < m - 1) {
                    dp[i][j][2] = Math.min(dp[i][j][2], dp[i - 1][j + 1][1] + map[i][j]);
                }
            }
        }

        int minFuel = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minFuel = Math.min(minFuel, Math.min(dp[n - 1][j][0], Math.min(dp[n - 1][j][1], dp[n - 1][j][2])));
        }

        System.out.println(minFuel);
    }
}
