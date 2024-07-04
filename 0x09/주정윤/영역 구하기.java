package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static int[][] box;
    public static boolean[][] visited;
    public static int N, M, K;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class pos {
        int x;
        int y;

        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs(int x, int y) {
        Queue<pos> queue = new LinkedList<>();
        queue.offer(new pos(x, y));
        visited[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            pos p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (0 <= nx && nx < M && 0 <= ny && ny < N) {
                    // 방문한 적이 없고 내부 좌표가 아닐 경우
                    if (!visited[nx][ny] && box[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        queue.offer(new pos(nx, ny));
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // M은 상자의 가로 칸의 수, N은 상자의 세로 칸 수
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 다음에 주어지는 입력을 저장할 배열
        box = new int[M][N];
        visited = new boolean[M][N];

        ArrayList<Integer> list = new ArrayList<>();

        // for문을 돌면서 값을 입력받는다
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            // 차례대로 x1, y1, x2, y2 입력
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    box[y][x] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && box[i][j] == 0) {
                    int data = bfs(i, j);
                    list.add(data);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(list);

        sb.append(list.size()).append("\n");

        for (int i : list) {
            sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
