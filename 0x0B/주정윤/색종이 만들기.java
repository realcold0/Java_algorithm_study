package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static int[][] board;
    public static int white = 0, blue = 0;

    public static void recur(int row, int col, int N){
        int sum = 0;

        for(int i=row; i<row+N; i++){
            for(int j=col; j<col+N; j++){
                sum += board[i][j];
            }
        }

        if(sum==0){
            white++;
        } else if(sum == N*N){
            blue++;
        } else {
            int half = N / 2;
            recur(row, col, half); // 왼쪽 위
            recur(row, col + half, half); // 오른쪽 위
            recur(row + half, col, half); // 왼쪽 아래
            recur(row + half, col + half, half); // 오른쪽 아래
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전체 종이의 한 변의 길이 N
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        recur(0, 0, N);
        System.out.println(white);
        System.out.println(blue);

    }
}
