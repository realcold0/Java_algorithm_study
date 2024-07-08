package com.company;

import java.io.*;

public class Main {
    public static char[][] board;

    public static void recur(int x, int y, int N) {
        if (N == 3) {
            board[x][y] = '*';
            board[x + 1][y - 1] = '*';
            board[x + 1][y + 1] = '*';
            board[x + 2][y - 2] = '*';
            board[x + 2][y - 1] = '*';
            board[x + 2][y] = '*';
            board[x + 2][y + 1] = '*';
            board[x + 2][y + 2] = '*';
            return;
        }

        int temp = N / 2;
        recur(x, y, temp); //맨 위
        recur(x + temp, y - temp, temp); //왼쪽
        recur(x + temp, y + temp, temp); //오른쪽
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new char[N][2 * N - 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                board[i][j] = ' ';
            }
        }

        recur(0, N - 1, N);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(board[i]);
            bw.write('\n');
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
