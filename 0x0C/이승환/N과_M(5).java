import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] checked;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        checked = new boolean[n];
        result = new int[m];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<n;i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);
        dfs(n, m, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs(int n,int m, int count){
        if(count == m){
            for(int i =0;i<m;i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i =0;i<n;i++){
            if(checked[i] == false){
                checked[i] = true;
                result[count] = arr[i];
                dfs(n, m, count + 1);
                checked[i] = false;
            }
        }
    }
}
