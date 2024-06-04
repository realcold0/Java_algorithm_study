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
        int max_length = c.length();
        int cursor = max_length;
        String[] command = new  String[M];
        char[] addContents = new char[M];

        //커맨드 입력받기
        for (int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            command[i] = st.nextToken();
            if(Objects.equals(command[i], "P")){
                addContents[i] = st.nextToken().charAt(0);
            }

        }

        //커맨드 실행
        for (int j = 0 ; j < command.length;j++){
            switch (command[j]){
                case "L":
                    if (cursor !=0){
                        cursor -=1;
                    }
                    break;
                case "D":
                    if(cursor != max_length){ //
                        cursor +=1;
                    }
                    break;
                case "B":
                    if(cursor != 0 && max_length > 0) {
                        contents.remove(cursor - 1);
                        cursor -=1;
                        max_length -=1;
                    }
                    break;
                case "P":
                    contents.add(cursor,addContents[j]);
                    cursor +=1;
                    max_length +=1;
                    break;
            }
        }



        for (Character ch : contents){
            System.out.print(ch);
        }
    }
}
