import java.io.*;
import java.util.Stack;

public class 키로거 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            for (char c : command.toCharArray()) {

                if (c == '<') {
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                } else if (c == '>') {
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                } else if (c == '-') {
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                } else {
                    leftStack.push(c);
                }
            }

            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }

            while (!rightStack.isEmpty()) {
                bw.write(rightStack.pop());
            }
            bw.write('\n');
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
