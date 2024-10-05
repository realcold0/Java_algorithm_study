import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[n][n];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n-1 && j == n-1) break; // 타겟 지점
                int jump = (int) arr[i][j];
                if (i + jump <= n - 1) dp[i+jump][j] += dp[i][j];
                if (j + jump <= n - 1) dp[i][j+jump] += dp[i][j];
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}
