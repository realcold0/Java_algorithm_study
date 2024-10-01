import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> keys = new HashSet<>();
        for (int i = 0; i < n; i++) {
            keys.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            String[] oneLine = br.readLine().split(",");
            for(String one : oneLine ){
                if(keys.contains(one)){
                    keys.remove(one);

                }
            }
            sb.append(keys.size()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
