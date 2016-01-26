#include <iostream>
#include <stack>
using namespace std;

void printStack(stack<int> st) {
    cout << "st: ";
    if (st.empty()) {
        cout << "empty" << endl;
        return;
    }

    while (!st.empty()) {
        cout << st.top() << " ";
        st.pop();
    }
    cout << endl;
}

void sort(stack<int> &st, stack<int> &st2, int size) {

    if (st.empty()) {
        return;
    }

    int min = st.top();
    int tmp;
    while(!st.empty()) {
        tmp = st.top();
        st.pop();
        st2.push(tmp);
        if (tmp < min) {
            min = tmp;
        }
    }

    while (st2.size() > size) {
        tmp = st2.top();
        if (tmp != min) {
            st.push(tmp);
        }
        st2.pop();
    }

    st2.push(min);

    sort(st, st2, size + 1);

}
void sort(stack<int> &st, stack<int> &st2) {
    sort(st, st2, 0);
}

/* here we implement an idea from solution:
 * suppose we have elements in sorted order
 * in the right stack. we take top element
 * from left and find a place for it in
 * right stack (we move elements to the left
 * while doing this).
 */
void sort2(stack<int> &left, stack<int> &right, int ltop) {

    if (right.top() < ltop) {
        right.push(ltop);
    } else {
        left.push(right.top());
        right.pop();
        sort2(left, right, ltop);
    }
}

void sort2(stack<int> &left, stack<int> &right) {
    while (!left.empty()) {
        int ltop = left.top();
        left.pop();
        sort2(left, right, ltop);
    }
}

int main() {

    stack<int> left, right;
    left.push(7);
    left.push(10);
    left.push(5);
    right.push(1);
    right.push(3);
    right.push(8);
    right.push(12);

    sort2(left, right);

    printStack(left);
    printStack(right);

    return 0;
}

