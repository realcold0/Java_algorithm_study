import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " " );
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] locations = new int[m];
        LinkedList<Integer> deque = new LinkedList<>();
        for(int i= 1 ; i<= n;i++){
            deque.addLast(i);
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " " );
        int count  = 0;
        for (int i = 0; i < m; i++) {
            locations[i] = Integer.parseInt(st2.nextToken());
            int index = deque.indexOf(locations[i]); //찾을 수 의 위치
            int mid = deque.size()/2;

            while(deque.getFirst() != locations[i]){
                if(index <= mid){ //왼쪽이라면
                    int tmp = deque.removeFirst();
                    deque.addLast(tmp);
                    count++;
                }else{
                    int tmp = deque.removeLast();
                    deque.addFirst(tmp);
                    count++;
                }
            }
            deque.removeFirst();
//            System.out.println(deque.toString() + " count : " + count);

        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}