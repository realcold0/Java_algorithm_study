import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토 {

    static boolean check(String[][] map) {
        boolean res = true;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j].equals("0")) {
                    return false;
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
        int answer = 0;
        String[][] map = new String[N][M];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().split(" ");
        }
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j].equals("1")) {
                    q.add(new int[]{i, j, 0});
                }
                else if(map[i][j].equals("0")) {
                    cnt++;
                }
            }
        }
        if(cnt == 0) {
            System.out.println(0);
            return;
        }

        int[][] nxny = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            map[pos[0]][pos[1]] = "1";
            answer = pos[2];
            for(int[] n : nxny) {
                int ny = pos[0] + n[0];
                int nx = pos[1] + n[1];
                int L = pos[2];
                if(nx >= 0 && ny >= 0 && nx < M && ny < N && map[ny][nx].equals("0")) {
                    q.add(new int[]{ny, nx, L + 1});
                    map[ny][nx] = "1";
                }
            }
        }

        if(!check(map)) {
            System.out.println(-1);
        }
        else {
            System.out.println(answer);
        }


    }
}
