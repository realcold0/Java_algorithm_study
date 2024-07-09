package boj.recursive.색종이_만들기;

import java.io.*;
import java.util.StringTokenizer;

public class 색종이_만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private int[][] map;
    //하양, 파랑
    private int[] answer ={0,0};
    private int N;

    Main(int N) throws IOException {
        this.N = N;
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public String getAnswer() {
        recur(0,0,N);
        StringBuilder sb = new StringBuilder();
        sb.append(answer[0]).append("\n");
        sb.append(answer[1]);
        return sb.toString();
    }

    void recur(int x, int y, int n) {
        if(n ==1){
            answer[map[y][x]] += 1;
            return;
        }
        //맵이 하나의 색깔인지 확인
        int cmp = map[y][x];
        boolean flag = true;
        for(int i = x; i < x+n; i++) {
            for(int j = y; j < y+n; j++) {
                if(map[j][i] != cmp) {
                    flag = false;
                    break;
                }
            }
        }
        if(flag) {
            answer[map[y][x]] += 1;
            return;
        }else{
            int next_n = n /2;
            for(int i =0 ; i< 2;i++){
                for(int j =0 ; j< 2;j++){
                    recur(x + i*next_n,y + j*next_n,next_n);
                }
            }
        }

    }



    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        //객체 생성과 동시에 맵 생성
        Main main = new Main(N);

        bw.write(main.getAnswer());
        bw.flush();
        bw.close();
    }
}
