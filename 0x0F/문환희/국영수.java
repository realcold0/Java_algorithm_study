import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static java.util.Arrays.compare;

class scores {
    String name;
    int korean;
    int english;
    int math;

    @Override
    public String toString() {
        return "scores [name=" + name + ", korean=" + korean + ", english=" + english + ", math=" + math + "]";
    }
}

public class 국영수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<scores> arr = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            scores s = new scores();
            s.name = input[0];
            s.korean = Integer.parseInt(input[1]);
            s.english = Integer.parseInt(input[2]);
            s.math = Integer.parseInt(input[3]);
            arr.add(s);
        }


        arr.sort((o1, o2) -> {
            if(o1.korean == o2.korean) {
                if(o1.english == o2.english) {
                    if(o1.math == o2.math) {
                        return (o1.name.compareTo(o2.name));
                    }
                    else {
                        return o2.math - o1.math;
                    }
                }
                else {
                    return o1.english - o2.english;
                }
            }
            else{
                return o2.korean - o1.korean;
            }
        });
        for(scores s : arr) {
            bw.write(s.name+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
