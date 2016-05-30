package solutions;

import java.awt.*;

/**
 * Created by ilyarudyak on 5/30/16.
 */
public class PaintFill {
    public enum Color {
        Black, White, Red, Yellow, Green
    }

    public static boolean PaintFill(Color[][] screen, int x, int y, Color newColor) {
        if (screen[y][x] == newColor) return false;
        return PaintFill(screen, x, y, screen[y][x], newColor);
    }
    // recursive function
    public static boolean PaintFill(Color[][] screen, int x, int y, Color oldColor, Color newColor) {
        if ( isOutOfScreen(screen, new Point(x, y)) || (screen[x][y] != oldColor) ) {
            return false;
        }

        screen[x][y] = newColor;

        PaintFill(screen, x - 1, y    , oldColor, newColor);
        PaintFill(screen, x + 1, y    , oldColor, newColor);
        PaintFill(screen, x    , y - 1, oldColor, newColor);
        PaintFill(screen, x    , y + 1, oldColor, newColor);

        return true;
    }

    // utility functions
    public static String PrintColor(Color c) {
        switch(c) {
            case Black:
                return "B";
            case White:
                return "-";
            case Red:
                return "R";
            case Yellow:
                return "Y";
            case Green:
                return "G";
        }
        return "X";
    }
    public static void PrintScreen(Color[][] screen) {
        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[0].length; j++) {
                System.out.print(PrintColor(screen[i][j]));
            }
            System.out.println();
        }
    }
    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }
    private static boolean isOutOfScreen(Color[][] screen, Point p) {
        if (p.getX() < 0 || p.getX() >= screen.length) { return true; }
        if (p.getY() < 0 || p.getY() >= screen.length) { return true; }
        return false;
    }

    public static void main(String[] args) {
        int N = 4;
        Color[][] screen = new Color[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                screen[i][j] = Color.Black;
            }
        }
        for (int i = 0; i < N * N; i++) {
            screen[randomInt(N)][randomInt(N)] = Color.Green;
        }
        PrintScreen(screen);
        PaintFill(screen, 0, 0, Color.White);
        System.out.println();
        PrintScreen(screen);
    }
}
