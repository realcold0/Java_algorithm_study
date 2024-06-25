import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<Character>();
        String s = br.readLine();
        s = s.replace("()", "2");
        s = s.replace("[]", "3"); // 전처리

        int ans = 0;

        for (char c : s.toCharArray()) {
            if (c == ']' || c == ')') {
                char first = stack.pop();
                char second = stack.pop();
                if (second == '[') {
                    int tmp = Character.getNumericValue(first) * 3;
                    stack.push((char) (tmp + '0'));
                } else if (second == '(') {
                    int tmp = Character.getNumericValue(first) * 2;
                    stack.push((char) (tmp + '0'));
                } else { // 숫자일 경우 더하기
                    int tmp = Character.getNumericValue(first) + Character.getNumericValue(second);
//                    System.out.println(first); // 9
//                    System.out.println(second); // 2
//                    System.out.println(tmp); // 11
//                    System.out.println((char) (tmp + '0'));
                    stack.push((char) (tmp + '0'));
                }
            } else {
                stack.push(c);
            }
        }

        ans = Character.getNumericValue(stack.pop());

        if (!stack.empty()) {
            ans = 0;
        }

        System.out.println(ans);
    }
}
