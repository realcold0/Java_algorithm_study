import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 부분수열의_합 {
    static int n,m;
    static int[] arr;
    static int answer;
    static int[] ck;
    static Stack<Integer> stack = new Stack<>();

    static void dfs(int L, int sum) {
        if (L == n) {
            if(sum == m) {
                answer ++;
            }
            return;
        }
        else {
            dfs(L + 1, sum + arr[L]);
            dfs(L + 1, sum);
        }
    }

    static void bfs() {
        int L = 0;
        Queue<int[]> q = new LinkedList<>();
        int sum = 0;
        q.offer(new int[]{L, sum});
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            if(pos[0] == n && pos[1] == m) {
                answer++;
            }
            if(pos[0] < n && pos[1] < m) {
                q.offer(new int[] {pos[0] + 1, pos[1] + arr[pos[0]]});
                q.offer(new int[] {pos[0] + 1, pos[1]});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        bfs();
        System.out.print(m == 0 ? answer - 1 : answer);
    }
}
