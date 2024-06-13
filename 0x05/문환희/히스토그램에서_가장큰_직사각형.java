import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class 히스토그램에서_가장큰_직사각형 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int n = input[0];
            if (n == 0) break;
            long result = 0;
            Stack<Integer[]> stack = new Stack<>();

            for (int i = 1; i <= n; i++) {
                int idx = i;
                while (!stack.isEmpty() && stack.peek()[1] >= input[i]) {
                    Integer[] arr = stack.pop();
                    result = Math.max(result, (long) (i - arr[0]) * arr[1]);
                    idx = arr[0];
                }
                stack.push(new Integer[]{idx, input[i]});
            }

            while(!stack.isEmpty()) {
                Integer[] arr = stack.pop();
                result = Math.max(result, (long) (n  + 1 - arr[0]) * arr[1]);
            }

            System.out.println(result);
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
