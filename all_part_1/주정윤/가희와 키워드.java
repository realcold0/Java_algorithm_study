import java.io.*;
import java.util.*;

public class 가희와 키워드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        HashSet<String> memo = new HashSet<>();

        for (int i = 0; i < n; i++) {
            memo.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String[] words = br.readLine().split(",");
            for (String word : words) {
                memo.remove(word);
            }
            bw.write(memo.size() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
