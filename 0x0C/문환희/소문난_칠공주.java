import java.io.*;
import java.util.*;

public class 소문난_칠공주 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] map = new char[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int[][] nynx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int count = 0;

    static boolean check(int[] comb, int[] points) {
        int count = 0;
        for (int i : comb) {
            int y = points[i] / 5;
            int x = points[i] % 5;
            if (map[y][x] == 'S') {
                count++;
            }
        }
        return count >= 4;
    }

    static boolean bfs(int[] comb, int[] points) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[5][5];
        int startY = points[comb[0]] / 5;
        int startX = points[comb[0]] % 5;
        queue.add(new int[]{startY, startX});
        visited[startY][startX] = true;

        int connectedCount = 1;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int y = curr[0];
            int x = curr[1];

            for (int[] dir : nynx) {
                int ny = y + dir[0];
                int nx = x + dir[1];
                if (ny >= 0 && nx >= 0 && ny < 5 && nx < 5 && !visited[ny][nx]) {
                    for (int i : comb) {
                        if (points[i] == ny * 5 + nx) {
                            visited[ny][nx] = true;
                            queue.add(new int[]{ny, nx});
                            connectedCount++;
                        }
                    }
                }
            }
        }

        return connectedCount == 7;
    }

    static void backtrack(int[] points, int start, int depth, int[] comb) {
        if (depth == 7) {
            if (check(comb, points) && bfs(comb, points)) {
                count++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            comb[depth] = i;
            backtrack(points, i + 1, depth + 1, comb);
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[] points = new int[25];
        for (int i = 0; i < 25; i++) {
            points[i] = i;
        }

        backtrack(points, 0, 0, new int[7]);

        System.out.println(count);
    }
}
