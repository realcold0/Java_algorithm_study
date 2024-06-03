import java.io.*;
import java.util.*;

public class Solution {
    
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int L = Integer.parseInt(br.readLine());
		String[] result;
		
		for(int i=0; i<L; i++) {
			Stack<String> left = new Stack<>();
			Stack<String> right = new Stack<>();
			result = br.readLine().split("");
			
			for(String a : result) {
				switch(a) {
				case "<":
					if(!left.isEmpty()) right.push(left.pop());
					break;
				case ">":
					if(!right.isEmpty()) left.push(right.pop());
					break;
				case "-":
					if(!left.isEmpty()) left.pop();
					break;
				default:
					left.push(a);
				}
			}
			
			while(!left.isEmpty()) right.push(left.pop());
			while(!right.isEmpty()) sb.append(right.pop());
			sb.append("\n");
		
		}
		System.out.println(sb.toString());
	}
	
	

}


