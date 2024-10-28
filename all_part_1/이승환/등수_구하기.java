import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int taesu = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int result = 1;
        List<Integer> list = new ArrayList<>();

        if (n!=0) {
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int[] rank = new int[p];
            int[] index = new int[p];
            for (int i=0; i<p; i++) {
                if (list.size()>i) {
                    rank[i] = list.get(i);
                    if (i!=0) {
                        if (rank[i]==rank[i-1]) index[i] = index[i-1];
                        else index[i] = i+1;
                    }
                    else index[i] = 1;
                }
                else rank[i] = -1;
            }

            for (int i=0; i<p; i++) {
                if (rank[i] < taesu) {
                    if (i!=0 && rank[i-1] == taesu) result = index[i-1];
                    else {
                        if (index[i]==0) result = i+1;
                        else result = index[i];
                    }
                    break;
                }
                if (i==p-1) result = -1;
            }
        }

        System.out.println(result);
    }
}