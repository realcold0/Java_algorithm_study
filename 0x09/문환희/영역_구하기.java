import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 영역_구하기 {
    static int[][] map;

    static int BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        int res = 0;
        int[][] nxny = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[1];
            int y = pos[0];
            res++;
            map[y][x] = 1;

            for(int[] n : nxny) {
                int nx = n[1] + x;
                int ny = n[0] + y;

                if(nx >= 0 && nx < map[0].length && ny >= 0 && ny < map.length && map[ny][nx] == 0) {
                    q.add(new int[]{ny, nx});
                    map[ny][nx] = 1;
                }
            }

        }
        return res;
    }


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = input[0];
        int N = input[1];
        int K = input[2];

        map = new int[M][N];

        for(int i = 0; i < K; i++) {
            int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = in[1]; j < in[3]; j++) {
                for(int k = in[0]; k < in[2]; k++) {
                    map[j][k] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 0) {
                    cnt ++;
                    arr.add(BFS(i, j));
                    //sb.append(BFS(i, j) + " ");
                }
            }
        }
        arr.sort(null);
        for(int i : arr) {
            sb.append(i + " ");
        }

        bw.write(cnt + "\n");
        bw.write(sb.toString()+ "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
