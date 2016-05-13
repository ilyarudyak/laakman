#include <iostream>
#include "LinkedList.h"
using namespace std;

int main() {

    LinkedList<int> list;
    for (int i = 0; i < 10; ++i) {
        list.addFront(i);
    }
    list.show();

    return 0;
}