import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<Character>();
            String s = br.readLine();

            stack.push(s.charAt(0)); // 맨 처음 글자는 무조건 push

            for (int j = 1; j < s.length(); j++) { // peek이랑 같으면 pop, 다르면 push 해서 empty인지 아닌지 확인
                char c = s.charAt(j);
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            if (stack.isEmpty()) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
