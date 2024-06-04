import java.io.*;
import java.util.*;

public class Boj_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> circle = new LinkedList<>();
        for (int i =1 ; i <= N; i++){
            circle.add(i);
        }
        System.out.print("<");
        while(N-- > 0){
            for (int idx= 1; idx<= K; idx++){
                if(idx == K){
                    System.out.print(circle.remove());
                    if(N !=0)
                        System.out.print(", ");
                }else{
                    circle.add(circle.remove());
                }
            }
        }
        System.out.print(">");
    }
}
