import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class 카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            deque.addLast(i);
        }


        while(deque.size() > 1) {
            deque.pollFirst();
            deque.addLast(deque.pollFirst());
        }

        bw.write(deque.pollFirst()+"\n");

        bw.flush();
        bw.close();
        br.close();

    }
}
