import java.util.Scanner;

public class SMOLPOX {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter number of untapped black sources (0-15)");
            Scanner sc = new Scanner(System.in);

            int ublack = sc.nextInt();
            Deck d = new Deck(3, 3, ublack, 3);
            int tries = 1500000;
            int cardsdrawn = 8;
            int[] hand = new int[cardsdrawn];
            System.out.println("Calculating...");
            int successcount = 0;
            for (int t = 0; t < tries; ++t) {
                d.shuffleArray();
                int urborgcount = 0;
                int fetidcount = 0;
                int ublackcount = 0;
                int shamblingcount = 0;
                int nonblackcount = 0;
                int landcount = 0;
                int blacklandcount = 0;

                for (int i = 0; i < cardsdrawn; ++i) {
                    switch (d.deck[i]) {
                        case 1:
                            ++urborgcount;
                            ++landcount;
                            break;
                        case 2:
                            ++fetidcount;
                            ++landcount;
                            break;
                        case 3:
                            ++ublackcount;
                            ++blacklandcount;
                            ++  landcount;
                            break;
                        case 4:
                            ++shamblingcount;
                            ++blacklandcount;
                            ++landcount;
                            break;
                        case 5:
                            ++nonblackcount;
                            ++landcount;
                    }
                }

                if (shamblingcount != landcount && urborgcount != landcount && fetidcount != landcount) {
                    switch (landcount) {
                        case 0:
                        case 1:
                            break;
                        case 2:
                            if (d.deck[cardsdrawn - 1] == 4) {
                                break;
                            }
                        default:
                            if (urborgcount > 0 || fetidcount > 0 || blacklandcount >= 2) {
                                ++successcount;
                            }
                    }
                }
            }

            int successPercent = (int) (10000 * (double) successcount / (double) tries);
            System.out.printf("%.1f", (double) successPercent / 100);
            System.out.print("% \n");
        }
    }
}
