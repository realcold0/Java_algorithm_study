import java.io.*;
import java.util.Stack;

public class 괄호의_값 {
    static Stack<Character> stack;

    static int cal(char start) {
        int result = 0;

        while (!stack.isEmpty()) {
            char ch = stack.pop();

            if (ch == '(' || ch == '[') {
                result += cal(ch);
            } else if (start == '(' && ch == ')') {
                return 2 * Math.max(1, result);
            } else if (start == '[' && ch == ']') {
                return 3 * Math.max(1, result);
            }
        }

        // 스택이 비었는데 올바른 반환이 이루어지지 않은 경우, 잘못된 괄호열로 간주
        System.out.println(0);
        System.exit(0);
        return 0; // This will never be reached but is required to compile
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();

        stack = new Stack<>();
        for (int i = input.length() - 1; i >= 0; i--) {
            stack.push(input.charAt(i));
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += cal(stack.pop());
        }

        System.out.println(ans);
    }
}
