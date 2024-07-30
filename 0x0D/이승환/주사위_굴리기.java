import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int cx = 0;
    static int cy = 0;
    static int n;
    static int m;
    static int[][] map;
    static int[][] dice;
    static int[][] dicePosition = {{0, 0}, {1, 1}, {0, 1}, {1, 2}, {1, 0}, {2, 1}, {3, 2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        //주사위
        dice = new int[4][3];
        //현재 위치
        cx = x;
        cy = y;
        //맵 초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case 1:
                    moveRight();
                    break;
                case 2:
                    moveLeft();
                    break;
                case 3:
                    moveTop();

                    break;
                case 4:
                    moveDown();
                    break;
                default:
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void moveDice(int pos1, int pos2) {
        dice[dicePosition[pos1][0]][dicePosition[pos1][1]] = dice[dicePosition[pos2][0]][dicePosition[pos2][1]];
    }

    public static int getDicePostition(int pos) {
        return dice[dicePosition[pos][0]][dicePosition[pos][1]];
    }

    public static void setDicePostition(int pos, int value) {
        dice[dicePosition[pos][0]][dicePosition[pos][1]] = value;
    }

    public static void moveRight() {
        cy += 1;
        if (cy >= m) {
            cy -= 1;
            return;
        }
        int tmp = dice[dicePosition[3][0]][dicePosition[3][1]];
        moveDice(3, 1);
        moveDice(1, 4);
        moveDice(4, 6);
        dice[dicePosition[6][0]][dicePosition[6][1]] = tmp;

        if (map[cx][cy] == 0) {
            map[cx][cy] = getDicePostition(6);
        } else {
            setDicePostition(6, map[cx][cy]);
            map[cx][cy] = 0;
        }
        sb.append(getDicePostition(1)).append("\n");
    }

    public static void moveTop() {
        cx -= 1;
        if (cx < 0) {
            cx += 1;
            return;
        }
        int tmp = dice[dicePosition[2][0]][dicePosition[2][1]];
        moveDice(2, 1);
        moveDice(1, 5);
        moveDice(5, 6);
        dice[dicePosition[6][0]][dicePosition[6][1]] = tmp;

        if (map[cx][cy] == 0) {
            map[cx][cy] = getDicePostition(6);
        } else {
            setDicePostition(6, map[cx][cy]);
            map[cx][cy] = 0;
        }
        sb.append(getDicePostition(1)).append("\n");
    }

    public static void moveLeft() {
        cy -= 1;
        if (cy < 0) {
            cy += 1;
            return;
        }
        int tmp = dice[dicePosition[4][0]][dicePosition[4][1]];
        moveDice(4, 1);
        moveDice(1, 3);
        moveDice(3, 6);
        dice[dicePosition[6][0]][dicePosition[6][1]] = tmp;

        if (map[cx][cy] == 0) {
            map[cx][cy] = getDicePostition(6);
        } else {
            setDicePostition(6, map[cx][cy]);
            map[cx][cy] = 0;
        }
        sb.append(getDicePostition(1)).append("\n");
    }

    public static void moveDown() {
        cx += 1;
        if (cx >= n) {
            cx -= 1;
            return;
        }
        int tmp = dice[dicePosition[6][0]][dicePosition[6][1]];
        moveDice(6, 5);
        moveDice(5, 1);
        moveDice(1, 2);
        dice[dicePosition[2][0]][dicePosition[2][1]] = tmp;

        if (map[cx][cy] == 0) {
            map[cx][cy] = getDicePostition(6);
        } else {
            setDicePostition(6, map[cx][cy]);
            map[cx][cy] = 0;
        }
        sb.append(getDicePostition(1)).append("\n");
    }
}
