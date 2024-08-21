import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            /**
             * 주식 하나를 산다.
             * 원하는 만큼 가지고 있는 주식을 판다.
             * 아무것도 안한다.
             */
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = arr[n - 1];
            long answer = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] > max) max = arr[i];
                else {
                    answer += max - arr[i];
                }
            }
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
