import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n =  Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        int count = 0 ;
        for( int i = 0 ; i < n ; i++ ) {
            arr[i] = br.readLine();
            Stack<Character> stack = new Stack<>();
            String tmp = arr[i];
            for(int j = 0;j < arr[i].length();j++) {
                if(stack.isEmpty() || stack.peek() != arr[i].charAt(j)) {
                    stack.push(arr[i].charAt(j));
                }
                else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()) {
                count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();

    }
}
