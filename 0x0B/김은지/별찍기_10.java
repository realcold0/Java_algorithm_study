
import java.io.*;
import java.util.Arrays;

public class 별찍기_10 {
    static char[][] map;



    public static void recur(int x, int y, int n){
        if (n ==3){
            //가운데 0 나머지 1
            for(int i = x; i<x+n ;i++){
                for(int j = y; j<y+n ;j++){
                    if(i == x+1 && j == y+1){
                        continue;
                    }
                    map[j][i] = '*';
                }
            }
            return;
        }
        //9등분 하고, 가운데 빼고 recur 돌기
        int next_n = n /3;
        for(int i = 0; i < 3;i++){
            for(int j = 0; j < 3;j++){
                if(i ==1 && j ==1){
                    continue;
                }
                recur(x+i*next_n,y+j*next_n,next_n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        map = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(map[i], ' ');

        }
        recur(0,0,n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
