import java.io.*;
import java.util.*;

public class Boj_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String c = br.readLine();
        int M = Integer.parseInt(br.readLine());
        //Linked List 생성
        LinkedList<Character> contents = new LinkedList<>();
        for (int i = 0; i < c.length(); i++){
            contents.add(c.charAt(i));
        }
        String command;
        char addContents ='t';

        //listiterator 초기화
        ListIterator<Character> iterList = contents.listIterator();

        //커서가 맨 앞이라 뒤로 옮기기
        while(iterList.hasNext()){
            iterList.next();
        }

        //커맨드 입력받기
        for (int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            if(Objects.equals(command, "P")){
                addContents = st.nextToken().charAt(0);
            }
            //커맨드 처리
            switch (command) {
                case "L":
                    if (iterList.hasPrevious())
                        iterList.previous();
                    break;
                case "D":
                    if (iterList.hasNext())
                        iterList.next();
                    break;
                case "B":
                    if (iterList.hasPrevious()){
                        iterList.previous();
                        iterList.remove();
                    }
                    break;
                case "P":
                    iterList.add(addContents);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char s : contents) {
            sb.append(s);
        }
        System.out.println(sb);

    }
}
