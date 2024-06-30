import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        
        while(true) {
        	
        	String str = br.readLine();
        	if(str.equals(".")) { break; }
        	
        	// 괄호를 넣을 스택 선언
            Stack<String> stack = new Stack<>();
            
            String[] input = str.split(""); 

            for(String word : input) {

                // 여는 괄호일 경우 스택에 추가
                if(word.equals("(") || word.equals("[")) {
                    stack.push(word);
                }

                if(word.equals(")")) {
                    if(!stack.isEmpty() && stack.peek().equals("(")) stack.pop();
                    else stack.push(")");
                }
                else if (word.equals("]")) {
                	if(!stack.isEmpty() && stack.peek().equals("[")) stack.pop();
                    else stack.push("]");
                }
            }


            if(stack.empty()) {
                bw.write("yes\n");
            } else {
            	bw.write("no\n");
            }
            
            bw.flush();
        }

           
        bw.close();
    }
}