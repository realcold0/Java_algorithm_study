import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소 {
    static int max = Integer.MIN_VALUE;
    static int N, M;
    static int[][] map;
    static ArrayList<int[]> virus = new ArrayList<>();
    static ArrayList<int[]> canPlaceWall = new ArrayList<>();
    static boolean[] check;
    static int[][] nynx = {{-1,0},{0,1},{1,0},{0,-1}};

    static int bfs(Stack<int[]> selected) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] tmp = new int[N][M];

        for(int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, tmp[i], 0, M);
        }

        for(int[] pos : selected) {
            tmp[pos[0]][pos[1]] = 1;
        }

        for(int[] pos : virus) {
            queue.offer(pos);
        }
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];

            for(int[] n : nynx) {
                int ny = n[0] + y;
                int nx = n[1] + x;
                if(ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if(tmp[ny][nx] == 0) {
                        tmp[ny][nx] = 2;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }

        int safeArea = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tmp[i][j] == 0) {
                    safeArea++;
                }
            }
        }

        return safeArea;
    }

    static void dfs(int L, Stack<int[]> selected) {
        if(L == 3) {
            max = Math.max(max, bfs(selected));
            return;
        }
        for(int i = 0; i < canPlaceWall.size(); i++) {
            if(!check[i]) {
                check[i] = true;
                selected.push(canPlaceWall.get(i).clone());
                dfs(L + 1, selected);
                selected.pop();
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
                else if(map[i][j] == 0){
                    canPlaceWall.add(new int[]{i, j});
                }
            }
        }

        check = new boolean[canPlaceWall.size()];
        dfs(0, new Stack<>());

        System.out.println(max);
    }
}
