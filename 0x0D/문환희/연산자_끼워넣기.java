import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 연산자_끼워넣기 {
    static int n;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Integer> ops = new ArrayList<>();
    static boolean[] check;
    static Stack<Integer> stack = new Stack<>();

    static int calculate(int[] numbers) {
        int result = numbers[0];
        for (int i = 0; i < stack.size(); i++) {
            int num = numbers[i + 1];
            switch (stack.get(i)) {
                case 0: // '+'
                    result += num;
                    break;
                case 1: // '-'
                    result -= num;
                    break;
                case 2: // '*'
                    result *= num;
                    break;
                case 3: // '/'
                    result /= num;
                    break;
            }
        }
        return result;
    }

    // 연산자 조합을 DFS로 생성하고 최대, 최소 결과를 계산
    static void dfs(int L) {
        if (L == ops.size()) {
            int result = calculate(arr);
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        for (int i = 0; i < ops.size(); i++) {
            if (!check[i]) {
                int op = ops.get(i);
                check[i] = true;
                stack.push(op);
                dfs(L + 1);
                stack.pop();
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] opsCnt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < opsCnt[i]; j++) {
                ops.add(i);
            }
        }
        check = new boolean[ops.size()];
        int[] operatorArray = new int[n - 1];
        dfs(0);

        System.out.println(max);
        System.out.println(min);
    }
}
