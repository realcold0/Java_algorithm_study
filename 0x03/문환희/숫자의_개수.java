import java.lang.reflect.Array;
import java.util.*;
import java.lang.Math;

import static javax.swing.text.html.HTML.Attribute.N;

public class 숫자의_개수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mul = 1;
        for(int i = 0;  i < 3; i++) {
            mul *= sc.nextInt();
        }
        int[] nums = new int[10];

        for(char c : String.valueOf(mul).toCharArray()) {
            nums[Integer.parseInt(String.valueOf(c))]++;
        }

        for(int i : nums) {
            System.out.println(i);
        }
    }


}
