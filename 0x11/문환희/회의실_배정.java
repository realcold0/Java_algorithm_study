import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class time implements Comparable<time>{
    int start;
    int end;

    @Override
    public int compareTo(time o1) {
        if(this.end == o1.end){
            return this.start - o1.start;
        }
        return this.end - o1.end;
    }

    public time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return this.start + "_" + this.end;
    }


}

public class 회의실_배정 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<time> arr = new PriorityQueue<>();
        Deque<time> q = new LinkedList<time>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            arr.add(new time(start, end));
        }

        while(!arr.isEmpty()) {
            if(q.isEmpty()) {
                q.add(arr.poll());
            }
            else {
                time t = arr.poll();
                if(q.peekLast().end <= t.start) {
                    q.add(t);
                }
            }
        }

        System.out.println(q.size());


        br.close();
    }
}