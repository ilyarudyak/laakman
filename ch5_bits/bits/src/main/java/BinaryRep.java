import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ilyarudyak on 6/10/16.
 */
public class BinaryRep {

    private double N;

    public BinaryRep(double n) {
        N = n;
    }

    public String repFractionPart() {

        BigDecimal fraction = new BigDecimal(Double.toString(N - (int) N));
        BigDecimal x = new BigDecimal("-1");
        Set<BigDecimal> digits = new HashSet<>();
        String rep = "";
        int n;

        while (x.compareTo(new BigDecimal("0")) != 0) {
            x = fraction.multiply(new BigDecimal("2"));
            System.out.println(x);

            // check if periodic
            if (digits.contains(x)) {
                rep += " ...";
                break;
            }
            digits.add(x);

            // add to string
            n = x.intValue();
            rep += Integer.toString(n);

            // reduce fraction
            fraction = x.subtract(new BigDecimal(Integer.toString(n)));

        }
        return rep;
    }

    public String repIntPart() {

        int n = (int) N;

        String rep = "";
        for (int i = 0; i < 32; i++) {
            if ((n >> i & 1) == 1 ) {
                rep = "1" + rep;
            } else {
                rep = "0" + rep;
            }
        }

        return rep;
    }

    public static void main(String[] args) {

        BinaryRep br = new BinaryRep(0.72);
//        System.out.println( Integer.toBinaryString((int) br.N) );
        System.out.println(br.repFractionPart());


    }
}
