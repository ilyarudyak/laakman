package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ilyarudyak on 6/1/16.
 */
public class BoxStack {

    public static int maxHeight = 0;
    public static List<Box> maxStack = null;


    public static void createStackR(List<Box> stack, List<Box> boxes) {
        if (boxes.isEmpty()) {
            int height = stackHeight(stack);
            if (height > maxHeight) {
                maxHeight = height;
                maxStack = new ArrayList<Box>(stack);
            }
            show(stack);
        } else {
            Box boxToAdd = boxes.get(0);
            Box lastBox;
            if (stack.isEmpty()) {
                lastBox = null;
            } else {
                lastBox = stack.get(stack.size() - 1);
            }

            List<Box> boxes2 = new ArrayList<Box>(boxes);
            boxes2.remove(0);

            if (boxToAdd.canBeAbove(lastBox)) {
                List<Box> stack2 = new ArrayList<Box>(stack);
                stack2.add(boxToAdd);
                createStackR(stack2, boxes2);
            }
            createStackR(stack, boxes2);
        }
    }

    // helper method
    private static int stackHeight(List<Box> boxes) {
        if (boxes == null) {
            return 0;
        }
        int h = 0;
        for (Box b : boxes) {
            h += b.height;
        }
        return h;
    }
    private static void show(List<Box> stack) {
        if (stack == null) {
            System.out.println("stack is empty...");
        }
        for (int i = stack.size() - 1; i >= 0; i--) {
            Box b = stack.get(i);
            System.out.print(b.toString() + " ");
        }
        System.out.println("height=" + stackHeight(stack));
    }

    public static void main(String[] args) {

        List<Box> boxes = new ArrayList<Box>();
        boxes.add(new Box(5, 3, 3));
        boxes.add(new Box(4, 4, 4));
        boxes.add(new Box(2, 2, 2));
        boxes.add(new Box(1, 1, 1));

        createStackR(new ArrayList<Box>(), boxes);

        System.out.println();
        show(maxStack);
        System.out.println("maxHeight=" + maxHeight);

    }
}
















