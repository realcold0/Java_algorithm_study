import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        Stack<Character> stack = new Stack<>();

        int sum = 1;
        int count = 0;

        for(int i=0; i< N.length(); i++) {
            switch(N.charAt(i)) {
                case '(':
                    stack.push(N.charAt(i));
                    sum *= 2;
                    break;
                case '[':
                    stack.push(N.charAt(i));
                    sum *= 3;
                    break;
                case ')':
                    if(stack.isEmpty() || stack.peek() != '(') {
                        count = 0;
                        break;
                    }
                    else if(N.charAt(i-1) == '(') count += sum;
                    stack.pop();
                    sum /= 2;
                    break;
                case ']':
                    if(stack.isEmpty() || stack.peek() != '[') {
                        count  = 0;
                        break;
                    }
                    else if (N.charAt(i-1) == '[') count += sum;
                    stack.pop();
                    sum /= 3;
                    break;
            }
        }

        if(!stack.isEmpty()) bw.write("0\n"); //sb.append(0).append("\n");
        else bw.write(count+"\n");  // sb.append(count).append("\n");

        bw.flush();
        bw.close();


    }
}