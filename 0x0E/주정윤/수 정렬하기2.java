
import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수의 개수
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);

        for(int i = 0; i < N; i++){
            System.out.println(num[i]);
        }
    }

}
