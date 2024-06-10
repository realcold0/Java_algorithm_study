import java.io.*;
import java.util.*;

// tip: each public class is put in its own file
public class 제로
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> Jamin = new Stack<>();
        int answer = 0;
        for(int i = 0; i < K; i++){
            int m = Integer.parseInt(br.readLine());
            if (m ==0){
                Jamin.pop();
            }else{
                Jamin.push(m);
            }   
        }
        for (int j : Jamin){
            answer +=j;
        }
        
        
        System.out.println(answer);
    }
}