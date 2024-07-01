package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static int[][] box;
    public static int N, M;

    public static Queue<pos> queue = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class pos{
        int x;
        int y;
        int day;

        public pos(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void bfs(){
        int day = 0;

        while(!queue.isEmpty()){
            pos p = queue.poll();
            day = p.day;

            for(int i = 0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(0 <= nx && nx < N && 0 <= ny && ny < M){
                    if(box[nx][ny] == 0){
                        box[nx][ny] = 1;
                        queue.add(new pos(nx, ny, day+1));
                    }
                }
            }
        }

        if(check()) System.out.println(day);
        else System.out.println(-1);

    }

    static boolean check(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(box[i][j] == 0) return false;
            }
        }

        return true;
    }


    //문제 접근 방식 : 1을 기준으로 주변의 값을 1을 더해준다 그러고 마지막에 -1해서 출력하면 됨
    // 큐에 익은 토마토들을 다 넣고 그걸 기준으로 주변의 값을 모두 큐에 넣어준다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // M은 상자의 가로 칸의 수, N은 상자의 세로 칸 수
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // 다음에 주어지는 입력을 저장할 배열
        box = new int[N][M];

        // for문을 돌면서 값을 입력받는다
        for(int i=0; i<N; i++){
            String[] str_arr = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                box[i][j] = Integer.parseInt(str_arr[j]);
                if(box[i][j] == 1) queue.add(new pos(i, j, 0));
            }
        }

        bfs();

    }
}
