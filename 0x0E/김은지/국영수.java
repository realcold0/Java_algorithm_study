import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Score implements Comparable<Score> {
    String name;
    int korean;
    int english;
    int math;

    public Score(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    public int getKorean() {
        return korean;
    }

    public int getEnglish() {
        return english;
    }

    public int getMath() {
        return math;
    }

    @Override
    public String toString() {
        return "Score [name=" + name + ", korean=" + korean + ", english=" + english + ", math=" + math + "]";
    }

    @Override
    public int compareTo(Score o) {
        int firstSort = o.getKorean() - korean;
        if (firstSort != 0) return firstSort;
        int secondSort = english - o.getEnglish();
        if (secondSort != 0) return secondSort;
        int thirdSort = o.getMath() - math;
        if (thirdSort != 0) return thirdSort;
        return name.compareTo(o.getName());
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Score[] scores = new Score[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            scores[i] = new Score(name, korean, english, math);
        }
        
        Arrays.sort(scores);
        
        for (Score s : scores) {
            
            bw.write(s.getName());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
