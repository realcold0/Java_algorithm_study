import java.io.*;
import java.util.Stack;

public class 균형잡힌_세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            String input = br.readLine();
            if(input.equals(".")) {
                break;
            }
            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;
            for(Character c : input.toCharArray()){
                if(c == '(' || c == '[') {
                    stack.push(c);
                } else if(c == ')') {
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    } else {
                        isBalanced = false;
                        break;
                    }
                } else if(c == ']') {
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    } else {
                        isBalanced = false;
                        break;
                    }
                }
            }
            if(isBalanced && stack.isEmpty()){
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
