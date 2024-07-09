import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int a = 0; // -1
    static int b = 0; // 0
    static int c = 0; // 1
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, N);

        sb.append(a).append("\n").append(b).append("\n").append(c);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void solve(int row, int col, int size) {
        if (check(row, col, size)) {
            int tmp = arr[row][col];

            if (tmp == -1) {
                a++;
            } else if (tmp == 0) {
                b++;
            } else {
                c++;
            }
            return;
        }

        // 더 잘라야 할 경우
        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solve(row + i * newSize, col + j * newSize, newSize);
            }
        }
    }

    static boolean check(int row, int col, int size) { // 내부 수 확인
        int tmp = arr[row][col]; // 기준 수
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != tmp) {
                    return false;
                }
            }
        }
        return true;
    }

}
