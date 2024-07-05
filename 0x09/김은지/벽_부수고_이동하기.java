import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 벽_부수고_이동하기 {
    public static int[][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static int n;
    static int m;
    static int min = 1000000;
    public static void bfs(int[][]map,Deque<int[]>q, boolean flag){
        if(q.isEmpty()){
            min = Math.min(map[n-1][m-1],min);
            return;
        }
        int[] curr = q.pollFirst();
        int x = curr[0];
        int y = curr[1];

        for(int i = 0; i<4;i++){
            int nx = dirs[i][0] + x;
            int ny = dirs[i][1] + y;

            if(0<=nx && nx<n &&0<=ny && ny <m ){
                //flag : 벽 부순적 있으면 true
                if(flag && map[nx][ny]!=-1){
                    //전진 가능
                    map[nx][ny] = map[x][y] +1;
                    q.add(new int[]{nx,ny});
                    bfs(map,q,flag);
                }else if(!flag){
                    //전진 가능
                    flag = true;
                    map[nx][ny] = map[x][y] +1;
                    q.add(new int[]{nx,ny});
                    bfs(map,q,flag);
                }
            }
        }





    }



    public static void main(String[] args) throws IOException {
        //입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][]map = new int[n][m];
        for(int i = 0; i< n; i++){
            String line = br.readLine();
            for(int j = 0; j<m;j++){
                int tmp = line.charAt(j) -'0';
                if(tmp == 1){
                    tmp = -1;
                }
                map[i][j] = tmp;
            }
        }
        Deque<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        map[0][0] = 1;
        boolean flag = false;
        bfs(map,q,flag);
        if(min ==0 || min == -1){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }


    }
}
