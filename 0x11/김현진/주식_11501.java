import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long ans = 0;
            int max = 0;

            for (int j = N-1; j >= 0; j--) {
                if (arr[j] > max) {
                    max = arr[j];
                } else {
                    ans += (max - arr[j]);
                }
            }
            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
