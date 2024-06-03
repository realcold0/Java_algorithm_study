import java.io.*;
import java.util.*;

public class Boj_1406 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String c = br.readLine();
        int M = Integer.parseInt(br.readLine());
        //Linked List 생성
        LinkedList<Character> contents = new LinkedList<Character>();
        for (int i = 0; i < c.length(); i++){
            contents.add(c.charAt(i));
        }
        int cursor = c.length() +1;
        String command;
        char addContents ;

        for (int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            if(Objects.equals(command, "P")){
                addContents = st.nextToken().charAt(0);
            }
            //명령어 수행
            switch (command){
                case "L":
                    if (cursor !=0){
                        cursor -=1;
                    }
                    break;
                case "D":
                    if(cursor != c.length()+1){ //
                        cursor +=1;
                    }
                    break;
                case "B":
                    contents.remove(cursor);
                    break;
                case "P":
                    contents.add(cursor,addContents);
                    cursor +=1;
                    addContents = '';


            }


        }
    }
}
