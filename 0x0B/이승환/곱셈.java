import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long result = recur(a, b, c);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    public static long recur(int a, int b, int c){
        if(b == 1){
            return a%c;
        }
        long tmp = recur(a, b /2, c);

        if(b % 2 == 1){
            return (tmp * tmp  %c) * a %c;
        }
        return tmp * tmp % c;

    }





}