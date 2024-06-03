import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i< T ; i++){
            String str = br.readLine();
            int L = str.length();
            List<Character> link = new LinkedList<>();
            ListIterator<Character> listiterlator = link.listIterator(0);


            for(int j =0; j<L ;j++){ //문장 처음 부터 끝까지
                char tmp = str.charAt(j);
                switch (tmp) {
                    case '<':
                        if(listiterlator.hasPrevious()){
                            listiterlator.previous();
                        }
                        break;
                    case '>':
                        if(listiterlator.hasNext()){
                            listiterlator.next();
                        }
                        break;

                    case '-' :
                        if(listiterlator.hasPrevious()){
                            listiterlator.previous();
                            listiterlator.remove();
                        }
                        break;

                    default:
                        listiterlator.add(tmp);
                        break;
                }
            }

            StringBuilder sb =  new StringBuilder();
            for(char a :link){
                sb.append(a);
            }
            System.out.println(sb.toString());

        }

        bw.flush();
        bw.close();
    }
}
