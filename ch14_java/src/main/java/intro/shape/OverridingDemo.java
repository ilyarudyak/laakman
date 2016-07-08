package intro.shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ilyarudyak on 7/8/16.
 */
public class OverridingDemo {

    public static void printArea(Circle c) {
        System.out.println("The circle is " + c.computeArea());
    }

//    public static void printArea(Square s) {
//        System.out.println("The square is " + s.computeArea());
//    }

    public static void printArea(Ambiguous s) {
        System.out.println("The ambiguous is undefined");
    }

    public static void main(String[] args) {

        List<Shape> shapes = new ArrayList<>(Arrays.asList(new Circle(), new Ambiguous()));

        for (Shape s : shapes) {
            s.printMe();
            System.out.println(s.computeArea());
        }
    }
}
