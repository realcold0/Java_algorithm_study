package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static String[][] board;

    public static void recur(int x, int y, int N) {
        if (N == 1) {
            board[x][y] = "*";
            return;
        }

        int temp = N / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue; // 공백 영역 건너뛰기
                recur(x + i * temp, y + j * temp, temp);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        // 전체 종이의 한 변의 길이 N
        int N = Integer.parseInt(br.readLine());
        board = new String[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], " ");
        }

        recur(0, 0, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
