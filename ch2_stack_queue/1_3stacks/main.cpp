#include <iostream>
#include "MultiStack.h"
using namespace std;

int main() {

    MultiStack<int> mstack;
    mstack.push(0, 1);
    mstack.push(0, 2);
    mstack.push(0, 3);
    mstack.push(0, 4);
    mstack.push(0, 5);
    mstack.push(1, 10);

    cout << mstack.size(0) << " " << mstack.size(1) << endl;
    cout << mstack.pop(0) << endl;
    cout << mstack.size(0) << " " << mstack.size(1) << endl;

    return 0;
}