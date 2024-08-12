import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        arr[1] = 0;

        //점화식
        /*
         arr[n] = Math.min( arr[n/3] +1, arr[n/2] +1, arr[n-1] +1);
        */

        for(int i = 2; i <= n; i++){
            arr[i] = arr[i-1] +1;
            if(i%2 ==0) arr[i] = Math.min(arr[i],arr[i/2] +1);
            if(i%3 ==0) arr[i] = Math.min(arr[i],arr[i/3] +1);
        }

        bw.write(String.valueOf(arr[n]));
        bw.flush();
    }

}