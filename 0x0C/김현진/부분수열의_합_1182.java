import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int ans = 0;
    static int N, S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, 0);

        if (S == 0) { // S == 0 이어서 아무것도 더하지 않았을 경우(공집합)
            ans--;
        }

        System.out.println(ans);
    }

    static void solve(int sum, int idx) {
        if (idx == N) {
            if (sum == S) {
                ans++;
            }
            return;
        }

        solve(sum, idx + 1); // 자기 자신 포함
        solve(sum + arr[idx], idx + 1); // 자기 자신 포함하지 않을 경우
    }
}
