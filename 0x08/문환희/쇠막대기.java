import java.io.*;
import java.util.Stack;

public class 쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sp = 0;
        int answer= 0;
        String input = br.readLine();

        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(') {
                sp++;
            }
            else {
                if(input.charAt(i - 1) == ')') {
                    answer ++;
                    sp--;
                }
                else {
                    answer += (--sp);
                }
            }
        }
        bw.write(answer+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
