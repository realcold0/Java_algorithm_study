import java.io.*;
import java.util.*;

public class 스티커붙이기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] notebook = new int[N][M];
        
        List<int[][]> stickers = new ArrayList<>();
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[R][C];
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            stickers.add(sticker);
        }
        
        for (int[][] sticker : stickers) {
            boolean attached = false;
            
            for (int r = 0; r < 4; r++) { // 0도, 90도, 180도, 270도 회전
                if (attached) break;
                
                int rows = sticker.length;
                int cols = sticker[0].length;
                
                for (int i = 0; i <= N - rows; i++) {
                    if (attached) break;
                    for (int j = 0; j <= M - cols; j++) {
                        if (canAttach(notebook, sticker, i, j)) {
                            attach(notebook, sticker, i, j);
                            attached = true;
                            break;
                        }
                    }
                }
                
                if (!attached) {
                    sticker = rotate(sticker);
                }
            }
        }
        
        bw.write(countFilledCells(notebook) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int[][] rotate(int[][] sticker) {
        int rows = sticker.length;
        int cols = sticker[0].length;
        int[][] rotated = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotated[j][rows - 1 - i] = sticker[i][j];
            }
        }
        return rotated;
    }

    public static boolean canAttach(int[][] notebook, int[][] sticker, int startRow, int startCol) {
        int stickerRows = sticker.length;
        int stickerCols = sticker[0].length;
        
        for (int i = 0; i < stickerRows; i++) {
            for (int j = 0; j < stickerCols; j++) {
                if (sticker[i][j] == 1 && notebook[startRow + i][startCol + j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void attach(int[][] notebook, int[][] sticker, int startRow, int startCol) {
        int stickerRows = sticker.length;
        int stickerCols = sticker[0].length;
        
        for (int i = 0; i < stickerRows; i++) {
            for (int j = 0; j < stickerCols; j++) {
                if (sticker[i][j] == 1) {
                    notebook[startRow + i][startCol + j] = 1;
                }
            }
        }
    }

    public static int countFilledCells(int[][] notebook) {
        int count = 0;
        for (int[] row : notebook) {
            for (int cell : row) {
                if (cell == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
