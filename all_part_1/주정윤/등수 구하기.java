import java.io.*;
import java.util.*;

public class 등수 구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        
        int[] scores = new int[n];
        if (n > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }
        }
        
        if (n == 0) {
            System.out.println(1);
            return;
        }
        
        if (n == p && newScore <= scores[n - 1]) {
            System.out.println(-1);
            return;
        }
        
        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (newScore < scores[i]) {
                rank++;
            } else {
                break;
            }
        }
        
        System.out.println(rank);
    }
}
