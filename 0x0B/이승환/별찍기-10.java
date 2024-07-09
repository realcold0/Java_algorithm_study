import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for(int i = 0;i<n;i++){
            Arrays.fill(map[i], '*');
        }

        recur(n, 0 , 0);

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i< n; i++){
            for(int j = 0;j<n;j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void recur(int size, int x , int y){
        if(size == 3){
            map[x + 1][y+ 1] = ' ';
            return;
        }

        int nextSize = size / 3;
        for(int i = x + nextSize; i < x + nextSize * 2; i++){
            for(int j = y + nextSize; j < y + nextSize * 2;j++){
                map[i][j]  = ' ';
            }
        }


        recur(nextSize, x, y);
        recur(nextSize, x + nextSize, y);
        recur(nextSize, x + nextSize * 2, y);

        recur(nextSize, x, y + nextSize);
        recur(nextSize, x+ nextSize * 2, y + nextSize );

        recur(nextSize, x , y + nextSize * 2);
        recur(nextSize, x + nextSize, y + nextSize * 2);
        recur(nextSize, x + nextSize * 2, y + nextSize * 2);


    }
}
