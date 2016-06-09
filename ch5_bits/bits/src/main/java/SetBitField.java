/**
 * Created by ilyarudyak on 6/8/16.
 */
public class SetBitField {

    private int M;
    private int N;
    private int i;
    private int j;

    public SetBitField(int n, int m, int i, int j) {
        M = m;
        N = n;
        this.i = i;
        this.j = j;
    }

    public int set() {
        String maskStr = "";
        for (int k = 0; k <= j - i; k++) {
            maskStr += "1";
        }
        int mask = ~(Integer.parseInt(maskStr, 2) << i);

        // clear bit field
        int res = N & mask;

        // set bit field
        res |= M << i;

        return res;
    }

    private int buildMask(int i, int j) {
        return (~0 << (j + 1)) | ~(~0 << i);
    }

    private int buildMask2(int i, int j) {
        int mask = 0;
        int bitval = 1;
        while (j-- > 1) {
            mask |= bitval;
            bitval <<= 1;
        }
        System.out.println( Integer.toBinaryString(mask));
        mask <<= i;
        return ~mask;
    }

    public static void main(String[] args) {

        int n = Integer.parseInt("10000000000", 2);
        int m = Integer.parseInt("10011", 2);
        int i = 2; int j = 6;
        SetBitField sbf = new SetBitField(n, m, i, j);
        System.out.println( Integer.toBinaryString(sbf.buildMask2(i, j)) );

//        System.out.println(Integer.toBinaryString(sbf.set()));


    }
}



















