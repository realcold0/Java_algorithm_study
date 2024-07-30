import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 주사위_굴리기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] maps = new int[n][m];

        for (int i = 0; i < n; i++) {
            maps[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] commands = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dies = new int[6];

        for (int command : commands) {
            int d1 = dies[0], d2 = dies[1], d3 = dies[2], d4 = dies[3], d5 = dies[4], d6 = dies[5];
            int n_y = y, n_x = x;

            switch (command) {
                case 1: // 오른쪽
                    n_x = x + 1;
                    if (0 <= n_y && n_y < n && 0 <= n_x && n_x < m) {
                        dies[0] = d1;
                        dies[1] = d5;
                        dies[2] = d3;
                        dies[3] = d6;
                        dies[4] = d4;
                        dies[5] = d2;

                        if (maps[n_y][n_x] == 0) {
                            maps[n_y][n_x] = dies[3];
                        } else {
                            dies[3] = maps[n_y][n_x];
                            maps[n_y][n_x] = 0;
                        }

                        System.out.println(dies[1]);
                        x = n_x;
                    }
                    break;
                case 2: //왼쪽
                    n_x = x - 1;
                    if (0 <= n_y && n_y < n && 0 <= n_x && n_x < m) {
                        dies[0] = d1;
                        dies[1] = d6;
                        dies[2] = d3;
                        dies[3] = d5;
                        dies[4] = d2;
                        dies[5] = d4;

                        if (maps[n_y][n_x] == 0) {
                            maps[n_y][n_x] = dies[3];
                        } else {
                            dies[3] = maps[n_y][n_x];
                            maps[n_y][n_x] = 0;
                        }

                        System.out.println(dies[1]);
                        x = n_x;
                    }
                    break;
                case 3: // 위쪽
                    n_y = y - 1;
                    if (0 <= n_y && n_y < n && 0 <= n_x && n_x < m) {
                        dies[0] = d2;
                        dies[1] = d3;
                        dies[2] = d4;
                        dies[3] = d1;
                        dies[4] = d5;
                        dies[5] = d6;

                        if (maps[n_y][n_x] == 0) {
                            maps[n_y][n_x] = dies[3];
                        } else {
                            dies[3] = maps[n_y][n_x];
                            maps[n_y][n_x] = 0;
                        }

                        System.out.println(dies[1]);
                        y = n_y;
                    }
                    break;
                case 4: // 아래쪽
                    n_y = y + 1;
                    if (0 <= n_y && n_y < n && 0 <= n_x && n_x < m) {
                        dies[0] = d4;
                        dies[1] = d1;
                        dies[2] = d2;
                        dies[3] = d3;
                        dies[4] = d5;
                        dies[5] = d6;

                        if (maps[n_y][n_x] == 0) {
                            maps[n_y][n_x] = dies[3];
                        } else {
                            dies[3] = maps[n_y][n_x];
                            maps[n_y][n_x] = 0;
                        }

                        System.out.println(dies[1]);
                        y = n_y;
                    }
                    break;
            }
        }
    }
}
