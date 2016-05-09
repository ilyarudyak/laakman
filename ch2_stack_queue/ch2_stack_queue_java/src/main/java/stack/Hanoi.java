package stack;

/**
 * Created by ilyarudyak on 5/9/16.
 */
public class Hanoi {

    private Stack<Character> start, finish, temp;
    private int N;

    public Hanoi(int n) {

        N = n;

        start = new Stack<>();
        finish = new Stack<>();
        temp = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {
            start.push((char)('A' + i));
        }
    }

    public void solve() {
        solve(N, start, finish, temp);
    }

    private void solve(int n, Stack<Character> s, Stack<Character> f, Stack<Character> t) {
        if (n == 0) { return; }
        solve(n - 1, s, t, f);
        move(s, f);
        solve(n -1, t, f, s);


    }

    private void move(Stack<Character> from, Stack<Character> to) {
        if (!from.isEmpty()) {
            Character ch = from.pop();
            to.push(ch);
        }
    }

    public static void main(String[] args) {

        Hanoi hanoi = new Hanoi(10);
        System.out.print("start: "); hanoi.start.show();

        hanoi.solve();
        System.out.print("finish: "); hanoi.finish.show();

    }
}
