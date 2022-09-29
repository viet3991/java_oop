/*
 * GradeStuent: là ứng dụng cho phép người dùng nhập thông tin điểm thi giữa kỳ, cuối kỳ và điểm bài tập của sinh viên.
 *              Hệ thống sẽ tính toán, đưa ra tổng điểm của khóa học và điểm GPA tối thiểu đạt được.
 * author: vietpqFX11399
 * version: 1.3
 * since: 12/13/2021
 */

import java.util.Scanner;
public class GradeStudent {
    // trọng số của điểm thi giữa kỳ
     public static int weightMid;
    // trọng số của điểm thi cuối kỳ
    public static int weightFinal;


    /**
     * main method: là luồng chương trình chính, bao gồm:

     * - midTerm() method: cho phép nhập và tính toán điểm thi giữa kỳ
     *       + checkShift() method: kiểm tra điểm thi có thay đổi hay không

     * - finalTerm() method: cho phép nhập và tính toán điểm thi cuối kỳ
     *      + checkShift() method: kiểm tra điểm thi có thay đổi hay không

     * - homework() method: cho phép nhập và tính toán điểm bài tập về nhà và điểm chuyên cần

     * - report() method: báo cáo tổng điểm khóa học
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        begin();
        // điểm giữa kỳ đã tính trọng số
        double weightScoreMid = midTerm(sc);
        // điểm cuối kỳ đã tính trọng số
        double weightScoreFinal = finalTerm(sc);
        // điểm bài tập về nhà đã tính trọng số
        double weightScoreHw = homework(sc);
        // report
        report(weightScoreMid, weightScoreFinal, weightScoreHw);

    }

    /**
     * Giới thiệu về chương trình
     */
    public static void begin() {
        System.out.println();
        System.out.println("==============================================================================");
        System.out.println("This program reads exam/homework scores and reports your overall course grade.");
        System.out.println("==============================================================================");
        System.out.println();
    }

    /**
     * cho phép nhập và tính toán điểm thi giữa kỳ
     * checkShift() method: kiểm tra điểm thi có thay đổi hay không
     * scoreMid: điểm thi giữa kỳ
     * shiftAmount: số điểm thay đổi
     * totalMid: tổng điểm giữa kỳ
     */
    public static double midTerm(Scanner sc) {
        int scoreMid;
        int shiftAmount;
        int totalMid;
        double weightScoreMid;

        System.out.println("MidTerm:                             ");

        // trọng số
        do {
            System.out.print("Weight (0 - 100)?                      ");
            // kiểm tra dữ liệu nhập vào, nếu không phải số nguyên thì phải nhập lại
            while (!sc.hasNextInt()) {
                System.out.println("That is not an integer! Enter again");
                System.out.print("Weight (0 - 100)?                      ");
                sc.nextLine();
            }
            weightMid = sc.nextInt();
            if (weightMid < 0 || weightMid > 100) {
                System.out.println("Enter weight again!!! --- weightMid < 0 or weightMid > 100)");
            }
        }
        // kiểm tra trọng số, nếu không phù hợp phải nhập lại, trọng số phải lớn hơn 0 và nhỏ hơn 100
        while (weightMid < 0 || weightMid > 100);

        // điểm thi giữa kỳ
        System.out.print("Score earned?                          ");
        scoreMid = sc.nextInt();

        // gọi phương thức checkShift để kiểm tra điểm thi có thay đổi hay không.
        shiftAmount = checkShift(sc);

        // tổng điểm giữa kỳ
        totalMid = scoreMid + shiftAmount;
        // nếu tổng điểm lớn hơn 100, thì lấy bằng 100
        totalMid = totalMid > 100 ? 100 : totalMid;
        System.out.println("Total points =                         " + totalMid + " / 100");

        // điểm giữa kỳ khi tính với trọng số
        weightScoreMid = totalMid * 1.0 * weightMid / 100;
        // làm tròn 1 chữ số sau dấu thập phân
        weightScoreMid = Math.round(weightScoreMid * 10) / 10.0;
        System.out.println("Weighted score =                       " + weightScoreMid + " / " + weightMid);

        System.out.println("------------------------------------------------");
        System.out.println();

        return weightScoreMid;

    }

    /**
     * cho phép nhập và tính toán điểm thi cuối kỳ
     * checkShift() method: kiểm tra điểm thi có thay đổi hay không
     * scoreMid: điểm thi cuối kỳ
     * shiftAmount: số điểm thay đổi
     * totalMid: tổng điểm cuối kỳ
     */
    public static double finalTerm(Scanner sc) {
        int scoreFinal;
        int shiftAmount;
        int totalFinal;
        double weightScoreFinal;


        System.out.println("Final:                             ");

        // trọng số
        do {
            System.out.print("Weight (0 - 100)?                      ");
            // kiểm tra dữ liệu nhập vào, nếu không phải số nguyên thì phải nhập lại
            while (!sc.hasNextInt()) {
                System.out.println("That is not an integer! Enter again");
                System.out.print("Weight (0 - 100)?                      ");
                sc.nextLine();
            }
            weightFinal = sc.nextInt();
            if (weightFinal < 0 || (weightFinal + weightMid) > 100) {
                System.out.println("Enter weight again!!!--- weightFinal < 0 or (weightFinal + weightMid) > 100");
            }
        }
        // kiểm tra trọng số, trọng số phải lớn hơn 0 và khi cộng với trọng số giữa kỳ phải nhỏ hơn 100
        while (weightFinal < 0 || (weightFinal + weightMid) > 100);

        // điểm thi cuối kỳ
        System.out.print("Score earned?                          ");
        scoreFinal = sc.nextInt();

        // gọi phương thức checkShift để kiểm tra điểm thi có thay đổi hay không.
        shiftAmount = checkShift(sc);

        // tổng điểm cuối kỳ
        totalFinal = scoreFinal + shiftAmount;
        // nếu tổng điểm lớn hơn 100, thì lấy bằng 100
        totalFinal = totalFinal > 100 ? 100 : totalFinal;
        System.out.println("Total points =                         " + totalFinal + " / 100");

        // điểm cuối kỳ khi tính với trọng số
        weightScoreFinal = totalFinal * 1.0 * weightFinal / 100;
        // làm tròn 1 chữ số sau dấu thập phân
        weightScoreFinal = Math.round(weightScoreFinal * 10) / 10.0;
        System.out.println("Weighted score =                       " + weightScoreFinal + " / " + weightFinal);

        System.out.println("------------------------------------------------");
        System.out.println();

        return weightScoreFinal;
    }

    /**
     * weightHomework: trọng số của điểm bài tập về nhà và điểm chuyên cần. trọng số này cộng với trọng số điểm giữa kỳ
     *                 và trọng số điểm cuối kỳ phải bằng đúng 100.
     * numberAssignment: số lượng bài tập về nhà
     * sumScore: tổng số điểm bài tập về nhà đạt được
     * sumMax: tổng số điểm bài tập về nhà lớn nhất có thể
     * section: số buổi học mà sinh viên được điểm danh, được tính là điểm chuyên cần
     * totalPoint: tổng điểm bài tập về nhà và điểm chuyên cần
     */
    public static double homework(Scanner sc) {
        int weightHomework;
        int numberAssignment;
        int sumScore = 0;
        int sumMax = 0;
        int section;
        int totalPoint;
        double weightScoreHw;

        System.out.println("Homework:                             ");

        // trọng số
        do {
            System.out.print("Weight (0 - 100)?                      ");
            // kiểm tra dữ liệu nhập vào, nếu không phải số nguyên thì phải nhập lại
            while (!sc.hasNextInt()) {
                System.out.println("That is not an integer! Enter again");
                System.out.print("Weight (0 - 100)?                      ");
                sc.nextLine();
            }
            weightHomework = sc.nextInt();
            if (weightHomework < 0 || (weightFinal + weightMid + weightHomework) != 100) {
                System.out.println("Enter weight again!!!--- weight < 0 or (weightFinal + weightMid + weightHomework) != 100");
            }
        }
        // kiểm tra trọng số, nếu không phù hợp phải nhập lại
        // trọng số này cộng với trọng số điểm giữa kỳ và trọng số điểm cuối kỳ phải bằng đúng 100
        while (weightHomework < 0 || (weightFinal + weightMid + weightHomework) != 100);

        // số lượng bài tập về nhà
        System.out.print("Number of assignments?                 ");
        numberAssignment = sc.nextInt();
        // in ra điểm số và điểm số lớn nhất có thể đạt được ở mỗi bài tập về nhà
        // score: số điểm đạt được
        // max: số điểm lớn nhất có thể đạt được
        for (int i = 1; i <= numberAssignment; i++) {
            System.out.print("Assignment " + i + " score and max?            ");
            int score = sc.nextInt();
            int max = sc.nextInt();
            // điều kiện score phải nhỏ hơn hoặc bằng max, nếu không thỏa phải nhập lại
            while (score > max) {
                System.out.println("---Warning--- score have to less than max");
                System.out.print("Assignment " + i + " score and max?            ");
                score = sc.nextInt();
                max = sc.nextInt();
            }
            // tổng điểm bài tập về nhà
            sumScore += score;
            sumMax += max;
        }
        // nếu tổng điểm score hoặc max lớn hơn 150 thì lấy bằng 150
        sumScore = sumScore > 150 ? 150 : sumScore;
        sumMax = sumMax > 150 ? 150 : sumMax;
        System.out.println("Homework points =                      " + sumScore + " / " + sumMax);

        // số lần được điểm danh
        System.out.print("How many sections did you attend?      ");
        section = sc.nextInt();
        // điểm chuyên cần = số lần điểm danh * 5
        section = section * 5;
        // nếu điểm chuyên cần lớn hơn 30 thì lấy bằng 30
        section = section > 30 ? 30 : section;
        System.out.println("Section points =                       " + section + " / 30");

        // tổng điểm bài tập về nhà và điểm chuyên cần
        totalPoint = sumScore + section;
        System.out.println("Total points =                         " + totalPoint + " / " + (sumMax + 30));

        // tổng điểm bài tập về nhà và điểm chuyên cần khi tính với trọng số
        weightScoreHw = (totalPoint * 1.0 / (sumMax + 30)) * weightHomework;
        // làm tròn 1 chữ số sau dấu thập phân
        weightScoreHw = Math.round(weightScoreHw * 10) / 10.0;
        System.out.println("Weighted Score =                       " + weightScoreHw + " / " + weightHomework);
        System.out.println("------------------------------------------------");
        System.out.println();

        return weightScoreHw;

    }

    /**
     * thông báo tổng điểm khóa học và gpa
     * grade: tổng điểm khóa học được tính theo thang điểm 100
     * gpa: được tính dựa theo grade
     */
    public static void report(double weightScoreMid, double weightScoreFinal, double weightScoreHw) {
        double grade;
        double gpa;

        grade = weightScoreMid + weightScoreFinal + weightScoreHw;
        // làm tròn 1 chữ số sau dấu thập phân
        grade = Math.round(grade * 10) / 10.0;
        if (grade > 85) {
            gpa = 3.0;
        } else if(grade > 75) {
            gpa = 2.0;
        } else if(grade > 60) {
            gpa = 1.0;
        } else {
            gpa = 0.0;
        }

        System.out.println("================== GRADE & GPA =================");
        System.out.println("Overall percentage =                   " + grade);
        System.out.println("Your grade will be at least :          " + gpa);
        System.out.println("================================================");

        if (gpa >= 3.0) {
            System.out.println("*** =============== EXCELLENT ============== ***");
        } else if (gpa >= 2.0) {
            System.out.println("** ================== GOOD ================== **");
        } else if (gpa >= 1.0) {
            System.out.println("* =================== FAIR =================== *");
        } else {
            System.out.println("===================== POOR =====================");
        }
        System.out.println("================================================");

    }

    /**
     * kiểm tra điểm thi có thay đổi hay không.
     * shifted: điều kiện điểm tra điểm thi có thay đổi hay không. 1 = yes, 2 = no
     * shiftAmount: số điểm thay đổi
     */
    public static int checkShift(Scanner sc) {
        int shifted;
        int shiftAmount = 0;
        System.out.print("Were scores shifted (1 = yes, 2 = no)? ");
        shifted = sc.nextInt();
        // chỉ chọn 1 hoặc 2, nếu không phải chọn lại
        while (shifted != 1 && shifted != 2) {
            System.out.println("--- Warning --- Only choose 1 or 2");
            System.out.print("Were scores shifted (1 = yes, 2 = no)? ");
            shifted = sc.nextInt();
        }
        // số điểm tăng thêm hoặc giảm
        if (shifted == 1) {
            System.out.print("Shift amount?                          ");
            shiftAmount = sc.nextInt();
        }
        return shiftAmount;
    }
}
