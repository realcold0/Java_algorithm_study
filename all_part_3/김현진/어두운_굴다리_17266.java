import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 굴다리 길이
        M = Integer.parseInt(br.readLine()); // 가로등 개수
        int ans = 0; // 가로등 최소 높이

        arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (isPossible(mid)) {// 모든 길 비출 수 있으면
                ans = mid;
                end = mid - 1;
            } else { // 비출 수 없으면
                start = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static boolean isPossible(int mid) {
        if (arr[0] > mid) return false;

        if (N - arr[M-1] > mid) return false; // 마지막 가로등부터 끝까지의 거리가 높이보다 큰 지 확인

        for (int i = 1; i < M; i++) {
            if (arr[i] - arr[i-1] > mid * 2) return false;
        }

        return true;
    }
}
