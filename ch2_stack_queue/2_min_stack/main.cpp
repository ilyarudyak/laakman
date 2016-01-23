#include <iostream>
#include <stack>
#include "MinStack.h"
#include "MinStack2.h"
#include "MinStack3.h"

using namespace std;

int main() {

//    // here's the 2nd idea - have 2 stacks
//    stack<int> mainStack, minStack;
//
//    mainStack.push(3);
//    minStack.push(3);
//
//    mainStack.push(5);
//
//    mainStack.push(2);
//    minStack.push(2);
//
//    mainStack.push(4);
//
//    mainStack.push(1);
//    minStack.push(1);
//
//    cout << "min=" << minStack.top() << endl;
//    mainStack.pop();
//    minStack.pop();
//    cout << "min=" << minStack.top() << endl;

    MinStack2<int> mstack;
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