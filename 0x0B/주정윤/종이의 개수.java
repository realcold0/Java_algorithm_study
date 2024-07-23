package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static int[][] board;
    public static int white = 0, blue = 0;
    public static int[] arr = new int[3];

    public static void recur(int row, int col, int N){
        if(checkNum(row, col, N)){
            int num = board[row][col];

            switch (num){
                case -1:
                    arr[0]++;
                    break;
                case 0:
                    arr[1]++;
                    break;
                case 1:
                    arr[2]++;
                    break;
            }
        } else {
            int size = N / 3;

            recur(row, col, size); //1
            recur(row, col+size, size); //2
            recur(row, col+size*2, size); //3

            recur(row+size, col, size);
            recur(row+size, col+size, size);
            recur(row+size, col+size*2, size);

            recur(row+size*2, col, size);
            recur(row+size*2, col+size, size);
            recur(row+size*2, col+size*2, size);

        }
    }

    public static boolean checkNum(int x, int y, int N){
        int temp = board[x][y];
        boolean chk = true;

        for(int i=x; i<x+N; i++){
            for(int j=y; j<y+N; j++){
                if(temp != board[i][j]){
                    chk = false;
                    break;
                }
            }
        }

        return chk;
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

        for(int a : arr){
            System.out.println(a);
        }

    }
}
