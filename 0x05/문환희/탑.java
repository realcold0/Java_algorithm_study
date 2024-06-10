import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class 탑 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] answer = new int[n];
        Stack<Integer[]> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && stack.peek()[1] < arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                answer[i] = stack.peek()[0];
            }

            stack.push(new Integer[] {i + 1, arr[i]});
        }
        for(int i : answer) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
