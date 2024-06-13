import java.io.*;
import java.util.*;

// tip: each public class is put in its own file
public class 스택_수열
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Stack<Integer> numbers = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int init = 1;
        while(n--> 0){
            int tmp = Integer.parseInt(br.readLine());
            
                for (; init <= tmp; init++){
                numbers.push(init);
                sb.append("+").append("\n");
            
            }
          
            if (numbers.peek()==tmp){
                numbers.pop();
                sb.append("-").append("\n");
            }else{
                System.out.println("NO");
                return;
            }
                
        }
        System.out.println(sb);
        
        
    }
}