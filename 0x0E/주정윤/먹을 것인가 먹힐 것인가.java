
import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 수의 개수
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[] A = new int[N];
            int[] B = new int[M];
            
            st = new StringTokenizer(br.readLine());
            
            for(int a=0; a<N; a++){
                A[a] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            
            for(int b=0; b<M; b++){
                B[b] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(B);
            
            int count = 0;
            for(int a : A){
                count += search(B, a);
            }
            
            sb.append(count).append('\n');
        }

        System.out.println(sb);

    }
    
    private static int search(int[] B, int a){
        int left = 0;
        int right = B.length - 1;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(B[mid] < a) left = mid + 1;
            else right = mid - 1;
        }
        
        return left;
    }

}
