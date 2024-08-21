
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());

        // dp[i][j] : s[i]부터 s[j]까지가 팰린드롬인지 여부를 저장
        boolean[][] dp = new boolean[n][n];

        // 초기값 설정
        for (int i = 0; i < n; i++) {
            dp[i][i] = true; // 길이가 1인 문자열은 항상 팰린드롬
        }
        // 점화식 적용
        for (int length = 1; length < n; length++) { // 부분 문자열의 길이 - 1
            for (int i = 0; i + length < n; i++) {
                int j = i + length;
                if (s[i] == s[j]) {
                    if (length == 1) {
                        dp[i][j] = true; // 길이가 2인 문자열 처리
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true; // 길이가 3 이상인 문자열 처리
                    }
                }
            }
        }

        // 질문 받기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            if (dp[start][end]) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
