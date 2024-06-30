
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<Character>();
            for(int j = 0; j < input.length(); j++){
                if(stack.isEmpty() || input.charAt(j) == '('){
                    stack.push(input.charAt(j));
                }else if(stack.peek() == '(' && input.charAt(j) == ')'){
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
