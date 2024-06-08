import java.io.*;
import java.util.*;

public class Solution {
    
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		// 명령의 수 N 입
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		// N개의 줄 명령을 입력 받음 
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	
			String command = st.nextToken();
			
			switch(command) {
				case "push":
					stack.push(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					if(!stack.empty()) sb.append(stack.pop()).append("\n");
					else sb.append(-1).append("\n");
					break;
				case "size":
					sb.append(stack.size()).append("\n");
					break;
				case "empty":
					if(stack.empty()) sb.append(1).append("\n");
					else sb.append(0).append("\n");
					break;
				case "top":
					if(!stack.empty()) sb.append(stack.peek()).append("\n");
					else sb.append(-1).append("\n");
					break;
					
			}
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		
	}
	
	

}


