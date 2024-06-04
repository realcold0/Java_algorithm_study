import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int cnt = 0;
        int start = 0;
        int end = n - 1; // 투포인터 알고리즘을 위한 시작과 끝
        int sum = 0; // 현재 합

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 배열에 수 넣기
        }

        int x = Integer.parseInt(br.readLine()); // 타겟

        Arrays.sort(arr); // 정렬

        while (start < end) { // start가 end보다 작을 때까지
            sum = arr[start] + arr[end];
            if (sum == x) {
                cnt++;
                start++;
                end--;
            } else if (sum < x) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(cnt);
    }
}