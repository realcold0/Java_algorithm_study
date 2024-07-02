import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] map;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        Point start = new Point(0, 0);
        Point end = new Point(n - 1, m - 1);
        //맵 다만들기
        for(int i = 0 ;i < n ;i++) {
            String line = br.readLine();
            for(int j = 0; j< m; j++){
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        int result = bfs(start, end, n, m);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(Point start, Point end, int n , int m){
        Queue<Point> queue = new LinkedList<Point>();
        int[] dx = {1, -1, 0 ,0};
        int [] dy = {0,0 , -1, 1 };

        queue.add(start);
        visited[start.x][start.y] = true;

        while(!queue.isEmpty()){
            Point current = new Point(queue.poll());

            if(current.x == end.x && current.y == end.y){
                return map[current.x][current.y];
            }
            for(int i =0; i < 4;i++){
                Point next = new Point(current.x + dx[i], current.y + dy[i]);
                if(   next.x >=0 && next.x < n && next.y>= 0 && next.y < m && !visited[next.x][next.y] && map[next.x][next.y] == 1){
                    queue.add(next);
                    visited[next.x][next.y] = true;
                    map[next.x][next.y] = map[current.x][current.y] + 1;
                }
            }
        }
        return map[end.x][end.y];
    }

}
