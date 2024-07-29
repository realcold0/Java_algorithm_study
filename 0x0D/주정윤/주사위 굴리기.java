import java.util.*;
import java.io.*;

public class Solution {
    static int N, M;
    static int x, y, K;
    static int[][] map;
    static int[] dice = new int[6];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 지도의 세로 크기 N, 가로 크기 M
        // 주사위를 놓은 곳의 좌표 x, y
        // 명령의 개수 K
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            int dir = Integer.parseInt(st.nextToken()) -1;
            rollDice(dir);
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void rollDice(int dir){
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
            return;
        }

        int[] temp = new int[6];
        switch (dir){
            case 0: //동
                temp[0] = dice[2]; // 북 -> 동
                temp[1] = dice[1]; // 북 -> 북
                temp[2] = dice[5]; // 서 -> 북
                temp[3] = dice[0]; // 동 -> 남
                temp[4] = dice[4]; // 서 -> 서
                temp[5] = dice[3]; // 남 -> 서
                break;
            case 1: //남
                temp[0] = dice[1]; // 위쪽 -> 북쪽
                temp[1] = dice[5]; // 북쪽 -> 아래쪽
                temp[2] = dice[2]; // 서쪽 -> 서쪽
                temp[3] = dice[3]; // 동쪽 -> 동쪽
                temp[4] = dice[0]; // 남쪽 -> 위쪽
                temp[5] = dice[4]; // 아래쪽 -> 남쪽
                break;
            case 2: //서
                temp[0] = dice[3]; // 위쪽 -> 서쪽
                temp[1] = dice[1]; // 북쪽 -> 북쪽
                temp[2] = dice[0]; // 서쪽 -> 아래쪽
                temp[3] = dice[5]; // 동쪽 -> 위쪽
                temp[4] = dice[4]; // 남쪽 -> 남쪽
                temp[5] = dice[2]; // 아래쪽 -> 동쪽
                break;
            case 3: //북
                temp[0] = dice[4]; // 위쪽 -> 남쪽
                temp[1] = dice[0]; // 북쪽 -> 위쪽
                temp[2] = dice[2]; // 서쪽 -> 서쪽
                temp[3] = dice[3]; // 동쪽 -> 동쪽
                temp[4] = dice[5]; // 남쪽 -> 아래쪽
                temp[5] = dice[1]; // 아래쪽 -> 북쪽
                break;
        }

        x = nx;
        y = ny;
        dice = temp;

        // 빈칸이면 바닥면 지정
        if(map[x][y] ==0){
            map[x][y] = dice[5];
        } else {
            // 값이 있으면 그 값을 바닥면에 저장
            dice[5] = map[x][y];
            map[x][y] = 0;
        }

        System.out.println(dice[0]);
    }


}
