package intro.shape;

/**
 * Created by ilyarudyak on 7/8/16.
 */
public abstract class Shape {

    public void printMe() {
        System.out.print("I am a shape ... ");
    }

    public abstract double computeArea();
}
