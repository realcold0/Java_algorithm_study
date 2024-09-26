import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
    static int min = Integer.MAX_VALUE;
    static int n;
    static int m;
    static int[] dy = { -1, 0 , 1};
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j < m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //6 * 6 일때
        //6 * 6 * 5 * 5 * 5 * 5
        for(int i = 0; i < m;i++){
            dfs(0, 0, -1, i);
        }

        bw.write(min +"\n");
        bw.flush();
        bw.close();
        br.close();
    }


    public static void dfs(int count, int sum, int dir, int current){
        if(count == n){
            min = Math.min(sum, min);
            return;
        }

        for(int i = 0; i < 3;i++){
            if(dir == i){ //이전과 같은 방향은 안가게
                continue;
            }
            int next = current + dy[i];
            if(next < m && next>= 0){
                dfs(count + 1, sum  + arr[count][current], i, next);
            }
        }


    }
}
