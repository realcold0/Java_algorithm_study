import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속으로 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int[] count = new int[d + 1]; // 쿠폰 초밥까지 생각해서 +1

        for (int i = 0; i < k; i++) {
            if (count[arr[i]] == 0) { // 새로 먹는 초밥이면 +1
                cnt++;
            }
            count[arr[i]]++;
        }
        int max = cnt;

        for (int i = 0; i < n; i++) {
            if (cnt >= max) {
                if (count[c] == 0) { // 쿠폰 초밥을 아직 안 먹었을 때
                    max = cnt + 1;
                } else {
                    max = cnt; // 쿠폰 초밥을 이미 먹었을 때
                }
            }

            // 첫 번째 초밥 제거
            count[arr[i]]--;
            if (count[arr[i]] == 0) {
                cnt--;
            }

            // 마지막 초밥 추가
            int addIndex = (i + k) % n;
            if (count[arr[addIndex]] == 0) {
                cnt++;
            }
            count[arr[addIndex]]++;
        }

        System.out.println(max);
    }
}
