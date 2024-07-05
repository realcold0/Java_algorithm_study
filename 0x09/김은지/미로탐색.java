import java.util.*;
import java.io.*;

public class 미로탐색 {

    public static int[][] dirs ={{1,0},{-1,0},{0,1},{0,-1}};
    public static int n,m;

    //map의 N,M위치 까지 반복
    public static int bfs(int startX, int startY, int[][] map){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});

        while(!q.isEmpty()){
            int currTmp[] = q.poll();
            int x = currTmp[0];
            int y = currTmp[1];

            for(int i =0; i< 4;i++){
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];

                //맵 내부에 있고
                if(0 <=nx && nx< n && 0<=ny && ny<m ){
                    //방문한 적없는 곳이라면?
                    if(map[nx][ny] == 1){
                        map[nx][ny] = map[x][y] +1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }

        }

        return map[n-1][m-1];



    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //맵 정보 : 1은 이동 가능 0은 이동 불가
        int[][] map = new int[n][m];
        //map배열에 값 달아주기
        for(int i = 0; i<n;i++){
            char[] tmpArr = br.readLine().toCharArray();
            for(int j = 0; j < tmpArr.length;j++){
                map[i][j] = tmpArr[j] -'0';
            }
        }
        bw.write(String.valueOf(bfs(0,0,map)));
        bw.flush();
        bw.close();



    }
}
