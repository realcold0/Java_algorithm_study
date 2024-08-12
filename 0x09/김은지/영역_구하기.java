// Boj_2583 영역 구하기
// 문제 유형 : BFS
// 풀이 시간 : 30m
// 해설 참고 : no
import java.util.*;
import java.io.*;
public class 영역_구하기 {

    static int n;
    static int m;
    static int[][]map;
    static int cnt = 0;
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static int tmpArea = 1;
    static ArrayList<Integer> areas = new ArrayList<>();

    public static void bfs(int startX, int startY){
        if(map[startY][startX] !=0){
            return ;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX,startY});
        cnt++;
        map[startY][startX] = cnt;
        while(!q.isEmpty()){
            int tmp[] = q.poll();
            int x = tmp[0];
            int y=  tmp[1];
            for(int i = 0; i <4 ; i++){
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];

                //맵 안에 들어와있고
                if(0<=nx&& nx<n &&0<=ny && ny<m){
                    //나머지 부분이라면
                    if(map[ny][nx] ==0){
                        map[ny][nx] =cnt;
                        tmpArea +=1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        areas.add(tmpArea);
        tmpArea = 1;
        return;
    }


    public static void makeArea(int startX,int startY, int endX,int endY){
        for(int i = startX; i < endX ; i++){
            for(int j = startY; j < endY ; j++){
                map[j][i] = -1;
            }
        }
        return;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[m][n];

        //k개의 직사각형배열에 넣기
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY =Integer.parseInt(st.nextToken());
            makeArea(startX,startY,endX,endY);
        }
        //모든 영역 bfs돌리기
        for(int i = 0; i < m;i++){
            for(int j = 0; j< n;j++){
                bfs(j,i);
            }
        }

//        Arrays.sort(areas); ArrayList는 Collections 클래스 사용
        System.out.println(cnt);
        Collections.sort(areas);
        for(int area : areas){
            System.out.print(area +" ");
        }
    }
}
