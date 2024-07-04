import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 빙산 {
    static int[][] map;
    static int[][] ck;
    static void BFS(int i, int j) {
        int[][] nxny = {{-1,0},{0,1},{1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> qn = new LinkedList<>();
        q.add(new int[]{i, j});
        ck[i][j] = 1;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int y = pos[0];
            int x = pos[1];
            int cnt = 0;
            for(int[] n : nxny) {
                int ny = y + n[0];
                int nx = x + n[1];
                if (nx >= 0 && ny >= 0 && ny < map.length && nx < map[0].length) {
                    if(map[ny][nx] == 0) {
                        cnt++;
                    }
                    else if(map[ny][nx] > 0 && ck[ny][nx] == 0) {
                        q.add(new int[]{ny, nx});
                        ck[ny][nx] = 1;
                    }
                }
            }
            qn.add(new int[]{y, x, cnt});
            //map[y][x] = Math.max(0, map[y][x] - cnt);
        }

        while(!qn.isEmpty()) {
            int[] pos = qn.poll();
            int y = pos[0];
            int x = pos[1];
            int w = pos[2];

            map[y][x] = Math.max(0, map[y][x] - w);
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];

        map = new int[N][M];
        ck = new int[N][M];

        for(int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int answer = 0;
        int cnt = 0;
        while(true){
            cnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] > 0 && ck[i][j] == 0) {
                        cnt++;
                        BFS(i, j);
                    }
                }
            }
            if(cnt > 1) {
                break;
            }else if(cnt == 0 ) {
                answer = 0;
                break;
            }
            ck = new int[N][M];
            answer++;
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
