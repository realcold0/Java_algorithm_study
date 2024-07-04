import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Object> stack = new Stack<>();
        String s = br.readLine();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else {
                int tmp = 0;

                while (!stack.isEmpty() && stack.peek() instanceof Integer) { // 스택이 비어있지 않고 맨 위 값이 정수일 경우
                    tmp += (int) stack.pop();
                }

                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }

                if (c == ')') {
                    if (stack.peek().equals('(')) {
                        stack.pop();
                        tmp = (tmp == 0) ? 2 : 2 * tmp;
                    } else {
                        System.out.println(0);
                        return;
                    }
                } else if (c == ']') {
                    if (stack.peek().equals('[')) {
                        stack.pop();
                        tmp = (tmp == 0) ? 3 : 3 * tmp;
                    } else {
                        System.out.println(0);
                        return;
                    }
                }

                stack.push(tmp);
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            if (stack.peek().equals('(') || stack.peek().equals('[')) {
                System.out.println(0);
                return;
            }
            ans += (int) stack.pop();
        }

        System.out.println(ans);
    }
}