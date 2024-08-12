import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String input = "";
        next:
        while(true){
            input = br.readLine();
            if(input.equals(".")){
                break;
            }
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < input.length(); j++){
                if( input.charAt(j) == '(' || input.charAt(j) == '['){
                    stack.push(input.charAt(j));
                }else if(!stack.isEmpty() && stack.peek() == '(' && input.charAt(j) == ')'){
                    stack.pop();
                }
                else if( !stack.isEmpty() && stack.peek() == '[' && input.charAt(j) == ']'){
                    stack.pop();
                }
                else if(stack.isEmpty() && (input.charAt(j) == ')' || input.charAt(j) == ']')){
                    sb.append("no\n");
                    continue next;
                }else if(!stack.isEmpty() && stack.peek() != '(' && input.charAt(j) == ')'){
                    sb.append("no\n");
                    continue next;
                }else if(!stack.isEmpty() && stack.peek() != '[' && input.charAt(j) == ']'){
                    sb.append("no\n");
                    continue next;
                }
            }
            if(stack.isEmpty()){
                sb.append("yes\n");
            }else{
                sb.append("no\n");
            }

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
