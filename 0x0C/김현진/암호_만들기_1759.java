import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[] arr;
    static char[] bt;
    static int L, C;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        bt = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr); // 사전순으로 정렬

        solve(0, 0, 0, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void solve(int start, int pos, int checkG, int checkV) {
        if (pos == L) {
            if (checkG >= 1 && checkV >= 2) {
                sb.append(bt).append('\n');
            }
            return;
        }

        for (int i = start; i < C; i++) {
            bt[pos] = arr[i];
            if (checkGV(arr[i])) { // 모음
                solve(i + 1, pos + 1, checkG + 1, checkV);
            } else { // 자음
                solve(i + 1, pos + 1, checkG, checkV + 1);
            }
        }
    }

    static boolean checkGV(char c) { // 자음인지 모음인지 판별
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'; // 모음이면 return 1
    }
}

