package solutions;

/**
 * Created by ilyarudyak on 6/1/16.
 */
public class Box {
    public int width;
    public int height;
    public int depth;
    public Box(int w, int h, int d) {
        width = w;
        height = h;
        depth = d;
    }

    public boolean canBeUnder(Box b) {
        if (width > b.width && height > b.height && depth > b.depth) {
            return true;
        }
        return false;
    }

    public boolean canBeAbove(Box b) {
        if (b == null) {
            return true;
        }
        if (width < b.width && height < b.height && depth < b.depth) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "box(" + width + "," + height + "," + depth + ")";
    }
}
