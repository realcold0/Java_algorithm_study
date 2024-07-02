import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        Queue<Point> queue = new LinkedList<>();
        map = new int[n][m];

        for(int i = 0;i<n;i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
            for(int j =0; j< m;j++){
                int tmp = Integer.parseInt(st2.nextToken());
                map[i][j] = tmp;
                if(tmp == 1){
                    queue.add(new Point(i, j));
                }
            }
        }
        int result = 0;


        result = bfs(queue, n, m);
        for(int i = 0; i< n ;i++){
            for(int j = 0; j<m ;j++){
                if(map[i][j] == 0){
                    result = -1;
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();

    }

    public static int bfs(Queue<Point> queue, int n, int m){
        int max = Integer.MIN_VALUE;
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        while(!queue.isEmpty()){
            Point current = queue.poll();
            if(map[current.x][current.y] > max){
                max = map[current.x][current.y];
            }
            for(int i =0;i<4;i++){
                Point next = new Point(current.x + dx[i], current.y + dy[i]);
                if(next.x >=0 && next.x < n && next.y>=0 && next.y < m && map[next.x][next.y] == 0){
                    queue.add(next);
                    map[next.x][next.y] = map[current.x][current.y] + 1;
                }
            }
        }


        return max -1;
    }
}
