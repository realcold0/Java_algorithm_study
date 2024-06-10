import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class 제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(tmp);
            }
        }
        int result = 0;
        for(int i : stack) {
            result += i;
        }
        System.out.println(result);
    }
}
