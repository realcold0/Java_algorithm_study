import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static boolean[] checked;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        arr = new int[n];
        checked = new boolean[n];
        for (int i =0;i< n;i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        if(s == 0){
            answer = -1;
        }
        else{
            answer = 0;
        }
        dfs(n, s, 0, 0);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int n, int s, int sum, int count){
        if(count == n){
            if(sum ==  s){
                answer++;
            }
            return;
        }
        dfs(n ,  s , sum + arr[count], count + 1); //골랐을때
        dfs(n, s, sum, count + 1);

    }
}
