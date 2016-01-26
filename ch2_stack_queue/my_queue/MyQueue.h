#ifndef MY_QUEUE_MYQUEUE_H
#define MY_QUEUE_MYQUEUE_H

#include <stack>


/* *
 * we store incoming objects in left stack
 * and move them into right stack (and back)
 * if we need to deque an element.
 *
 * so we have O(1) to enqueue() operation and
 * O(N) to dequeue().
 *
 * we may implement queue to switch these
 * complexities.
 * */
template <typename ValueType>
class MyQueue {

public:
    MyQueue();
    ~MyQueue();

    int size();
    bool isEmpty();
    void enqueue(ValueType value);
    ValueType dequeue();

private:
    std::stack<ValueType> left;
    std::stack<ValueType> right;

};

template <typename ValueType>
MyQueue<ValueType>::MyQueue() {
    std::stack<ValueType> left;
    std::stack<ValueType> right;
}

template <typename ValueType>
MyQueue<ValueType>::~MyQueue() {

}

template <typename ValueType>
int MyQueue<ValueType>::size() {
    // we store values in the left stack
    return (int) left.size();
}

template <typename ValueType>
bool MyQueue<ValueType>::isEmpty() {
    return left.empty();
}

template <typename ValueType>
void MyQueue<ValueType>::enqueue(ValueType value){
    left.push(value);
}

// we move all value to the right
// get the last value and move back
template <typename ValueType>
ValueType MyQueue<ValueType>::dequeue(){
    while (!left.empty()) {
        right.push(left.top());
        left.pop();
    }

    ValueType res = right.top();
    right.pop();

    while (!right.empty()) {
        left.push(right.top());
        right.pop();
    }
    return res;
}


#endif //MY_QUEUE_MYQUEUE_H


















