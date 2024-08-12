

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution{
    int[][]map;
    int[] commands;
    int r;
    int c;

    public Solution(int[][] map, int[] commands, int r, int c) {
        this.map = map;
        this.commands = commands;
        this.r = r;
        this.c = c;
    }

    int[][] dirs = {{0,0},{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; //더미, 동 서 북 남
    int[] dice = {0,0,0,0,0,0}; // 아래, 북,서,남,동, 위
    /*
        1          1
       204   =동> 045
        3          3
        5          2

            =서=>  1
                  520
                   3
                   4

            =북=>  5
                  214
                   0
                   3

            =남=>  0
                  234
                   5
                   1


     */
    void rollingDice(int command){
        int[] temp = Arrays.copyOf(dice, dice.length);
        switch(command){
            case 1: //동
                dice[0] = temp[4];
                dice[2] = temp[0];
                dice[4] = temp[5];
                dice[5] = temp[2];
            break;
            case 2: // 서
                dice[0] = temp[2];
                dice[1] = temp[1];
                dice[2] = temp[5];
                dice[3] = temp[3];
                dice[4] = temp[0];
                dice[5] = temp[4];
            break;
            case 3: //북
                dice[0] = temp[1];
                dice[1] = temp[5];
                dice[2] = temp[2];
                dice[3] = temp[0];
                dice[4] = temp[4];
                dice[5] = temp[3];
            break;
            case 4: //남
                dice[0] = temp[3];
                dice[1] = temp[0];
                dice[2] = temp[2];
                dice[3] = temp[5];
                dice[4] = temp[4];
                dice[5] = temp[1];
            break;
        }
    }

    void solution(){
        for(int command : commands){
            int nr = r+ dirs[command][0];
            int nc = c + dirs[command][1];

            //맵 밖을 나갔다면 continue
            if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length){ continue;}

            rollingDice(command);

            //맵이 0일 때 주사위의 바닥면을 복사
            if(map[nr][nc] == 0){
                map[nr][nc] = dice[0];
            } else{
                dice[0] = map[nr][nc];
                map[nr][nc] = 0;
            }

            //주사위 위치 바꾸기
            r= nr;
            c= nc;
            System.out.println(dice[5]);

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
        int diceR = Integer.parseInt(st.nextToken());
        int diceC = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[]commands = new int[k];
        st=  new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            commands[i] = Integer.parseInt(st.nextToken());
        }
        Solution solution = new Solution(map, commands, diceR, diceC);
        solution.solution();


    }
}
