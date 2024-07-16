import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class N과M_5 {
    static int N, M;
    static int[] arr;
    static Stack<Integer> stack = new Stack<>();
    static int[] ck;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void dfs(int L) throws IOException {
        if (L == M) {
            for(int i : stack) {
                bw.write(String.valueOf(arr[i]));
                bw.write(" ");
            }
            bw.newLine();
        }
        else {
            for(int i = 0; i < N; i++) {
                if(ck[i] == 0) {
                    ck[i] = 1;
                    stack.push(i);
                    dfs(L+1);
                    ck[i] = 0;
                    stack.pop();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];
        ck = new int[N];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        dfs(0);

        bw.flush();
        bw.close();
        br.close();
    }
}
