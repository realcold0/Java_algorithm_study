import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int start = 0;
        int end = n - 1;
        long sum = 0;
        long ans1 = arr[start];
        long ans2 = arr[end];

        while (start < end) {

            sum = arr[start] + arr[end];

            if (Math.abs(sum) < Math.abs(ans1 + ans2)) {
                ans1 = arr[start];
                ans2 = arr[end];
            }

            if (sum == 0) { // 0이랑 같으면 바로 리턴
                break;
            } else if (sum > 0) {
                end--;
            } else { // sum < 0
                start++;
            }
        }
        bw.write(ans1 + " " + ans2);
        bw.flush();
        bw.close();
    }
}
