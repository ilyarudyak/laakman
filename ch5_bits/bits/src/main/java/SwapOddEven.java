/**
 * Created by ilyarudyak on 6/10/16.
 */
public class SwapOddEven {

    private int N;
    private int bits = 8;

    public SwapOddEven(int n) {
        N = n;
    }

    public int swap() {

        int mask10 = buildMask10();
        int mask01 = buildMask01();

        return ((N & mask10) >> 1) | ((N & mask01) << 1);
    }

    // helper functions
    private int buildMask10() {
        int mask = 0;
        for (int i = 1; i < bits; i += 2) {
            mask |= 1 << i;
        }
        return mask;
    }
    private int buildMask01() {
        int mask = 0;
        for (int i = 0; i < bits; i += 2) {
            mask |= 1 << i;
        }
        return mask;
    }

    public static void main(String[] args) {

        int n = Integer.parseInt("10110110", 2);
        SwapOddEven soe = new SwapOddEven(n);
        System.out.println( Integer.toBinaryString(soe.swap()) );

    }
}
















