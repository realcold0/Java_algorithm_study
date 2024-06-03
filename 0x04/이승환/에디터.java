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

        String str = br.readLine();
        int m = Integer.parseInt(br.readLine());// 명령어 갯수

        List<Character> link = new LinkedList<Character>();
        for (int i = 0; i < str.length(); i++) {
            link.add(str.charAt(i));
        }
        ListIterator<Character> listIterlator = link.listIterator(str.length());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String commend = st.nextToken();
            if (commend.equals("L")) { // 왼쪽으로 한칸
                if(listIterlator.hasPrevious()){
                    listIterlator.previous();
                }
            } else if (commend.equals("D")) { // 오른쪽으로 한칸
                if(listIterlator.hasNext()){
                    listIterlator.next();
                }
            } else if (commend.equals("B")) { // 왼쪽에 있는 문자 삭제
                if(listIterlator.hasPrevious()){
                    listIterlator.previous();
                    listIterlator.remove();
                }

            } else if (commend.equals("P")) { // 왼족에 문자 추가
                listIterlator.add(st.nextToken().charAt(0));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : link){
            sb.append(c);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
