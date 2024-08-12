
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int tmp = 1;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(') {
                stack.push(input.charAt(i));
                tmp *= 2;
            }else if(input.charAt(i) == '[') {
                stack.push(input.charAt(i));
                tmp *= 3;
            }
            else if(input.charAt(i) == ')') {
                if(stack.isEmpty() || stack.peek() == '['){
                    answer = 0;
                    break;
                }else{
                    if(input.charAt(i-1) == '('){
                        stack.pop();
                        answer += tmp;
                        tmp /= 2;
                    }else if(stack.peek() == '('){
                        stack.pop();
                        tmp /= 2;
                    }
                }
            }
            else if(input.charAt(i) == ']') {
                if(stack.isEmpty() || stack.peek() == '('){
                    answer = 0;
                    break;
                }else{
                    if(input.charAt(i-1) == '['){
                        stack.pop();
                        answer += tmp;
                        tmp /= 3;
                    }else if(stack.peek() == '['){
                        stack.pop();
                        tmp /= 3;
                    }
                }
            }
        }

        if(!stack.isEmpty()){
            bw.write(String.valueOf(0));
        }else{
            bw.write(String.valueOf(answer));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}