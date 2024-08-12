import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int[] oper;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        oper = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st2.nextToken());
        }

        dfs(1, arr[0]);

        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int index, int result) {
        if (index == n) {
            min = Math.min(result, min);
            max = Math.max(result, max);
        }

        for (int i = 0; i < 4; i++) {
            int tmp = oper[i];
            if (tmp > 0) {
                oper[i]--;
                switch (i) {
                    case 0:
                        dfs(index + 1, result + arr[index]);
                        break;
                    case 1:
                        dfs(index + 1, result - arr[index]);
                        break;
                    case 2:
                        dfs(index + 1, result * arr[index]);
                        break;
                    case 3:
                        dfs(index + 1, result / arr[index]);
                        break;
                }
                oper[i]++;
            }

        }
    }
}
