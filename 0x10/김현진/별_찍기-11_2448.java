import java.io.*;

public class Main {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N*2-1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N*2-1; j++) {
                arr[i][j] = ' '; // 초기화
            }
        }

        solve(0, N-1, N); // 꼭대기 점

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N*2-1; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void solve(int row, int col, int size) {
        if (size == 3) { // 기본형
            arr[row][col] = '*'; // 첫째 줄
            arr[row+1][col+1] = arr[row+1][col-1] = '*'; // 두번째 줄
            arr[row+2][col+2] = arr[row+2][col+1] = arr[row+2][col] = arr[row+2][col-1] = arr[row+2][col-2] = '*'; // 세번째 줄
            return;
        } else { // 더 쪼개야 하면
            int newSize = size / 2;

            solve(row, col, newSize); // 위 삼각형
            solve(row+newSize, col+newSize, newSize); // 아래 오른쪽 삼각형
            solve(row+newSize, col-newSize, newSize); // 아래 왼쪽 삼각형
        }
    }
}
