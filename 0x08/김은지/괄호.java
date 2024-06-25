import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class 괄호 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            char[] line = br.readLine().toCharArray();
            Deque<Character> stack = new LinkedList<>();
            boolean flag = true;
            for (int idx = 0; idx < line.length; idx++){
                if(stack.isEmpty()){
                    stack.add(line[idx]);
                }else{
                    char tmp = line[idx];
                    char top = stack.peekLast();
                    if(tmp =='('){
                        stack.add(tmp);
                    }else if(top =='('){
                        stack.pollLast();
                    }else{
                        flag = false;
                        break;
                    }
                }
            }
            if(stack.isEmpty() && flag){
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
