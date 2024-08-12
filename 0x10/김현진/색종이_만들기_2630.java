import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int white = 0;
    static int blue = 0;
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

        sb.append(white).append("\n").append(blue);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void solve(int row, int col, int size) {
        if (check(row, col, size)) {
            int tmp = arr[row][col];
            if (tmp == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                solve(row + i * newSize, col + j * newSize, newSize);
            }
        }
    }

    static boolean check(int row, int col, int size) {
        int tmp = arr[row][col];
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
