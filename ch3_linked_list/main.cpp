#include <iostream>
#include "LinkedList.h"
#include "Stack.h"
using namespace std;

int main() {

    // 2.7 using stack
    LinkedList<int> list;
    list.addFront(0);
    list.addFront(1);
    list.addFront(2);
    list.addFront(1);
    list.addFront(0);
    list.show();

    cout << list.isPalindrome() << endl;

    // 2.7 check if LL is palindrome
    // create second list and reverse it
//    LinkedList<int> list;
//    list.addFront(0);
//    list.addFront(1);
//    list.addFront(2);
//    list.addFront(1);
//    list.addFront(0);
//    list.show();
//
//    LinkedList<int> list2;
//    list2.addFront(0);
//    list2.addFront(1);
//    list2.addFront(2);
//    list2.addFront(4);
//    list2.addFront(0);
//    list2.show();
//    list2.reverse();
//
//    cout << (list == list2) << endl;

    return 0;
}