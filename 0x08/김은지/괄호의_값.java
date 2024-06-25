import java.io.*;
import java.util.LinkedList;
import java.util.Stack;

public class 괄호의_값 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] line = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int tmp = 1;
        int ans = 0;
        boolean flag = true;
        for(int idx =0 ; idx < line.length;idx++){
            switch (line[idx]){
                case '(':
                    tmp *=2;
                    stack.add(line[idx]);
                    break;
                case '[':
                    stack.add(line[idx]);
                    tmp *=3;
                    break;
                case ')':
                    if(stack.isEmpty() || stack.peek() !='('){
                        flag = false;
                        break;
                    }
                    if(line[idx-1] =='('){
                        ans += tmp;
                    }
                    tmp /=2;
                    stack.pop();
                    break;
                case ']':
                    if(stack.isEmpty() || stack.peek() !='['){
                        flag = false;
                        break;
                    }
                    if(line[idx-1] =='['){
                        ans += tmp;
                    }
                    tmp /=3;
                    stack.pop();
                    break;
            }
        }
        if(stack.isEmpty() && flag){
            bw.write(String.valueOf(ans));
        }else{
            bw.write("0");
        }

        bw.flush();
        bw.close();
    }
}
