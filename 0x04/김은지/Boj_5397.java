import java.io.*;
import java.util.*;

public class Boj_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            char[] testCase = br.readLine().toCharArray();
            LinkedList<Character> Password = new LinkedList<>();
            ListIterator<Character> iterList = Password.listIterator();

            for (char comm : testCase){
                switch (comm){
                    case '<':
                        if (iterList.hasPrevious()){
                            iterList.previous();
                        }
                        break;
                    case '>':
                        if(iterList.hasNext()){
                            iterList.next();
                        }
                        break;
                    case '-':
                        if (iterList.hasPrevious()){
                            iterList.previous();
                            iterList.remove();
                        }
                        break;
                    default:
                        iterList.add(comm);


                }
            }
            StringBuilder sb = new StringBuilder();
            for(char s : Password) {
                sb.append(s);
            }
            System.out.println(sb);
            
        }





    }
}
