import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙산 {
    static int n;
    static int m;
    static int cnt;
    static int year;
    public static int[][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    //0 파도일 때 4방향 -1
    public static void bfsWave(int[][]map,int startX, int startY) {
        for (int i = 0; i < 4; i++) {
            int nx = dirs[i][0] + startX;
            int ny = dirs[i][1] + startY;
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (map[nx][ny] > 0) {
                    map[nx][ny] -= 1;
                }
            }
        }
        return;
    }

    public static void bfsCount(int[][]map, int startX, int startY,boolean[][]visited, int cnt){
        Queue<int[]> q=  new LinkedList<>();


        //일단 면적 1 증가
        cnt++;
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

        boolean flag = false;
        while(cnt<2){
            cnt = 0;
            flag =false;
            year+=1;
             //파도 역할
            for(int i = 0; i<n;i++){
                for(int j = 0; j<m;j++){
                    if(map[i][j] ==0)
                        bfsWave(map,i,j);
                }
            }
            //빙하 개수 새기
            boolean[][] visited = new boolean[n][m];
            for(int i = 0; i<n;i++){
                for(int j = 0; j<m;j++){
                    if(map[i][j] !=0){
                        flag = true;
                        bfsCount(map,i,j,visited,cnt);
                    }
                }
            }
        }

        if(!flag){
            System.out.println(year);
        }else{
            System.out.println(cnt);
        }



    }
}
