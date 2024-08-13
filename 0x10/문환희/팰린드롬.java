import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[][] dp = new int[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if(i < n - 1) {
                if(arr[i] == arr[i+1]) {
                    dp[i][i+1] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 2 - i; j++) {
                dp[j][j + i + 2] = (arr[j] == arr[j + i + 2]) && (dp[j + 1][j + i + 1] == 1) ? 1 : 0;
            }
        }

        for (int i = 0; i < tc; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st1.nextToken());
            int e = Integer.parseInt(st1.nextToken());

            bw.write(dp[s-1][e-1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
