import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 기존 점수 개수
        int score = Integer.parseInt(st.nextToken()); // 새로운 점수
        int P = Integer.parseInt(st.nextToken()); // 랭크에 올라갈 수 있는 개수

        if (N == 0) {
            System.out.println(1);
            return;
        }

        Integer[] rank = new Integer[N];
        int ans = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            rank[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(rank, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            if (rank[i] > score) {
                ans++;
            } else {
                break;
            }
        }

        if (ans > P || (N == P && rank[N - 1] >= score)) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
