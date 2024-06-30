
import java.io.*;
import java.util.*;

public class Main {

    public static boolean visited[][];
    public static int maze[][];
    public static int N, M, count;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class pos{
        int x;
        int y;

        pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y){
        Queue<pos> queue = new LinkedList<>();
        queue.add(new pos(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            pos start = queue.poll();

            for(int i = 0; i<4; i++){
                int nx = start.x + dx[i];
                int ny = start.y + dy[i];

                if(nx<0 || ny<0 || nx>maze.length-1 || ny>=maze[0].length) continue;

                // 방문하지 않았고 그 값이 1로 존재한다면 (길이 있음)
                if(!visited[nx][ny] && maze[nx][ny] !=0){
                    maze[nx][ny] = maze[start.x][start.y] + 1;
                    queue.add(new pos (nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // N개의 줄에 M개의 정수가 미로로 주어진다
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];

        // 다음에 주어지는 입력을 저장할 배열
        maze = new int[N][M];
        count = 0;

        // for문을 돌면서 값을 입력받는다
        for(int i=0; i<N; i++){
            String[] str_arr = br.readLine().split("");
            for(int j=0; j<M; j++){
                maze[i][j] = (Integer.parseInt(str_arr[j]));
            }
        }

        // bfs 함수로 리스트를 넘겨준다다
        bfs(0, 0);

        bw.write(maze[N-1][M-1] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
