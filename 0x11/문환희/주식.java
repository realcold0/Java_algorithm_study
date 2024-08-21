import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class stock implements Comparable<stock>{
    int idx;
    int num;

    public stock(int idx, int num) {
        this.idx = idx;
        this.num = num;
    }

    public int compareTo(stock o) {
        if(this.num == o.num) {
            return this.idx - o.idx;
        }
        return o.num - this.num;
    }
}

public class 주식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            boolean[] check = new boolean[n];
            long sum = 0;
            PriorityQueue<stock> pq = new PriorityQueue<>();

            for(int j = 0; j < n; j++){
                pq.add(new stock(j, arr[j]));
            }
            int start = 0;

            while(!pq.isEmpty()){
                stock s = pq.poll();
                if(!check[s.idx]){
                    for(int k = start; k < s.idx; k++) {
                        sum += Math.max(0, (s.num) - arr[k]);
                        check[k] = true;
                    }
                    start = s.idx;
                    check[s.idx] = true;
                }
            }
            System.out.println(sum);
        }
    }
}