import java.io.*;
import java.util.*;

public class Solution {
    
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		// N 입력  
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
			
		int temp =0; 
		
		for(int i=1; i<=N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			// 입력받은 num값이 temp보다 크면 for문을 돌면서 stack에 값을 넣어주고 '+'를 추가해준
			if(num>temp) {
				for(int j = temp+1; j<=num; j++) {
					stack.push(j);
					sb.append('+').append("\n");
				}
				
				temp = num;
			} 
			// stack의 top값이 num과 같지 않다면 NO 출
			else if(stack.peek() != num) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append('-').append("\n");
			
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	

}


