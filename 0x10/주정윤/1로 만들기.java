
import java.io.*;

public class 1로 만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // dp 배열 생성
        int[] dp = new int[N + 1];

        // dp[1]은 0으로 초기화
        for (int i = 2; i <= N; i++) {
            // 기본적으로 -1 하는 경우를 고려
            dp[i] = dp[i - 1] + 1;

            // 2로 나누어 떨어질 때
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 3으로 나누어 떨어질 때
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        // 최종 결과 출력
        System.out.println(dp[N]);
    }
}

