import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Sticker {
    private int n;
    private int m;
    int[][] Area;

    public Sticker(int n, int m, int[][] area) {
        this.n = n;
        this.m = m;
        Area = area;
    }

    void rotate() {
        int[][] newArea = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newArea[i][j] = Area[n - 1 - j][i];
            }
        }
        Area = newArea;
        n = Area.length;
        m = Area[0].length;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public int[][] getArea() {
        return Area;
    }
}

class Solution {
    private int[][] map;
    private Sticker[] Stickers;

    public Solution(int[][] map, Sticker[] stickers) {
        this.map = map;
        Stickers = stickers;
    }

    // 솔루션 메인함수
    int solution() {
        // 각 스티커 노트북에 붙이기
        for (Sticker s : Stickers) {
            // 4회전 시도
            for (int j = 0; j < 4; j++) {
                boolean flag = false;
                // 맵 왼쪽 위부터 스티커 붙일 수 있는지 확인하기
                for (int startr = 0; startr <= map.length - s.getN(); startr++) {
                    for (int startc = 0; startc <= map[0].length - s.getM(); startc++) {
                        if (canPlaceSticker(startr, startc, s)) {
                            placeSticker(startr, startc, s);
                            flag = true;
                            break;
                        }
                    }
                    if (flag) break;
                }
                if (flag) break;
                s.rotate();
            }
        }
        // 맵에 스티커 붙인 부분 계산하기
        return countMap();
    }

    int countMap() {
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) count++;
            }
        }
        return count;
    }

    boolean canPlaceSticker(int startr, int startc, Sticker s) {
        int[][] stickermap = s.getArea();
        for (int i = startr, stickerR = 0; i < startr + s.getN(); i++, stickerR++) {
            for (int j = startc, stickerC = 0; j < startc + s.getM(); j++, stickerC++) {
                if (stickermap[stickerR][stickerC] == 1 && map[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    void placeSticker(int startr, int startc, Sticker s) {
        int[][] stickermap = s.getArea();
        for (int i = startr, stickerR = 0; i < startr + s.getN(); i++, stickerR++) {
            for (int j = startc, stickerC = 0; j < startc + s.getM(); j++, stickerC++) {
                if (stickermap[stickerR][stickerC] == 1) {
                    map[i][j] = 1;
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        Sticker[] stickers = new Sticker[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int Stickern = Integer.parseInt(st.nextToken());
            int Stickerm = Integer.parseInt(st.nextToken());
            int[][] area = new int[Stickern][Stickerm];
            for (int r = 0; r < Stickern; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < Stickerm; c++) {
                    area[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            Sticker s = new Sticker(Stickern, Stickerm, area);
            stickers[i] = s;
        }
        Solution sol = new Solution(map, stickers);
        System.out.println(sol.solution());
    }
}
