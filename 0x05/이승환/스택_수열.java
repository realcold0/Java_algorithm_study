import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int start = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i  =0 ;i < n;i++){
            int tmp = Integer.parseInt(br.readLine());
            while(tmp >= start){//1부터 자리수 까지
                stack.push(start++);
                sb.append("+\n");
            }
            if(stack.empty() || stack.peek() < tmp){
                bw.write("NO\n");
                bw.flush();
                bw.close();
                return;
            }
            if(tmp <= stack.peek()){
                while(true){
                    if(tmp == stack.peek()){
                        sb.append("-\n");
                        stack.pop();
                        break;
                    }else{
                        sb.append("-\n");
                        stack.pop();
                    }
                }
            }
        }
        bw.write(sb.toString());


        bw.flush();
        bw.close();
    }





}