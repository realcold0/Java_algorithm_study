import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {

        int count = 1;

        Scanner sc = new Scanner(System.in);
        for(int i=0; i<3; i++){
            count *= Integer.parseInt(sc.nextLine());
        }

        String s_count = Integer.toString(count);;

        int[] numbers = new int[10];

        for(int i=0; i<s_count.length(); i++){
            for(int j=0; j<=9; j++){
                if((s_count.charAt(i) - '0') == j){
                    numbers[j]++;
                }
            }
        }

        for(int i : numbers){
            System.out.println(i);
        }
    }
}