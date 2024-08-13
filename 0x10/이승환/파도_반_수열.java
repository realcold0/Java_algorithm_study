import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[n + 10];
            dp[1] = dp[2] = dp[3] = 1;
            dp[4] = dp[5] = 2;
            dp[6] = 3;
            dp[7] = 4;
            dp[8] = 5;
            dp[9] = 7;
            dp[10] = 9;

            if (n <= 10) {
                bw.write(dp[n] + "\n");
            } else {
                for (int j = 11; j <= n; j++) {
                    dp[j] = dp[j - 2] + dp[j - 3];
                }
                bw.write(dp[n] + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
