import java.io.*;
import java.util.*;

public class 연구소 {
    static int N, M;
    static int[][] map, tempMap;
    static int MAX = Integer.MIN_VALUE;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //지도의 세로 크기 N과 가로 크기 M
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //지도의 모양
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        setWall(0);

        bw.write(MAX + "\n");
        bw.flush();
        br.close();
        bw.close();

    }

    static void setWall(int cnt){
        //3개의 벽을 세운다
        if(cnt == 3){
            spreadVirus();
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                // 빈 공간이면 해당 위치에 벽 세우기
                if(map[i][j] == 0){
                    map[i][j] = 1; // 벽 세우기
                    setWall(cnt+1);
                    map[i][j] = 0; //복구
                }
            }
        }
    }

    static void spreadVirus(){
        tempMap = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                tempMap[i][j] = map[i][j];
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tempMap[i][j] == 2) dfs(i, j);
            }
        }

        int temp = countSafe();
        MAX = Math.max(MAX, temp);
    }

    static void dfs(int x, int y){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if(tempMap[nx][ny] == 0) {
                    //빈칸이면 바이러스 옮음
                    tempMap[nx][ny] = 2;
                    dfs(nx, ny);
                }
            }
        }
    }

    static int countSafe(){
        int cnt = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tempMap[i][j] == 0) cnt++;
            }
        }

        return cnt;
    }


}
