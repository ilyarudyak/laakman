#include <iostream>
#include "MyQueue.h"
using namespace std;

int main() {

    MyQueue<int> mq;
    for (int i = 0; i < 5; ++i) {
        mq.enqueue(i);
    }
    cout << mq.dequeue() << endl;
    cout << mq.dequeue() << endl;
    return 0;
}