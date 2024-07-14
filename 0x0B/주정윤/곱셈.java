
import java.io.*;
import java.util.*;

public class Main {

    public static long recur(long a, long b, long c){
        //A를 B번 곱하기
        if(b==1) return a % c; //b가 1이면 그대로 나머지를 리턴

        //result의 값에 재귀로 b/2 값을 호출 -> 10 11승 / 10 5승 / 10 2승 / 10 1승
        long result = recur(a, b/2, c);

        // ---------------------
        //after 재귀
        result = result * result % c;
        if(b%2==0) return result; //b가 짝수라면 result를 반환
        return result * a % c;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // A, B, C 입력 받기
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        System.out.println(recur(A, B, C));

    }
}
