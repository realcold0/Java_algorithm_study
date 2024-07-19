import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) { // 배열 초기화
            for (int j = 0; j < N; j++) {
                arr[i][j] = ' ';
            }
        }

        solve(0, 0, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void solve(int row, int col, int size){

        if (size == 1) {
            arr[row][col] = '*';
            return;
        } else { // 더 쪼개야 하면
            int newSize = size / 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1){ // 빈칸은 3x3 기준 (1, 1)에 위치하기 때문
                        continue;
                    }
                    solve(row + i * newSize, col + j * newSize, newSize);
                }
            }
        }
    }
}
