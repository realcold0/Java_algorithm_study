import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        System.out.println(solve(A, B, C));
    }

    static long solve(int A, int B, int C) {
        if (B == 0) { // B가 0이면 거듭제곱값은 항상 1
            if (C == 1) {
                return 0;
            } else {
                return 1;
            }
        }
        long half = solve(A, B/2, C); // 분할 정복
        long res = (half * half) % C;

        if (B % 2 == 1) { // 홀수면 한번 더 곱해줌
            res = (res * A) % C;
        }
        return res;
    }
}
