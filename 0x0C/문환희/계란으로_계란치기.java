import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계란으로_계란치기 {
    static int N;
    static int[] d;
    static int[] weight;
    static int answer = 0;

    static void backtrack(int L) {
        if (L == N) {
            int broken = 0;
            for (int i = 0; i < N; i++) {
                if (d[i] <= 0) {
                    broken++;
                }
            }
            answer = Math.max(answer, broken);
            return;
        }

        if (d[L] <= 0) {
            backtrack(L + 1);
            return;
        }

        boolean hit = false;
        for (int i = 0; i < N; i++) {
            if (i == L || d[i] <= 0) continue;
            hit = true;
            d[L] -= weight[i];
            d[i] -= weight[L];

            backtrack(L + 1);

            d[L] += weight[i];
            d[i] += weight[L];
        }

        if (!hit) {
            backtrack(L + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        d = new int[N];
        weight = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0);
        System.out.println(answer);
    }
}
