import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] count = {0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i< n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(n, 0,0);

        sb.append(count[0]).append("\n").append(count[1]);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    public static void recur(int size, int x, int y){
        if(size == 1) {
            count[map[x][y]]++;
            return;
        }
        int tmp = map[x][y];
        boolean flag = true;
        for(int i = x; i < x + size;i++){
            for(int j= y; j < y + size;j++){
                if(tmp != map[i][j]){
                    flag = false;
                }
            }
        }

        if(flag){ //모두 같다면
            count[map[x][y]]++;
            return;
        }
        //같지 않다면
        int nextSize = size/2;
        recur(nextSize , x,y );
        recur(nextSize, x + nextSize, y);
        recur(nextSize, x, y + nextSize);
        recur(nextSize, x + nextSize, y + nextSize);

    }
}
