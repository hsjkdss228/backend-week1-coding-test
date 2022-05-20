import java.util.Scanner;

public class PikachuRaichu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int HP_MAX = 50;
        final int PIKACHU_ATTACK_DAMAGE = 10;
        final int RAICHU_ATTACK_DAMAGE = 15;
        final String INITIAL_MESSAGE = "피카츄: 라이츄를 만났다..\n" +
                "저 자식 .... 한테 한번 당한 경험이 있으니 ..\n" +
                "이번 리벤지 매치는 나에게 아주 중요해..\n" +
                "다신 땅을 침대로 누워있을 수 없어..!!";
        final String TURN_MESSAGE = "피카츄의 차례, 무엇을 할까?\n" +
                "1. 공격하기\n" +
                "2. 상처약 섭취";
        final String INVALID_ORDER_MESSAGE = "잘못된 명령이다.";
        final String PIKACHU_ATTACK_MESSAGE = "지우: 피카츄 몸통박치기!\n" +
                "-- 공격 명중! 라이츄의 에너지가 " + PIKACHU_ATTACK_DAMAGE + " 감소했다. 라이츄는 조금 아파한다. --\n" +
                "라이츄: 앗, 라이츄 아프다.";
        final String RAICHU_ATTACK_MESSAGE = "라이츄: 라이쮸!!!!!!!!!!!\n" +
                "-- 피카츄 타격!! 에너지가 " + RAICHU_ATTACK_DAMAGE + " 감소했다!! --\n" +
                "피카츄: 피카앍..피카앍..";
        final String PIKACHU_HEALING_MESSAGE = "피카츄: 얌얌 상처약 냠냠\n" +
                "-- 상처약을 섭취하여 피카츄의 에너지가 50이 되었다. 피카츄는 회복되어보인다. --\n" +
                "라이츄: 킁...";
        final String PIKACHU_NO_HEALING_MESSAGE = "피카츄: 아..앗!! 상처약이 없다.. 아\n" +
                "라이츄: ㅋㅋㅋㅋㅋ";
        final String PIKACHU_DEFEAT_MESSAGE = "피카츄의 패배... 이변은 없었다... 역사는 반복한다...";
        final String PIKACHU_VICTORY_MESSAGE = "피카츄의 승리!!";


        int hpPikachu = HP_MAX;
        int hpRaichu = HP_MAX;
        int numberOfPotion = 1;


        System.out.println(INITIAL_MESSAGE);
        System.out.println();

        while (hpPikachu > 0 && hpRaichu > 0) {
            //피카츄 차례
            System.out.println(TURN_MESSAGE);

            int orderIndex = scanner.nextInt();

            if (!(orderIndex == 1 || orderIndex == 2)) {
                System.out.println(INVALID_ORDER_MESSAGE);
                System.out.println();
                continue;
            }

            if (orderIndex == 1) {
                hpRaichu -= PIKACHU_ATTACK_DAMAGE;

                System.out.println(PIKACHU_ATTACK_MESSAGE);
            }

            if (orderIndex == 2) {
                if (numberOfPotion <= 0) {
                    System.out.println(PIKACHU_NO_HEALING_MESSAGE);
                }

                if (numberOfPotion >= 1) {
                    hpPikachu = HP_MAX;
                    numberOfPotion -= 1;

                    System.out.println(PIKACHU_HEALING_MESSAGE);
                }
            }

            String raichuRemainingHp = "라이츄의 남은 체력: " + hpRaichu;

            if (hpRaichu <= 0) {
                hpRaichu = 0;
                raichuRemainingHp = "라이츄의 남은 체력: " + hpRaichu;

                System.out.println(raichuRemainingHp);
                System.out.println();

                break;
            }

            System.out.println(raichuRemainingHp);

            System.out.println();


            //라이츄 차례
            hpPikachu -= RAICHU_ATTACK_DAMAGE;

            System.out.println(RAICHU_ATTACK_MESSAGE);

            String pikachuRemainingHp = "피카츄의 남은 체력: " + hpPikachu;

            if (hpPikachu <= 0) {
                hpPikachu = 0;
                pikachuRemainingHp = "피카츄의 남은 체력: " + hpPikachu;

                System.out.println(pikachuRemainingHp);
                System.out.println();

                break;
            }

            System.out.println(pikachuRemainingHp);

            System.out.println();

        }

        if (hpPikachu <= 0) {
            System.out.println(PIKACHU_DEFEAT_MESSAGE);
        }

        if (hpRaichu <= 0) {
            System.out.println(PIKACHU_VICTORY_MESSAGE);
        }

    }
}
