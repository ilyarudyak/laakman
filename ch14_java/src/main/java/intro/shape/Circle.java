package intro.shape;

/**
 * Created by ilyarudyak on 7/8/16.
 */
public class Circle extends Shape {

    private double rad = 5;

    @Override
    public void printMe() {
        System.out.print("I am a circle ... ");
    }

    @Override
    public double computeArea() {
        return 0;
    }
}
