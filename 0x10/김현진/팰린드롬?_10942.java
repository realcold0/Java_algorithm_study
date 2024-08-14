import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        boolean[][] dp = new boolean[N+1][N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;  // 길이가 1인 경우 항상 팰린드롬
        }

        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i+1]) {
                dp[i][i+1] = true;  // 길이가 2인 경우
            }
        }

        for (int i = 3; i <= N; i++) { // 길이가 3 이상인 경우
            for (int j = 1; j <= N-i+1; j++) { // 시작 인덱스
                if (arr[j] == arr[i+j-1] && dp[j+1][i+j-2]) { // 처음과 끝이 같고 안쪽이 펠린드롬일 경우
                    dp[j][i+j-1] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if (dp[S][E]) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
