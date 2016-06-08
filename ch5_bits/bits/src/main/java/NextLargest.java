/**
 * Created by ilyarudyak on 6/8/16.
 */
public class NextLargest {

    private int N;
    private int oneCount;

    public NextLargest(int n) {
        N = n;
        countOne();
    }

    public int nextLargest() {
        int n = N;
        n = toggleBit(n, firstSetBit());
        n = toggleBit(n, firstUnSetBit());
        return n;
    }

    public int next2() {
        String nextStr = "0";
        for (int i = 0; i < oneCount; i++) {
            nextStr += "1";
        }

        for (int i = 1; i < 32 - oneCount; i++) {
            nextStr += "0";
        }

        System.out.println(nextStr);

        return Integer.parseInt(nextStr, 2);
    }

    // helper methods
    private void countOne() {
        int n = N;
        while (n != 0) {
            oneCount++;
            n &= (n - 1);
        }
    }
    private int toggleBit(int n, int i) {
        n ^= 1 << i;
        return n;
    }
    private int setBit(int n, int i) {
        n |= 1 << i;
        return n;
    }
    private int unsetBit(int n, int i) {
        n &= ~(1 << i);
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

        int N = Integer.parseInt("101010010", 2);
        NextLargest nl = new NextLargest(N);
        System.out.println(nl.nextLargest());
    }
}

















