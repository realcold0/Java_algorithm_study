
import java.io.*;
import java.util.*;
public class 종이의_개수 {
    // -1개수, 0 개수 1 개수
    static int[] answer = {0,0,0};
    static int[][] map;
    void recur(int startX, int startY,int n) {
        if (n ==1) {
            answer[map[startY][startX] +1 ] += 1;
            return;
        }
        int cmp = map[startY][startX];
        boolean flag= true;
        //같은 숫잔지 파악하기
        for (int i = startX; i < startX+n; i++) {
            for (int j = startY; j < startY+n; j++) {
                if (map[j][i] != cmp) {
                    flag = false;
                    break;
                }
            }
        }
        //같은 숫자라면
        if (flag) {
            answer[cmp + 1] +=1;
            return;
        }else{ //다른 숫자가 끼어있다면 9개로 쪼개기
            int new_size = n / 3;
            for(int i = 0 ; i<3;i++){
                for(int j = 0 ; j<3;j++){
                    recur(startX + i*new_size,startY + j*new_size,new_size);
                }
            }
        }
        return;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st ;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Main main = new Main();
        main.recur(0,0,N);
        bw.write(String.valueOf(answer[0])+"\n");
        bw.write(String.valueOf(answer[1])+"\n");
        bw.write(String.valueOf(answer[2]));
        bw.flush();
        bw.close();


    }
}
