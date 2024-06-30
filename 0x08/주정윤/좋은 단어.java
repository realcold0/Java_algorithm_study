import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫째 줄에 단어의 수 N 과 횟수를 저장할 count
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        
        for(int i=0; i<N; i++) {
        	String str = br.readLine();
        	
        	// A, B를 넣을 스택 선
        	Stack<Character> stack = new Stack<>();
        	
        	for(int j=0; j<str.length(); j++) {
        		char c = str.charAt(j);
        		
        		if(stack.empty()) stack.push(c);
        		else {
        			if(stack.peek() == c) stack.pop();
        			else stack.push(c);
        		}
        		
        	}
        	
        	if(stack.empty()) count++;
        	
        }
        
        

        System.out.println(count);
    }
}