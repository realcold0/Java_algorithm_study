import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탐색  {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];
        char[][] map = new char[N][M];
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[][] nxny = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();


        q.offer(new int[]{0, 0, 1});

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            map[pos[0]][pos[1]] = '0';
            int L = pos[2];
            if(pos[0] == N - 1 && pos[1] == M - 1) {
                bw.write(L + "\n");
                bw.flush();
                bw.close();
                br.close();
                return;
            }
            for(int[] n : nxny) {
                int ny = pos[0] + n[0];
                int nx = pos[1] + n[1];
                if(ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] == '1') {
                    q.add(new int[]{ny, nx, L + 1});
                    map[ny][nx] = '0';
                }
            }
        }
    }
}
