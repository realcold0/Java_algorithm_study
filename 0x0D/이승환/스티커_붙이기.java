import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;
        map = new int[n][m];

        // k개의 스티커를 받는다.
        for (int test = 0; test < k; test++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st2.nextToken());
            int width = Integer.parseInt(st2.nextToken());

            int[][] sticker = new int[height][width];
            // 스티커 입력 받기
            for (int i = 0; i < height; i++) {
                StringTokenizer st3 = new StringTokenizer(br.readLine());
                for (int j = 0; j < width; j++) {
                    sticker[i][j] = Integer.parseInt(st3.nextToken());
                }
            }

            boolean attached = false;

            for (int rotationCount = 0; rotationCount < 4; rotationCount++) {
                // 먼저 들어갈 수 있는지확인
                outerLoop:
                for (int startX = 0; startX <= n - height; startX++) {
                    for (int startY = 0; startY <= m - width; startY++) {
                        boolean flag = false;
                        // 스티커랑 맵이랑 비교
                        for (int i = 0; i < height; i++) {
                            for (int j = 0; j < width; j++) {
                                if (sticker[i][j] == 1 && map[startX + i][startY + j] == 1) {
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag) {
                                break;
                            }
                        }
                        // 가능하다면
                        if (!flag) {
                            // 맵에 스티커 붙인뒤에
                            for (int i = 0; i < height; i++) {
                                for (int j = 0; j < width; j++) {
                                    if (sticker[i][j] == 1) {
                                        map[startX + i][startY + j] = 1;
                                        answer++;
                                    }
                                }
                            }
                            attached = true;
                            break outerLoop;
                        }
                    }
                }

                if (attached) {
                    break;
                }

                // 돌린다.
                int newHeight = width;
                int newWidth = height;
                int[][] tmp = new int[newHeight][newWidth];
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        tmp[j][height - 1 - i] = sticker[i][j];
                    }
                }
                sticker = tmp;
                height = newHeight;
                width = newWidth;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
