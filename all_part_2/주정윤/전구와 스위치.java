import java.io.*;

public class 전구와 스위치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[] current = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();

        int result1 = solve(current.clone(), target, n, false);
        int result2 = solve(current.clone(), target, n, true);

        int answer = Math.min(result1, result2);
        if (answer == Integer.MAX_VALUE) {
            bw.write("-1\n");
        } else {
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(char[] current, char[] target, int n, boolean firstSwitch) {
        int count = 0;
        if (firstSwitch) {
            switchLamp(current, 0);
            count++;
        }

        for (int i = 1; i < n; i++) {
            if (current[i - 1] != target[i - 1]) {
                switchLamp(current, i);
                count++;
            }
        }

        if (current[n - 1] != target[n - 1]) {
            return Integer.MAX_VALUE;
        }

        return count;
    }

    public static void switchLamp(char[] current, int index) {
        for (int i = index; i <= index + 1 && i < current.length; i++) {
            current[i] = current[i] == '0' ? '1' : '0';
        }
    }
}
