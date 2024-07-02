import java.io.*;
import java.util.*;
import java.awt.Point;
public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[][] resultMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        resultMap = new int[n][m];
        for(int i = 0;i<n;i++){
            String line = br.readLine();
            for(int j =0;j<m;j++){
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        int result = bfs(n, m);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
    public static int bfs(int n, int m){
        Queue<Point> queue = new LinkedList<>();
        Point start =  new Point(0,0);
        Point end = new Point(n-1,m-1);
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        resultMap[start.x][start.y] = 1;

        queue.add(start);
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            visited[current.x][current.y] = true;
            if(current.x == end.x && current.y == end.y){
                return resultMap[current.x][current.y];
            }

            for(int i =0;i<4;i++){
                //0이고 map범위 이내
                Point next=  new Point(current.x + dx[i], current.y + dy[i]);
                if(next.x >= 0 && next.x < n && next.y >=0 && next.y < m && !visited[next.x][next.y]){
                    //현재 1에 있으면 0만 넣을 수 있고
                    //현재 0에 있으면 1만 넣을 수 있다.
                    if(map[current.x][current.y] == 2 && map[next.x][next.y] == 0){
                        queue.add(next);
                        map[next.x][next.y] = 2;
                        resultMap[next.x][next.y] = resultMap[current.x][current.y] + 1;
                    } else if(map[current.x][current.y] == 0 && (map[next.x][next.y] == 0 || map[next.x][next.y] == 1)){
                        queue.add(next);
                        if(map[next.x][next.y] == 1){
                            map[next.x][next.y] = 2;
                        }
                        resultMap[next.x][next.y] = resultMap[current.x][current.y] + 1;
                    }
                }
            }
        }
        return -1;

    }

}
