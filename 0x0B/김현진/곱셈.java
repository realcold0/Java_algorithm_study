import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(solve(A, B, C));
    }
    static long solve(long A, long B, long C) {
        if (B == 0) {
            return 1;
        }
        long half = solve(A, B/2, C); // 분할 정복
        long res = (half * half) % C;

        if (B % 2 == 1) { // B가 홀수일 경우
            res = (res * A) % C;
        }
        return res;
    }
}
