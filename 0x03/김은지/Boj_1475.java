import java.io.*;
import java.util.*;

public class Boj_1475 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char dasom[];
        dasom = s.toCharArray();
        int nums[] = new int[10];
        int six_shape = 0;
        for (char c : dasom) {
            if (c == '6' || c == '9') {
                six_shape += 1;
            } else {
                nums[c - '0'] += 1;
            }
        }
        if (six_shape %2 ==1){
            six_shape = six_shape /2 + 1;
        }else{
            six_shape = six_shape /2;
        }

        // 6, 9 뒤집어서 사용 가능
        //Java에서 배열or 리스트 내의 min, max 값 구하기
        //max(); 까지 사용하면 OptionalInt이기 때문에 getAsInt() 사용
        int max_arr = Integer.max(Arrays.stream(nums).max().getAsInt(),1);
        System.out.println(Integer.max(max_arr,six_shape));



    }
}
