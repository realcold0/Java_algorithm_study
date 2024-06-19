import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import java.util.*;

public class 회전하는_큐 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        //int m = Integer.parseInt(input[1]);
        int answer = 0;

        List<Integer> lst = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Deque<Integer> deque = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        while(!lst.isEmpty()) {
            if(lst.get(0).equals(deque.peekFirst())) {
                deque.pollFirst();
                lst.remove(0);
            }
            else {
                int idx = new ArrayList<>(deque).indexOf(lst.get(0));

                if(idx > deque.size() - idx) {
                    deque.addFirst(deque.pollLast());
                    answer++;
                }
                else {
                    deque.addLast(deque.pollFirst());
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer) + '\n');
        bw.flush();
        bw.close();
        br.close();

    }
}


