import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<String>();
        for(int i = 0; i <n;i++) {
            set.add(br.readLine());
        }

        for(int i =0;i<m;i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), ",");
            while(st2.hasMoreTokens()) {
                String s = st2.nextToken();
                if(set.contains(s)) {
                    set.remove(s);
                }
            }
            bw.write(set.size() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
