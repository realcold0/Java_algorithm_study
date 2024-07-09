
import java.util.*;
import java.io.*;

public class 곱셈{

    public static long recur(long a, long b, long c){
        if(b == 0){
            return 1; // b가 0인 경우, 결과는 1이어야 함
        }
        if(b == 1){
            return a % c;
        }else{
            long val = recur(a, b/2, c);
            val = (val * val) % c; // 중복된 계산을 방지하기 위해 한 번 계산
            if(b % 2 == 0){
                return val;
            }else{
                return (val * a) % c;
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

        long result = recur(a, b, c);
        System.out.println(result);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
