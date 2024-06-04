import java.io.*;
import java.util.*;

public class Boj_11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] str = new String[N][2];
        for (int i =0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            str[i][0] = st.nextToken();
            str[i][1] = st.nextToken();
        }
        for (int i =0 ; i< N; i++){
            char[] comp1 = str[i][0].toCharArray();
            char[] comp2 = str[i][1].toCharArray();
            Arrays.sort(comp1);
            Arrays.sort(comp2);
            if (Arrays.equals(comp1,comp2)){
                System.out.println("Possible");
            }else{
                System.out.println("Impossible");
            }
        }
    }
}
