import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] num;
    static int[] oper = new int[4]; // 연산자 배열
    static int Min = Integer.MAX_VALUE; // 최소값 초기화
    static int Max = Integer.MIN_VALUE; // 최대값 초기화

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        DFS(num[0], 1);

        System.out.println(Max);
        System.out.println(Min);
    }

    static void DFS(int n, int idx) {
        if (idx == N) { // 모든 숫자를 사용했으면
            Max = Math.max(Max, n);
            Min = Math.min(Min, n);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) { // 연산자가 남아있으면
                oper[i]--;
                switch (i) {
                    case 0: DFS(n + num[idx], idx + 1); break;
                    case 1: DFS(n - num[idx], idx + 1); break;
                    case 2: DFS(n * num[idx], idx + 1); break;
                    case 3: DFS(n / num[idx], idx + 1); break;
                }
                oper[i]++; // 연산자 복원
            }
        }
    }
}
