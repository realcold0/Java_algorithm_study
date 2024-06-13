import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class 스택 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        for(int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            if(s[0].equals("push")) {
                stack.push(s[1]);
            }
            else if(s[0].equals("pop")) {
                if(stack.isEmpty()) {
                    bw.write("-1");
                    bw.newLine();
                }
                else {
                    bw.write(stack.pop());
                    bw.newLine();
                }
            }
            else if(s[0].equals("size")) {
                bw.write(String.valueOf(stack.size()));
                bw.newLine();
            }
            else if(s[0].equals("empty")) {
                if(stack.isEmpty()) {
                    bw.write("1");
                    bw.newLine();
                }
                else {
                    bw.write("0");
                    bw.newLine();
                }
            }
            else if(s[0].equals("top")) {
                if (stack.isEmpty()) {
                    bw.write("-1");
                    bw.newLine();
                } else {
                    bw.write(stack.peek());
                    bw.newLine();
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
