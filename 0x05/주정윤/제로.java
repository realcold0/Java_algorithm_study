import java.io.*;
import java.util.*;

public class Main {
    
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정수 K 입력 
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<K; i++) {
			int num = Integer.parseInt(br.readLine());
			
			// 0일 경우 최근에 쓴 수를 지운다.
			if(num==0) {
				stack.pop();
				
			} else {
				stack.push(num);
			}
		}
		
		int count =0;
		
		for(int a : stack) {
			count += a;
		}
		
		System.out.println(count);
		
	}
	
	

}


