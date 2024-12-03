import java.io.*;
import java.util.*;

public class 어두운_굴다리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        Deque<Integer> dq = new ArrayDeque<Integer>();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            dq.addLast(Integer.parseInt(st.nextToken()));
        }
        int[] arr = dq.stream().mapToInt(Integer::intValue).toArray();
        int gap = 0;

        for (int i = 1; i < arr.length; i++) {
            gap = Math.max(gap, arr[i] - arr[i - 1]);
        }

        answer = Math.max(Math.max((gap + 1) / 2, arr[0]), n - arr[arr.length - 1]);

        System.out.println(answer);
    }
}
