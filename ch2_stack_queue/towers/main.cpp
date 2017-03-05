#include <iostream>
#include <stack>
using namespace std;

void towers(int n, stack<int> &start,
            stack<int> &finish, stack<int> &temp);

int main() {

    stack<int> a, b, c;
    for (int i = 5; i > 0; i--) {
        a.push(i);
    }

    towers(5, a, b, c);

    for (int i = 0; i < 5; i++) {
        cout << b.top();
        b.pop();
    }
    cout << endl;

    return 0;
}

void move(stack<int> &src, stack<int> &dst) {
    dst.push(src.top());
    src.pop();
}

void towers(int n, stack<int> &start,
            stack<int> &finish, stack<int> &temp) {

    if (n == 0) {
        return;
    }

    towers(n - 1, start, temp, finish);
    move(start, finish);
    towers(n - 1, temp, finish, start);
}











