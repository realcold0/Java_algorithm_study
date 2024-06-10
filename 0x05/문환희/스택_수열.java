import java.io.*;
import java.util.*;

public class 스택_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<String> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
       int n = Integer.parseInt(br.readLine());

        int start = 0;

       for(int i = 0; i < n; i++) {
           int val = Integer.parseInt(br.readLine());

           if(val > start) {
               for(int j = start + 1; j <= val; j++) {
                   stack.push(j);
                   list.add("+");
               }
               start = val;
           }
           else if(stack.peek() != val) {
               System.out.println("NO");
               return;
           }
           stack.pop();
           list.add("-");

       }

       for(String s : list) {
           bw.write(s);
           bw.newLine();
       }

        bw.flush();
        bw.close();
        br.close();

    }
}
