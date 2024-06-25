import java.io.*;
import java.util.Stack;

public class 괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(Character c : input.toCharArray()){
                if(stack.isEmpty()){
                    stack.push(c);
                }
                else if(c == ')' && stack.peek() == '('){
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }
            if(stack.isEmpty()){
                bw.write("YES\n");
            }
            else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
