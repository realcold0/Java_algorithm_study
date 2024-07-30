import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 스티커_붙이기 {
    static int[][] map;
    static int N, M, K;
    static ArrayList<int[][]> stickers = new ArrayList<>();

    static boolean check(int[][] sticker, int startY, int startX) {
        int endY = sticker.length;
        int endX = sticker[0].length;
        Queue<int[]> queue = new LinkedList<>();
        if (startY + endY > N || startX + endX > M) return false;

        for (int i = 0; i < endY; i++) {
            for (int j = 0; j < endX; j++) {
                if (sticker[i][j] == 1 && map[startY + i][startX + j] == 1) { // 스티커가 겹친다.
                    return false;
                }
            }
        }
        return true;
    }

    static void place(int[][] sticker, int startY, int startX) {
        int endY = sticker.length;
        int endX = sticker[0].length;
        for(int i = 0; i < endY; i++) {
            for(int j = 0; j < endX; j++) {
                if (sticker[i][j] == 1) {
                    map[startY + i][startX + j] = 1;
                }
            }
        }
    }


    static int[][] rotate(int[][] sticker) {
        int X = sticker[0].length;
        int Y = sticker.length;
        int[][] res = new int[X][Y];
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                res[j][Y - 1 - i] = sticker[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int[][] tmp = new int[l][];
            for (int j = 0; j < l; j++) {
                tmp[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            stickers.add(tmp);
        }

        outer:
        for (int[][] sticker : stickers) {
            int[][] tmp = sticker;
            for (int k = 0; k < 4; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                            if (i + tmp.length <= N && j + tmp[0].length <= M && check(tmp, i, j)) {
                                place(tmp, i, j);
                                continue outer;
                            }
                        }
                    }
                tmp = rotate(tmp);
            }
        }


        bw.write(Arrays.stream(map).flatMapToInt(Arrays::stream).sum() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
