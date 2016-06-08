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


    public static void main(String[] args) {

        int n = Integer.parseInt("10000000000", 2);
        int m = Integer.parseInt("10011", 2);
        SetBitField sbf = new SetBitField(n, m, 2, 6);
        System.out.println(Integer.toBinaryString(sbf.set()));
    }
}
