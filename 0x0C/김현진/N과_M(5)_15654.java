import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] bt = new int[10]; // 백트래킹용
    static int[] arr; // st로 숫자 담기
    static boolean[] check = new boolean[10]; // 숫자 사용했는지 확인
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 오름차순 정렬이므로 미리 정렬해주기

        solve(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
    static void solve(int pos) {
        if (pos == M) {
            for (int i = 0; i < M; i++) {
                sb.append(bt[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                bt[pos] = arr[i];
                check[i] = true;
                solve(pos+1);
                check[i] = false;
            }
        }
    }
}
