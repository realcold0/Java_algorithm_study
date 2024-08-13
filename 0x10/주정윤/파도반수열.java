
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[101]; // P(n)을 저장할 DP 배열

        // 초기값 설정
        dp[1] = dp[2] = dp[3] = 1;

        // P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9
        // 2, 2, 3, 4, 5, 7, 9
        // 점화식을 이용해 DP 테이블 채우기
        for (int i = 4; i <= 100; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }

        // 테스트 케이스에 대한 출력
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }

    }
}
