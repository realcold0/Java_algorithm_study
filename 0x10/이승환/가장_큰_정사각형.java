import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, -1, 0}; // 위 왼쪽위 왼쪽
    static int[] dy = {0, -1, -1};
    static int[][] map;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                int tmp = Character.getNumericValue(line.charAt(j));
                map[i][j] = tmp;
                if (tmp == 1) {
                    map[i][j] = checkSquare(i, j);
                    max = Math.max(map[i][j], max);
                }

            }
        }
        bw.write(max * max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static int checkSquare(int x, int y) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                min = Math.min(min, map[nx][ny]);
            } else {
                min = Math.min(min, 0);
            }
        }
        return min + 1;
    }
}
