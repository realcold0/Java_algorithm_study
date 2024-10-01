import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int[] dx = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][][] dp = new int[N][M][3];  // dp[i][j][k]: i행 j열에 도달하는데 k방향으로 도착한 최소 연료
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;  // 초기값을 매우 큰 값으로 설정
                }
            }
        }
    

        // 첫 번째 행의 dp 값 초기화
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                dp[0][j][k] = map[0][j];
            }
        }

        // DP 실행
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 3; k++) {  // 이전 행의 세 방향에 대해 계산
                    int prevCol = j + dx[k];
                    if (prevCol < 0 || prevCol >= M) continue;  // 범위를 벗어난 경우 패스
                    for (int dir = 0; dir < 3; dir++) {
                        if (dir == k) continue;  // 같은 방향으로는 이동할 수 없으므로 패스
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][prevCol][dir] + map[i][j]);
                    }
                }
            }
        }

        // 마지막 행에서의 최소 연료 찾기
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                result = Math.min(result, dp[N - 1][j][k]);
            }
        }

        System.out.println(result);
    }
}
