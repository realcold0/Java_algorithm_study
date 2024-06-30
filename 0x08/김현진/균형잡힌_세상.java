import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<Character>();
            boolean flag = true;

            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')' || c == ']') {
                    if (stack.isEmpty()){
                        flag = false;
                        break;
                    }
                    char tmp = stack.pop();
                    if ((c == ')' && tmp != '(') || (c == ']' && tmp != '[')) {
                        flag = false;
                    }
                }
            }

            if (!stack.isEmpty()) {
                flag = false;
            }

            if (flag) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
