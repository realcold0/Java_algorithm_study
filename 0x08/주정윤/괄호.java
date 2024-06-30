import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        // 테스트 데이터 T개 입력받기 
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
        	
        	String str = br.readLine();
        	
        	Stack<String> stack = new Stack<>();
        	String[] input = str.split("");
        	
        	for(String word : input) {
        		
        		if(word.equals("(") || word.isEmpty()) stack.push(word);
        		else if(word.equals(")")){
        			if(!stack.isEmpty() && stack.peek().equals("(")) stack.pop();
        			else stack.push(")");
        		}
        	}
        	
        	if(stack.empty()) bw.write("YES\n");
        	else bw.write("NO\n");
        	bw.flush();
        }
        
        bw.close();
    }
}