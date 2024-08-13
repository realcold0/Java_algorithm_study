
import java.io.*;
import java.util.*;

public class 가장 긴 증가하는 부분 수열 {
    // 가장 긴 증가하는 부분 수열
    // 배열의 순서를 유지한채로 증가하는 '부분 수열'

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // DP 배열을 모두 1로 초기화
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        int maxLen = 1;  // 가장 긴 부분 수열의 길이

        // DP를 사용해 가장 긴 증가하는 부분 수열의 길이를 계산
        // arr 10 20 30 15 25 50
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        System.out.println(maxLen);
    }
}
