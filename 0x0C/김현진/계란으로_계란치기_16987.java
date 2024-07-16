import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 내구도
            arr[i][1] = Integer.parseInt(st.nextToken()); // 무게
        }

        solve(0);
        System.out.println(ans);
    }

    static void solve(int pos) {
        if (pos == N) {
            int tmp = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][0] <= 0) {
                    tmp++;
                }
                ans = Math.max(ans, tmp);
            }
            return;
        }

        if (arr[pos][0] <= 0) { // 현재 계란이 깨져있을 경우
            solve(pos + 1);
            return;
        }

        boolean flag = true;
        for (int i = 0; i < N; i++) { // 다른 계란이 모두 깨져있는지 확인
            if (i != pos && arr[i][0] > 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            solve(pos + 1);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i != pos && arr[i][0] > 0) { // 깨지지 않은 다른 계란이 있을 경우
                arr[pos][0] -= arr[i][1];
                arr[i][0] -= arr[pos][1];

                solve(pos + 1);

                arr[pos][0] += arr[i][1];
                arr[i][0] += arr[pos][1];

            }
        }
    }
}
