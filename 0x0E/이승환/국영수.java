import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        class Score{
            String name;
            int kor;
            int eng;
            int math;

            Score(String name, int kor, int eng, int math) {
                this.name = name;
                this.kor = kor;
                this.eng = eng;
                this.math = math;

            }

            @Override
            public String toString() {
                return name;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Score> scores = new ArrayList<Score>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            scores.add(new Score(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        scores.sort(new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                if(o1.kor > o2.kor) return -1;
                else if(o1.kor < o2.kor) return 11;
                else {
                    if(o1.eng > o2.eng) return 1;
                    else if(o1.eng < o2.eng) return -1;
                    else{
                        if(o1.math > o2.math) return -1;
                        else if(o1.math < o2.math) return 1;
                        else {
                            return o1.name.compareTo(o2.name);
                        }
                    }
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < scores.size(); i++) {
            sb.append(scores.get(i)).append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}