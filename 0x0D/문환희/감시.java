import java.io.*;
import java.util.*;

public class 감시 {
    static int N;
    static int M;
    static int[][] map;
    static int[][] nxny = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] cases;
    static int[][] board;

    static void check(int i, int j, int dir) {
        while (true) {
            i += nxny[dir][0];
            j += nxny[dir][1];
            if (j >= 0 && j < M && i >= 0 && i < N) {
                if (map[i][j] == 0) {
                    board[i][j] = 1;
                }
                if (map[i][j] == 6) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];
        map = new int[N][M];
        int answer = Integer.MAX_VALUE;
        board = new int[N][M];
        ArrayList<int[]> list = new ArrayList<>();
        int cctv_cnt = 0;
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctv_cnt++;
                    list.add(new int[]{i, j});
                }
            }
        }
        cases = new int[(int) Math.pow(4, cctv_cnt)][cctv_cnt];

        for (int i = 0; i < cases.length; i++) {
            int b = i;
            for (int j = 0; j < cases[0].length; j++) {
                cases[i][j] = b % 4;
                b /= 4;
            }
        }

        for (int i = 0; i < cases.length; i++) {
            for (int p = 0; p < N; p++) {
                for (int q = 0; q < M; q++) {
                    board[p][q] = map[p][q];
                }
            }

            int[] tmp = cases[i];
            for (int k = 0; k < cases[0].length; k++) {
                int[] cctv = list.get(k);
                int dir = tmp[k];
                switch (map[cctv[0]][cctv[1]]) {
                    case 1: {
                        check(cctv[0], cctv[1], dir % 4);
                        break;
                    }
                    case 2: {
                        check(cctv[0], cctv[1], dir % 4);
                        check(cctv[0], cctv[1], (dir + 2) % 4);
                        break;
                    }
                    case 3: {
                        check(cctv[0], cctv[1], dir % 4);
                        check(cctv[0], cctv[1], (dir + 1) % 4);
                        break;
                    }
                    case 4: {
                        check(cctv[0], cctv[1], dir % 4);
                        check(cctv[0], cctv[1], (dir + 1) % 4);
                        check(cctv[0], cctv[1], (dir + 2) % 4);
                        break;
                    }
                    case 5: {
                        check(cctv[0], cctv[1], dir % 4);
                        check(cctv[0], cctv[1], (dir + 1) % 4);
                        check(cctv[0], cctv[1], (dir + 2) % 4);
                        check(cctv[0], cctv[1], (dir + 3) % 4);
                        break;
                    }
                }
            }

            int res = 0;
            for (int p = 0; p < N; p++) {
                for (int q = 0; q < M; q++) {
                    if (board[p][q] == 0) {
                        res++;
                    }
                }
            }
            answer = Math.min(res, answer);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
