import java.io.*;
import java.util.*;

public class 점프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dp[0][0] = 1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(dp[i][j] >= 1 && map[i][j] != 0) {

                    if(j + map[i][j] < n) {
                        dp[i][j + map[i][j]] += dp[i][j];
                    }
                    if(i + map[i][j] < n) {
                        dp[i + map[i][j]][j] += dp[i][j];
                    }
                }
            }
        }

        bw.write(dp[n - 1][n - 1] + "\n");

        bw.flush();
        bw.close();
        br.close();

    }
}