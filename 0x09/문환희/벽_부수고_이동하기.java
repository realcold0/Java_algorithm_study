import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 벽_부수고_이동하기 {
    static int N, M;
    static int BFS(char [][] map) {
        int[][][] ck = new int[N][M][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 0});
        ck[0][0][0] = 1;
        int[][] nxny = {{0, -1}, {1, 0}, {-1, 0}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            if(pos[0] == N -1 && pos[1] == M -1){
                return pos[2];
            }
            for(int[] n : nxny) {
                int ny = pos[0] + n[0];
                int nx = pos[1] + n[1];

                if(nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if(map[ny][nx] == '0' && ck[ny][nx][pos[3]] == 0){
                        ck[ny][nx][pos[3]] = 1;
                        queue.add(new int[] {ny, nx, pos[2] + 1, pos[3]});
                    }
                    else if (map[ny][nx] == '1' && ck[ny][nx][1] == 0 && pos[3] == 0){
                        ck[ny][nx][1] = 1;
                        queue.add(new int[] {ny, nx, pos[2] + 1, 1});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];
        char[][] map = new char[N][M];
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int res = BFS(map);

        bw.write(String.valueOf(res)+'\n');
        bw.flush();
        bw.close();
        br.close();

    }
}
