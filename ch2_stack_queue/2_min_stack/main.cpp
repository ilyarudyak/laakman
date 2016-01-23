#include <iostream>
#include "MinStack.h"
using namespace std;

int main() {

    MinStack<int> mstack;
    mstack.push(3);
    mstack.push(5);
    mstack.push(2);
    mstack.push(4);
    mstack.push(1);

    cout << "min=" << mstack.min() << endl;

    mstack.pop();
    cout << "min=" << mstack.min() << endl;

    mstack.pop();
    cout << "min=" << mstack.min() << endl;

    mstack.pop();
    cout << "min=" << mstack.min() << endl;

    return 0;
}