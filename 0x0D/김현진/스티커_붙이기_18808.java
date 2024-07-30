import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노트북 가로
        int m = Integer.parseInt(st.nextToken()); // 노트북 세로
        int k = Integer.parseInt(st.nextToken()); // 스티커 개수

        int[][] notebook = new int[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[row][col];

            for (int j = 0; j < row; j++) {
                st = new StringTokenizer(br.readLine());
                for (int p = 0; p < col; p++) {
                    sticker[j][p] = Integer.parseInt(st.nextToken());
                }
            }

            boolean pasted = false; // 스티커 붙였는지 여부

            for (int j = 0; j < 4; j++) { // 스티커를 최대 4번 회전
                if (pasted) break; // 이미 붙였으면 종료

                for (int x = 0; x <= n - sticker.length; x++) { // 노트북의 각 위치에서
                    if (pasted) break;

                    for (int y = 0; y <= m - sticker[0].length; y++) {
                        if (canPaste(notebook, sticker, x, y)) { // 현재 위치에 붙일 수 있을 경우
                            pasteSticker(notebook, sticker, x, y);
                            pasted = true;
                            break;
                        }
                    }
                }

                if (!pasted) { // 현재 상태로 붙일 수 없으면
                    sticker = rotateSticker(sticker); // 스티커를 90도 회전
                }
            }
        }

        bw.write(Integer.toString(countPasted(notebook)));
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean canPaste(int[][] notebook, int[][] sticker, int startX, int startY) { // 주어진 위치에 스티커를 붙일 수 있는지 확인
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[i].length; j++) {
                if (sticker[i][j] == 1 && notebook[startX + i][startY + j] == 1) {
                    return false; // 스티커와 노트북이 겹치는 부분이 있을 경우
                }
            }
        }
        return true;
    }

    static void pasteSticker(int[][] notebook, int[][] sticker, int startX, int startY) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[i].length; j++) {
                if (sticker[i][j] == 1) {
                    notebook[startX + i][startY + j] = 1;
                }
            }
        }
    }

    static int[][] rotateSticker(int[][] sticker) { // 스티커를 90도 회전
        int row = sticker.length;
        int col = sticker[0].length;
        int[][] rotated = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rotated[j][row - 1 - i] = sticker[i][j];
            }
        }
        return rotated;
    }

    static int countPasted(int[][] notebook) {// 붙인 스티커 개수 count
        int count = 0;
        for (int[] row : notebook) {
            for (int cell : row) {
                if (cell == 1) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
