import java.io.*;
import java.util.*;

public class Main
{
    static StringBuilder sb = new StringBuilder();
    static int[][] dp;
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new int[N+1];
        dp = new int[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            board[i] = Integer.parseInt(st.nextToken());
        }

        // DP 초기화
        for(int i = 1; i <= N; i++) {
            dp[i][i] = 1; // 길이가 1인 경우
        }

        for(int i = 1; i < N; i++) {
            if (board[i] == board[i+1]) {
                dp[i][i+1] = 1; // 길이가 2인 경우
            }
        }

        // 길이가 3 이상인 경우
        for(int len = 3; len <= N; len++) {
            for(int i = 1; i <= N - len + 1; i++) {
                int j = i + len - 1;
                if(board[i] == board[j] && dp[i+1][j-1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(dp[s][e]).append("\n");
        }

        System.out.println(sb);
    }
}
