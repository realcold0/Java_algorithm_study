import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            boolean isPossible = false;

            String first = st.nextToken();
            String sec = st.nextToken();
            char[] firstCharArr = first.toCharArray();
            char[] secCharArr = sec.toCharArray();

            Arrays.sort(firstCharArr);
            Arrays.sort(secCharArr);

            if (Arrays.equals(firstCharArr, secCharArr)) {
                sb.append("Possible").append("\n");
            } else {
                sb.append("Impossible").append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
