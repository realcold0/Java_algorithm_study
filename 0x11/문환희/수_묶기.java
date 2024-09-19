import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 수_묶기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pos = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> neg = new PriorityQueue<>();
        int zeroCnt = 0;
        int oneCnt = 0;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                zeroCnt++;
            }
            else if(input == 1) {
                oneCnt++;
            }
            else if(input > 0) {
                pos.add(input);
            }
            else {
                neg.add(input);
            }
        }

        while(pos.size() > 1) {
            int x = pos.poll();
            int y = pos.poll();
            ans += x * y;
        }
        while(!pos.isEmpty()) {
            ans += pos.poll();
        }

        while(neg.size() > 1) {
            int x = neg.poll();
            int y = neg.poll();
            ans += x * y;
        }

        for(int i = 0; i < zeroCnt; i++) {
            neg.poll();
        }

        while(!neg.isEmpty()) {
            ans += neg.poll();
        }

        ans += oneCnt;


        System.out.println(ans);


    }

}