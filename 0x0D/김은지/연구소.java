
import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static Queue<int[]> virus;
    static int[][] map;
    static int[][] dirs ={{1,0},{-1,0},{0,1},{0,-1}};
    static int zerocnt;
    static int mincnt = Integer.MAX_VALUE;
    static int maxSafeZone =0;

    static int bfs(int[][]nowmap){
        Queue<int[]> q = new ArrayDeque<>(virus);
        boolean[][] visited = new boolean[nowmap.length][nowmap[0].length];
        int spreadVirusCount = 0;
        while(!q.isEmpty()){
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            for(int i = 0; i<4;i++){
                int nextRow = row+dirs[i][0];
                int nextCol = col+dirs[i][1];
                if(0<=nextRow && nextRow<nowmap.length && 0<=nextCol && nextCol<nowmap[0].length){
                    if(!visited[nextRow][nextCol] && nowmap[nextRow][nextCol]==0){
                        visited[nextRow][nextCol] = true;
                        spreadVirusCount++;
                        nowmap[nextRow][nextCol] = 2;
                        q.add(new int[]{nextRow,nextCol});
                    }
                }
            }
        }
        return zerocnt - spreadVirusCount -3; //안전영역의 크기
    };

    static void makeWall(int starti, int startj, List<int[]> curr){
        if(curr.size() == 3){
            //맵 복사
            int[][] tmpmap= new int[n][m];
            for(int i = 0; i < n; i++){
                tmpmap[i] = Arrays.copyOf(map[i], map[i].length);
            }
            for(int[] wall : curr){
                tmpmap[wall[0]][wall[1]] = 1;
            }
            maxSafeZone = Math.max(bfs(tmpmap), maxSafeZone);
            return ;
        }
        for(int i = starti ; i<n;i++){
            for(int j = (i == starti ? startj : 0); j < m; j++){
                if(map[i][j] == 0){
                    curr.add(new int[]{i, j});
                    // 같은 행의 다음 열부터 시작
                    makeWall(i, j + 1, curr);
                    curr.remove(curr.size() - 1);
                }
            }
        }
        return;
    };

    static int solution(){
        makeWall(0,0,new ArrayList<>());
        return maxSafeZone;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        virus = new LinkedList<int[]>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) virus.offer(new int[]{i, j});
                if(map[i][j]==0) zerocnt++;
            }
        }
        bw.write(String.valueOf(solution()));
        bw.flush();
        bw.close();
    }
}
