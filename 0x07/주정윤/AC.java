import java.io.*;
import java.util.*;

public class Solution {
    
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
        	// 차례로 T의 횟수만큼 입력값을 받도록 한다.
        	String command = br.readLine();
        	int n = Integer.parseInt(br.readLine());
        	String arr = br.readLine();
        	
        	Deque<Integer> deque = new LinkedList<>();
        	
        	String line_sub = arr.substring(1, arr.length()-1);
            String[] arr_list = line_sub.split(","); // 1,2,3,4
            
            for(String a : arr_list) {
            	if(!a.equals("")) {
            		deque.add(Integer.valueOf(a));
            	}
            }
            
            AC(deque, command);
        	
        }
		
	}
	
	public static void AC(Deque<Integer> deque, String command) throws IOException {
		
		boolean reverse = false;
		
		for(int i=0; i<command.length(); i++) {
			if(command.charAt(i) == 'R') {
				// R일 경우에는 뒤집기
				reverse = !reverse;
			} else {
				// D일 경우에는 삭
				if(deque.size() == 0) {
					System.out.println("error");
					return;
				}
				
				if(reverse) {
					deque.removeLast();
				} else {
					deque.removeFirst();
				}
			}
		}
		
		StringBuilder sb2 = new StringBuilder();
		
		sb2.append("[");
		
		while(!deque.isEmpty()) {
			sb2.append(reverse ? deque.removeLast() : deque.removeFirst());
			if(deque.size()!=0) sb2.append(",");
		}
		
		sb2.append("]");
		
		System.out.println(sb2);

		
	}
	
	

}


