
import java.io.*;
import java.util.*;


class student{
    // 국어, 영어, 수학 순
    private int kor;
    private int eng;
    private int mat;
    private String name;

    public student(String name, int kor, int eng, int mat){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }
}

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 학생의 수
        int N = Integer.parseInt(br.readLine());
        student[] students = new student[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int mat = Integer.parseInt(st.nextToken());
            students[i] = new student(name, kor, eng, mat);
        }

        // 국어, 수학 빼고 오름차순
        Arrays.sort(students, new Comparator<student>() {
            @Override
            public int compare(student s1, student s2) {
                if(s1.getKor() != s2.getKor()){
                    return s2.getKor() - s1.getKor();
                } else if (s1.getEng() != s2.getEng()){
                    return s1.getEng() - s2.getEng();
                } else if (s1.getMat() != s2.getMat()){
                    return s2.getMat() - s1.getMat();
                } else {
                    return s1.getName().compareTo(s2.getName());
                }
            }
        });

        for(int i = 0; i < N; i++){
            System.out.println(students[i].getName());
        }
    }

}
