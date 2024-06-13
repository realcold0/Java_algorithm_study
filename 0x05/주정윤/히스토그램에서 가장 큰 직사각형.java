import java.io.*;
import java.util.*;

public class Solution {
    
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		// 2차원 배열로 값과 index값을 같이 저장한다.
		Stack<int []> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 막대의 개수 N개 먼저 입력 받는다. 
		int N = Integer.parseInt(st.nextToken()); 
		
		for(int i=1; i<=N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			
//			// 스택이 비어있지 않으면 비교 
//			while (!stack.isEmpty()) {
//				// 그 전 스택에 있는 값이 자기보다 크면 (작은데 비교할 필요가 있나)
//				// 근데 그러면 다음 값이 클 경우 저장을 못하네 큰 거를 저장을 해야되
//				if(stack.peek()[0] > temp) {
//					int size = temp * (stack.peek()[1])
//				}
//			}
			
			// 스택이 비어있을 때 추가 1.(2, 1)
			if(stack.isEmpty()) {
				stack.push(new int[] {temp, i});
			}
			
		}
		
		
		
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	

}


