import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 진우와_달여행 {
    public  static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n][m];
        int[][][] dp = new int[n][m][3];
        int[][] ways = {{-1, -1}, {-1, 0}, {-1, +1}};


        for(int i = 0; i < n; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int j = 0; j < m; j++) {
            dp[0][j][0] = dp[0][j][1] = dp[0][j][2] = map[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    int prevJ = j + ways[k][1];
                    if (prevJ >= 0 && prevJ < m) {
                        dp[i][j][k] = map[i][j] + Math.min(dp[i - 1][prevJ][(k + 1) % 3], dp[i - 1][prevJ][(k + 2) % 3]);
                    } else {
                        dp[i][j][k] = Integer.MAX_VALUE;
                    }
                }
            }
        }

        int minFuel = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < 3; k++) {
                minFuel = Math.min(minFuel, dp[n - 1][j][k]);
            }
        }

        System.out.println(minFuel);


        br.close();
    }
}
