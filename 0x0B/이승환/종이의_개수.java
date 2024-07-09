import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[][] map;
    public static int[] count = {0 , 0 , 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i< n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(n, 0, 0);

        for (int i : count) {
            sb.append(i).append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    public static void recur(int size, int x , int y){
        if(size == 1){
            count[map[x][y] + 1]++;
            return;
        }
        int tmp = map[x][y];
        boolean flag = true;
        for(int i = x; i < x + size ; i++){
            for(int j = y ; j < y + size ; j++){
                if(tmp != map[i][j]){
                    flag = false; //다른게 있다.
                }
            }
        }

        if(flag){

            count[map[x][y] + 1]++;
            return;
        }
        //다른게 있다면 recur해야한다.
        int newSize = size/3;
        recur(newSize, x, y);
        recur(newSize, x + newSize, y);
        recur(newSize, x + newSize *2, y);

        recur(newSize, x, y + newSize);
        recur(newSize, x + newSize, y + newSize);
        recur(newSize, x + newSize *2, y+ newSize);

        recur(newSize, x, y + newSize * 2);
        recur(newSize, x + newSize, y + newSize * 2);
        recur(newSize, x + newSize *2, y + newSize * 2);

    }
}
