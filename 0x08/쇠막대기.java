import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        // 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어짐 
        String str = br.readLine();
        int count = 0;
        
        Stack<String> stack = new Stack<>();
        String[] input = str.split("");
        
        for(int i=0; i<input.length; i++) {
        	if(input[i].equals("(")) stack.push("(");
        	else if (input[i].equals(")")) {
        		// 레이저가 되는 경우 
        		if(input[i-1].equals("(")) {
        			stack.pop();
        			count += stack.size();
        		}
        		else if(input[i-1].equals(")")) {
        			// 쇠막대기가 되는 경우
        			count += 1;
        			stack.pop();
        		}
        	}
        }
        
        System.out.println(count);
        
    }
}