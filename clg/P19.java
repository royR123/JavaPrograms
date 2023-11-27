package clg;

import java.util.NavigableSet;
import java.util.TreeSet;

public class P19 {
    static class Result implements Comparable<Result> {
        String rollno, semester;
        int[] marks;
        int total = 0;
        Integer tot;

        public Result(String rollno, String semester, int[] marks) {
            this.rollno = rollno;
            this.semester = semester;
            this.marks = marks;
            for (int i = 0; i < 5; i++) {
                this.total += marks[i];
            }
            this.tot = this.total;
        }

        @Override
        public int compareTo(Result R) {
            if (this.semester.equals(R.semester)) {
                if (this.rollno.equals(R.rollno)) {
                    return R.tot.compareTo(this.tot);
                }
                return Integer.valueOf(this.rollno).compareTo(Integer.valueOf(R.rollno));
            } else {
                return Integer.valueOf(this.semester).compareTo(Integer.valueOf(R.semester));
            }
        }

        @Override
        public String toString() {
            return "\nSemester: " + this.semester + "\n" + "Roll No.: " + this.rollno + "\n" + this.marks[0] +
                    " " +
                    this.marks[1] + " " + this.marks[2] + " " + this.marks[3] + " " + this.marks[4] + "\n" +
                    "Total Marks: " + this.total + "/500";
        }
    }

    public static void main(String[] args) {
        int[] m1 = { 90, 100, 85, 69, 54 };
        int[] m2 = { 50, 77, 35, 55, 79 };
        int[] m3 = { 82, 80, 97, 25, 18 };
        int[] m4 = { 98, 88, 35, 65, 61 };
        int[] m5 = { 55, 94, 55, 66, 77 };
        Result r1 = new Result("1", "1", m1);
        Result r2 = new Result("1", "1", m2);
        Result r3 = new Result("3", "2", m3);
        Result r4 = new Result("4", "3", m4);
        Result r5 = new Result("5", "3", m5);
        NavigableSet<Result> ts = new TreeSet<>();
        ts.add(r1);
        ts.add(r2);
        ts.add(r3);
        ts.add(r4);
        ts.add(r5);
        for (Result ele : ts) {
            System.out.println(ele);
        }
    }
}
