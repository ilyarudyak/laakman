/**
 * Created by ilyarudyak on 6/8/16.
 */
public class NextLargest {

    private int N;

    public NextLargest(int n) {
        N = n;
    }

    // we toggle first 1 (bit i)
    // and first 0 on some *next* position (> i)
    public int nextLargestSimple() {
        int n = N;
        n = toggleBit(n, firstSetBit());
        n = toggleBit(n, firstUnSetBit());
        return n;
    }

    public int nextLargestFull() {
        int n = N;
        n = toggleBit(n, firstSetBit());
        n = toggleBit(n, firstUnSetBit());
        return n;
    }

    // helper methods
    private int countOne(int p) {

        int count = 0;

        // remove bits in n except part before p
        int n = N;
        n &= (1 << p) - 1;

        while (n != 0) {
            n &= (n - 1);
            count++;
        }

        return count;
    }
    private int toggleBit(int n, int i) {
        n ^= 1 << i;
        return n;
    }
    private int firstSetBit() {
        for (int i = 0; i < 32; i++) {
            if ((N & (1 << i)) != 0) {
                return i;
            }
        }
        return -1;
    }
    private int firstUnSetBit() {
        for (int i = firstSetBit(); i < 32; i++) {
            if ((N & (1 << i)) == 0) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int N = Integer.parseInt("101001110", 2);
        System.out.print("n=" + N + " ");
        System.out.println( Integer.toBinaryString(N) );

        NextLargest nl = new NextLargest(N);

        int p = nl.firstUnSetBit();
        System.out.println(nl.countOne(p));


    }
}

















