import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n  = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        //수 다 넣기
        for(int i = 1; i<= n;i++){
            queue.add(i);
        }
        while (queue.size() != 1){
            queue.poll();
            int tmp2 = queue.poll();
            queue.add(tmp2);
        }

        bw.write(queue.peek()+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}