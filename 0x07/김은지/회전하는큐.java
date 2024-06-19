import java.io.*;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 회전하는큐 {
    //boj 1021
    static Deque<Integer> d = new LinkedList<Integer>();
    static Deque<Integer> p = new LinkedList<>();
    static int ans = 0;

    static int findWhere(int find){
        Iterator<Integer> iter = d.iterator();
        int moved = 0;
        while(iter.hasNext()){
            moved++;
            if (iter.next() == find){
                break;
            }
        }
        return moved -1;

    }

    static int goLeft(int find) {
        int count =0;
        while(find != d.peek()){
            d.add(d.poll());
            count++;
        }
        d.poll();

        return count;
    }
    static int goRight(int find) {
        int count =0;
        while(find != d.peek()){
            d.addFirst(d.pollLast());
            count++;
        }
        d.poll();

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++) {
            d.add(i);
        }
        int m = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i< m;i++){
            p.add( Integer.parseInt(st2.nextToken()));
        }
        int standard = n /2;

        //p가 다 없어질때까지 반복
        while(!p.isEmpty()){
            standard = d.size() /2;
            int tmp_d = d.peekFirst();
            int tmp_p = p.poll();
            if(tmp_p==tmp_d){
                d.poll();
                continue;
            }
            if (findWhere(tmp_p) <= standard) {
                ans += goLeft(tmp_p);
            }
            else{
                ans += goRight(tmp_p);
            }
        }


        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
