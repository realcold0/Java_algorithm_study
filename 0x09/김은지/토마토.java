import java.io.*;
import java.util.*;

public class Tomato {

    static int[][] dirs ={{1,0},{-1,0},{0,1},{0,-1}};
    static int m;
    static int n;
    public static void solution(int map[][], Deque<int[]> tomatos){
        while(!tomatos.isEmpty()){
            int[] tomato = tomatos.poll();
            int x = tomato[0];
            int y = tomato[1];

            //4방향 돌기
            for(int i =0; i< 4; i++){
                int nx= x + dirs[i][0];
                int ny= y + dirs[i][1];

                //조건에 맞다면?
                if(0<=nx && nx< n &&0<=ny && ny< m){
                    if(map[nx][ny] ==0){
                        map[nx][ny] = map[x][y] +1;
                        tomatos.add(new int[]{nx,ny});

                    }
                }

            }

        }
    }
    public static int getMaxMap(int[][]map){
        int answer = 0;
        for(var arr : map){
            for(var element : arr){
                if(element > answer) answer = element;
                if(element ==0 ) return -1;
            }
        }
        if(answer == 1){
            return 0;
        }

        return answer -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        Deque<int[]> tomatos = new LinkedList<>();
        for (int i =0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m;j++){
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if(tmp ==1){
                    tomatos.offer(new int[]{i, j});
                }
            }
        }

        solution(map,tomatos);

        bw.write(String.valueOf(getMaxMap(map)));
        bw.flush();
        bw.close();
        br.close();
    }
}
