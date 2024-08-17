import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n + 1][n + 1];
        int input[] = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= n; j++) {
            int tmp = Integer.parseInt(st.nextToken());
            input[j] = tmp;
            for (int i = 1; i <= j; i++) {
                if (i == j) arr[i][j] = 1;
                else if (j - i == 1) arr[i][j] = (input[j] == input[i]) ? 1 : 0;
                else {
                    arr[i][j] = (input[j] == input[i] && arr[i + 1][j - 1] == 1) ? 1 : 0;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(arr[a][b]).append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
