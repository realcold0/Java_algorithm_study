import java.util.*;
import java.io.*;

public class Boj_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for( int i = 0 ; i < N ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int answer =0;

        for (int i = 0; i < arr.length; i++){
            int compare = arr[i];
            for (int j = i+1; j < arr.length ; j++){

                if(arr[j]+ compare == x){
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
