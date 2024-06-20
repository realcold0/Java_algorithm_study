import java.io.*;
import java.util.*;

public class Solution {
    
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        // 카드 수 N 값 입력
        int N = Integer.parseInt(br.readLine());

        // N개의 카드 반복 for문 
        for (int i = 1; i <= N; i++) {
           queue.add(i);  // 현재 queue : { 1, 2, 3, 4 }     
        }
        
        int last = 0;
        
        while(queue.size() > 1) {
        	queue.poll();  	
        	queue.add(queue.poll());
        	
        }
        
        sb.append(queue.poll());
        

        bw.write(sb.toString());
        bw.flush();
        bw.close();
		
	}
	
	

}


