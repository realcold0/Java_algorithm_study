
import java.util.*;
import java.io.*;

public class 곱셈 {

    public static long recur(long a, long b, long c){
        if(b == 1){
            return a % b;
        }else{
            long val = recur(a, b/2, c);
            if( b%2==0){
                return (val*val) %c;
            }else{
                return (val*val*a) %c;
            }

        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        bw.write(String.valueOf(recur(a,b,c)));
        bw.flush();
        bw.close();
        br.close();
    }

}

