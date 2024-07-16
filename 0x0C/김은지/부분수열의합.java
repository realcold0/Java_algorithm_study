import java.util.*;
import java.io.*;

public class 부분수열의합
{
    static int[] arr;
    static int n;
    static int s;
    static int ans = 0;
    public static void recur(int idx, int sum ){ 
    if(idx==n){
        if(sum == s){
            ans++;
        }
        return;
    }
    recur(idx+1,sum+arr[idx]);
    recur(idx+1,sum);

    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new InputStream(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        recur(0,0);
        if(s ==0){
            bw.write(String.valueOf((ans-1)));
            return;
        }
        bw.write(String.valueOf((ans)));
        bw.flush();
        bw.close();
        br.close();
    }
}