import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][] dp = new long[n][n];

        dp[0][0] = 1;
        //각자 칸에서 오,아래만큼 이동한 위치에 자기 dp값 더하기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(dp[i][j] == 0) {continue;}
                int go = map[i][j];
                if(go == 0) {continue;}
                if(i+go <n){
                    dp[i+go][j] += dp[i][j];
                }
                if(j+go <n){
                    dp[i][j+go] += dp[i][j];

                }
            }
        }
        bw.write(dp[n-1][n-1] + "\n");
        bw.flush();
    }
}
