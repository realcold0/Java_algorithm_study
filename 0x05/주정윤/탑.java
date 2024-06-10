import java.io.*;
import java.util.*;

public class Solution {
    
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		// 탑의 수 N 입력  
		int N = Integer.parseInt(br.readLine());
		Stack<int []> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			
			int num = Integer.parseInt(st.nextToken());
			
			while(!stack.empty()) {
				if(stack.peek()[0] > num) {
					sb.append(stack.peek()[1] + " ");
					break;
				}
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				sb.append("0 ");
				
			}
			
			stack.push(new int[] {num, i});
		}
	
		
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	

}


