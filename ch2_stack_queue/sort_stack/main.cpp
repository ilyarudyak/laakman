#include <iostream>
#include <stack>
using namespace std;

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

void sort2(stack<int> &st, stack<int> &st2) {

}

int main() {

    stack<int> st;
    stack<int> st2;
    st.push(3);
    st.push(5);
    st.push(2);
    st.push(4);
    st.push(1);

    sort2(st, st2);

    cout << "st2: ";
    while (!st2.empty()) {
        cout << st2.top() << " ";
        st2.pop();
    }
    cout << endl;

    return 0;
}

