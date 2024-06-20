import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2 {
    //boj 2164
    public static void main(String[] args) throws IOException {
        Deque<Integer> card = new LinkedList<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i = n; i>0;i--){
            card.push(i);
        }
//        System.out.println(card.toString());
        while(true){
            if(card.size()==1){
                break;
            }
            card.poll();
            card.addLast(card.poll());
        }
        bw.write(card.getLast().toString());
        bw.flush();
        bw.close();


    }
}
