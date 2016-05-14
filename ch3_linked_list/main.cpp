#include <iostream>
#include "LinkedList.h"
#include "Stack.h"
using namespace std;

int main() {

    // 2.1 remove duplicates from unsorted list
//    LinkedList<int> list;
//    list.addFront(3);
//    list.addFront(2); list.addFront(2); list.addFront(2);
//    list.addFront(1); list.addFront(1);
//    list.show();
//
//    list.removeDup();
//    list.show();


    // 2.3 remove node given pointer to it
    // (not previous) - override this element with next
    // remove n-th node from the beginning
    LinkedList<int> list;
    list.addFront(4); list.addFront(3); list.addFront(2);
    list.addFront(1); list.addFront(0);
    list.show();

    list.remove(3);
    list.show();


    // 2.5 add 2 LL 7 -> 1 -> 6 and 5 -> 9 -> 2
    // 612 + 295 = 912, 2 -> 1 -> 9
//    LinkedList<int> list1;
//    list1.addFront(6); list1.addFront(1); list1.addFront(7);
//    list1.show();
//
//    LinkedList<int> list2;
//    list2.addFront(2); list2.addFront(9); list2.addFront(5);
//    list2.show();
//
//    LinkedList<int> list;
//    list.sum(list1, list2);
//    list.reverse();
//    list.show();

    // 2.7 using stack
//    LinkedList<int> list;
//    list.addFront(0);
//    list.addFront(1);
//    list.addFront(2);
//    list.addFront(1);
//    list.addFront(0);
//    list.show();
//
//    cout << list.isPalindrome() << endl;

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