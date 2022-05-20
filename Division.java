import java.text.DecimalFormat;
import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat form = new DecimalFormat("#");

        System.out.print("a: ");
        double puncher = scanner.nextDouble();
        System.out.print("b: ");
        double bePunched = scanner.nextDouble();


        boolean isValidInputs = (puncher >= 5 && puncher < 10 && (puncher - (int)puncher == 0))
                && (bePunched >= 100 && bePunched < 500 && (bePunched - (int)bePunched == 0));

        if (isValidInputs) {
            double answer1 = 0;
            double answer2;
            double answer3;
            double answer4 = 0;
            double answer5 = 0;
            double finalResult;

            double firstPunch = (int)(bePunched / (puncher * 10));
            answer2 = firstPunch * puncher * 10;

            answer3 = bePunched - answer2;

            if (answer3 == 0) {
                answer1 = firstPunch * 10;
            }
            if (answer3 != 0) {
                double secondPunch = (int)(answer3 / puncher);
                answer4 = secondPunch * puncher;

                answer5 = answer3 - answer4;

                answer1 = (firstPunch * 10) + secondPunch;
            }

            finalResult = answer1 + answer2 + answer3 + answer4 + answer5;

            System.out.println("합: " + form.format(finalResult));
        }
        else {
            System.out.println("You've got the wrong number...");
        }
    }
}
