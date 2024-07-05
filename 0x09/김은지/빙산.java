import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙산 {
    static int n;
    static int m;
    static int year;
    public static int[][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    //0 파도일 때 4방향 -1
    public static void bfsWave(int[][]map) {
        int[][]temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]>0){
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = dirs[dir][0] + i;
                        int ny = dirs[dir][1] + j;
                        if (0 <= nx && nx < n && 0 <= ny && ny < m){
                            if(map[nx][ny]==0){
                                temp[i][j]--;
                            }
                        }
                    }
                    temp[i][j] = Math.max(0,map[i][j] +temp[i][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
        System.arraycopy(temp[i], 0, map[i], 0, m);
        }
    }

    public static void bfsCount(int[][]map, int startX, int startY,boolean[][]visited){
        Queue<int[]> q=  new LinkedList<>();
        //일단 면적 1 증가
        q.add(new int[]{startX,startY});
        visited[startX][startY] = true;
        while(!q.isEmpty()){
            int[] curr= q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int i = 0; i<4; i++){
                int nx = dirs[i][0] + x;
                int ny = dirs[i][1] + y;
                if(0<=nx &&nx<n && 0<=ny &&ny <m){
                    if(!visited[nx][ny] && map[nx][ny] !=0){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        return;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][]map = new int[n][m];
        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        boolean flag = false;
        while(true){
            int cnt = 0;
            year+=1;
             //파도 역할
            bfsWave(map);
            //빙하 개수 새기
            boolean[][] visited = new boolean[n][m];
            for(int i = 0; i<n;i++){
                for(int j = 0; j<m;j++){
                    if(map[i][j] !=0 && !visited[i][j]){
                        cnt++;
                        bfsCount(map,i,j,visited);
                    }
                }
            }
            if(cnt ==0){
                System.out.println(0);
                break;
            }else if(cnt>=2){
                System.out.println(year);
                break;
            }
        }





    }
}
