import java.io.*;
import java.util.*;

public class 스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stackInt= new Stack<>();
        int num = 0;
        for (int i = 0 ; i < N ; i++){
           StringTokenizer st = new StringTokenizer(br.readLine());
           String comm = st.nextToken();
           if(Objects.equals(comm, "push")){
               num = Integer.parseInt(st.nextToken());
           }
           switch (comm){
               case "push":
                   stackInt.push(num);
                   break;
               case "pop":
                   if(!stackInt.isEmpty())
                       System.out.println(stackInt.pop());
                    else
                       System.out.println(-1);
                   break;
               case "size":
                   System.out.println(stackInt.size());
                   break;
               case "empty":
                   if(stackInt.isEmpty()){
                       System.out.println(1);
                   }else{
                   System.out.println(0);
               }
                   break;
               case "top":
                   if(stackInt.isEmpty()){
                       System.out.println(-1);                       
                   }else{
                       System.out.println(stackInt.peek());

                   }
                   break;
           }

        }



    }
}