import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];
        int maxSquareLength = 0;

        for (int i = 1; i <= N; i++) {
            String row = br.readLine();
            for (int j = 1; j <= M; j++) {
                board[i][j] = row.charAt(j-1) - '0';
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    maxSquareLength = Math.max(maxSquareLength, dp[i][j]);
                }
            }
        }

        int maxSquareArea = maxSquareLength * maxSquareLength;
        System.out.println(maxSquareArea);
    }
}
