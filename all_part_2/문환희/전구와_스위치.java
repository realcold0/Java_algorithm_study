import java.io.*;

public class 전구와_스위치 {

    public static void toggle(int[] arr, int idx) {
        arr[idx] ^= 1;
        if (idx > 0) arr[idx - 1] ^= 1;
        if (idx < arr.length - 1) arr[idx + 1] ^= 1;
    }

    public static int solve(int[] now, int[] goal, int n, boolean pressFirst) {
        int[] bulbs = now.clone();
        int pressCount = 0;

        if (pressFirst) {
            toggle(bulbs, 0);
            pressCount++;
        }

        for (int i = 1; i < n; i++) {
            if (bulbs[i - 1] != goal[i - 1]) {
                toggle(bulbs, i);
                pressCount++;
            }
        }

        if (bulbs[n - 1] != goal[n - 1]) {
            return Integer.MAX_VALUE;
        }

        return pressCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] now = new int[n];
        int[] goal = new int[n];

        String nowString = br.readLine();
        String goalString = br.readLine();

        for (int i = 0; i < n; i++) {
            now[i] = nowString.charAt(i) - '0';
            goal[i] = goalString.charAt(i) - '0';
        }

        int resultWithoutFirst = solve(now, goal, n, false);
        int resultWithFirst = solve(now, goal, n, true);

        int answer = Math.min(resultWithoutFirst, resultWithFirst);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
