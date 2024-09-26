import java.io.*;

public class 점프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1) {
                    break;
                }
                int jump = board[i][j];
                if (i + jump < n) {
                    dp[i + jump][j] += dp[i][j];
                }
                if (j + jump < n) {
                    dp[i][j + jump] += dp[i][j];
                }
            }
        }

        bw.write(dp[n - 1][n - 1] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
