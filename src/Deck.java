import java.util.Random;

public class Deck {
    int urborg = 3;
    int fetid = 3;
    int black = 10;
    int shambling = 3;
    int nonblack = 5;
    int ee = 36;
    int[] deck = new int[60];

    Deck(int urborg, int fetid, int untappedBlack, int shambling) {
        this.urborg = urborg;
        this.fetid = fetid;
        this.black = untappedBlack;
        this.shambling = shambling;
        this.nonblack = 24 - urborg - fetid - untappedBlack - shambling;
        this.ee = 36;
        int cardcount = 0;

        int i;
        for (i = 0; i < urborg; ++i) {
            this.deck[cardcount] = 1;
            ++cardcount;
        }

        for (i = 0; i < fetid; ++i) {
            this.deck[cardcount] = 2;
            ++cardcount;
        }

        for (i = 0; i < this.black; ++i) {
            this.deck[cardcount] = 3;
            ++cardcount;
        }

        for (i = 0; i < shambling; ++i) {
            this.deck[cardcount] = 4;
            ++cardcount;
        }

        for (i = 0; i < this.nonblack; ++i) {
            this.deck[cardcount] = 5;
            ++cardcount;
        }

        for (i = 0; i < this.ee; ++i) {
            this.deck[cardcount] = 6;
            ++cardcount;
        }

        this.shuffleArray();
    }

    Deck() {
        this.shuffleArray();
    }

    public void shuffleArray() {
        int[] a = this.deck;
        int n = a.length;
        Random random = new Random();
        random.nextInt();

        for (int i = 0; i < n; ++i) {
            int change = i + random.nextInt(n - i);
            swap(a, i, change);
        }

    }

    private static void swap(int[] a, int i, int change) {
        int temp = a[i];
        a[i] = a[change];
        a[change] = temp;
    }
}
