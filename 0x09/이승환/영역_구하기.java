import java.io.*;
import java.util.*;
import java.awt.Point;
public class Main {
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> result = new ArrayList<>();
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new  boolean[n][m];
        StringBuilder sb = new StringBuilder();

        for(int i =0;i<k;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            Point start  =  new Point(Integer.parseInt(st2.nextToken()), Integer.parseInt((st2.nextToken())));
            Point end = new Point(Integer.parseInt(st2.nextToken()), Integer.parseInt((st2.nextToken())));
            for(int j =start.x; j<end.x; j++){
                for(int v = start.y; v<end.y; v++){
                    map[j][v] = 1;
                }
            }
        }
        int count =0;

        //IF 돌면서 있다면 BFS
        for(int i = 0;i<n;i++){
            for(int j = 0; j < m;j++){
                if(map[i][j] == 0){
                    count++;
                    result.add(bfs(i, j, n, m));
                }
            }
        }
        result.sort(Integer::compare);
        sb.append(count).append("\n");
        for(int i = 0; i<result.size();i++){
            sb.append(result.get(i)).append(" ");
        }
        bw.write(sb.toString());


        bw.flush();
        bw.close();
        br.close();
    }
    public static int bfs(int x, int y, int n, int m){
        Queue<Point> queue = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int count = 0;
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            map[current.x][current.y] = 2;
            count++;
            for(int i =0;i<4;i++){
                //0이고 map범위 이내
                Point next=  new Point(current.x + dx[i], current.y + dy[i]);
                if(next.x >= 0 && next.x < n && next.y >=0 && next.y < m && map[next.x][next.y] == 0 && !visited[next.x][next.y]){
                    queue.add(next);
                    visited[next.x][next.y] = true;
                }
            }
        }

        return count;
    }

}
