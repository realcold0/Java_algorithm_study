
import java.lang.reflect.Array;
import java.util.*;
        import java.lang.Math;

import static javax.swing.text.html.HTML.Attribute.N;

public class 문자열_개수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] AtoZ = new int[26];
        for(char c : input.toCharArray()) {
            AtoZ[(int) c - 97]++;
        }
        for(int i : AtoZ){
            System.out.print(i + " ");
        }
    }


}

