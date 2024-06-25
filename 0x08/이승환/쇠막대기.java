
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int count = 0;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' ) {
                stack.push(c);
            }else if (c == ')') {
                char tmp = stack.pop();
                if(input.charAt(i -1 )=='('){//레이저 일때
                    count += stack.size();
                }else if (input.charAt(i - 1) ==')') { //레이저 덕분에 막대기 끝날때 앞에 무조건 다른 괄호 있음
                    count++;
                }
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();

    }
}
