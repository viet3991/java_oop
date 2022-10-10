/*
 * LuckyNumber game: người chơi đoán con số may mắn từ 0 đến 100, số lượt đoán càng ít càng tốt.
 * author: vietpqFX11399
 * version: 1.2
 * since: 12/08/2021
 */

import java.util.Scanner;
public class LuckyNumber {
    // totalGames: tổng số lần chơi game
    public static int totalGames = 0;
    // totalGuess: tổng số lần dự đoán
    public static int totalGuess = 0;
    // bestGame: số lần dự đoán ít nhất
    public static int bestGames;
    // MIXIMUM: hằng số để tạo ra số tự nhiên ngẫu nhiên từ 0 đến MAXIMUM
    public static final int MAXIMUM = 100;


    /**
     * Đây là luồng điều khiển chính.
     * Bắt đầu chơi game, kiểm tra người chơi muốn tiếp tục hay không? Nếu có thì chơi tiếp.
     * Nếu không thì thoát trò chơi và báo cáo kết quả lần chơi.
     * minGuess: số lượt đoán mỗi lần chơi
     * answer: biến nhận thông tin từ người chơi có muốn tiếp tục chơi hay không.
     * flag: là điều kiện để gán giá trị minGuess đầu tiên cho bestGames ở mỗi lần chơi.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minGuess;
        String answer;
        boolean flag = true;

        // Thông báo bắt đầu chơi game
        System.out.println("-----------------------------------------------------");
        System.out.println("          Welcome to LUCKY NUMBER Game...");
        System.out.println("-----------------------------------------------------");
        System.out.println("Tôi đang nghĩ một con số trong khoảng từ 0 đến 100...");

        // Bắt đầu trò chơi, lặp lại trò chơi nếu người chơi chọn: yes, y, Yes,...
        do {
            //// Gọi phương thức playGame(), gán giá trị countGuess trong phương thức cho minGuess
            minGuess = playGame();

            //// Chỉ gán 1 lần duy nhất giá trị minGuess đầu tiên cho bestGames
            if (flag) {
                bestGames = minGuess;
                flag = false;
            }

            //// Tìm bestGames
            if (bestGames >= minGuess) {
                bestGames = minGuess;
            }

            //// Đến số lần chơi game
            totalGames ++;

            System.out.println("------------------------------------------------------------");
            System.out.print("Bạn có muốn tiếp tục chơi không? ");
            answer = sc.next();
            System.out.println("------------------------------------");

        // Kiểm tra có tiếp tục chơi game hay không.
        } while (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y"));

        // Gọi phương thức reportGame() khi kết thúc trò chơi
        reportGame();
    }

    /**
     * Người chơi nhập vào số dự đoán cho đến khi trùng khớp với số luckyNumber.
     * luckyNumber: số may mắn được ta ra từ random() có giá trị từ 0 đến 100.
     * guessNumber: con số do người chơi nhập vào.
     * countGuess: đếm số lần dự đoán ở lượt chơi hiện tại.
     */
    public static int playGame() {
        Scanner sc = new Scanner(System.in);
        // Biến randomD là số real được tạo ra từ Math.random()*(max - min + 1) + min
        double randomD = Math.random() * (MAXIMUM + 1);
        // Ép về kiểu integer
        final int luckyNumber = (int)randomD;
        int guessNumber;
        int countGuess = 0;

        // Lặp lại trò chơi cho tới khi đoán đúng
        do {
            System.out.print("Bạn đoán: ");
            while (!sc.hasNextInt()) {
                System.out.println("Vui lòng nhập số nguyên!!!");
                System.out.print("Bạn đoán: ");
                sc.nextLine();
            }
            guessNumber = Integer.parseInt(sc.nextLine());
            countGuess ++;
            totalGuess ++;

            //// Kiểm tra chênh lệch giữa số dự đoán guessNumber và số may mắn luckyNumber
            if (luckyNumber < guessNumber) {
                System.out.println("Số may mắn nhỏ hơn số dự đoán của bạn.");
            } else if (luckyNumber > guessNumber) {
                System.out.println("Số may mắn lớn hơn số dự đoán của bạn.");
            } else {
                System.out.println("Chúc mừng bạn đã đoán đúng con số may mắn sau " + countGuess + " lần dự đoán!");
            }

        // Nếu chưa đoán đúng thì tiếp tục dự đoán
        } while(luckyNumber != guessNumber);

        // Trả về giá trị của countGuess để gán cho minGuess
        return countGuess;
    }

    /**
     * Thông báo kết quả trò chơi
     * avgGuess: số dự đoán trung bình của mỗi lượt
     */
    public static void reportGame() {
        // Làm tròn 1 chữ số sau dấu (.) cho biến avgGuess
        double avgGuess = Math.round(totalGuess * 10.0 / totalGames) / 10.0;

        System.out.println("-------------------------------------------");
        System.out.println("-----------------KẾT QUẢ-------------------");
        System.out.println("** Tổng số lần chơi:                    " + totalGames);
        System.out.println("** Tổng số lần dự đoán:                 " + totalGuess);

        System.out.println("** Số lần dự đoán trung bình mỗi lượt:  " + avgGuess);
        System.out.println("** Số lần dự đoán ít nhất:              " + bestGames);
        System.out.println("-------------------------------------------");
        System.out.println("................Tạm biệt...................");
        System.out.println("Hẹn gặp lại bạn trong lần chơi tiếp theo!!!");
        System.out.println("-------------------------------------------");
    }
}
