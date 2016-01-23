//
// Created by Ilya Rudyak on 1/24/16.
//

#ifndef INC_2_MIN_STACK_MINSTACK3_H
#define INC_2_MIN_STACK_MINSTACK3_H

# include <algorithm>

template <typename ValueType>
class MinStack3 {

public:
    MinStack3();
    ~MinStack3();

    int size() const;
    bool isEmpty() const;
    void clear();

    void push(ValueType value);
    ValueType pop();
    ValueType peek() const;
    ValueType min() const;


private:

    struct Node {

        ValueType data;
//        ValueType min;
        Node *next;
    };

    Node *first;
    int count;
    MinStack3<ValueType> mstack;
};

template <typename ValueType>
MinStack3<ValueType>::MinStack3() {
    first = nullptr;
    count = 0;
}

template <typename ValueType>
MinStack3<ValueType>::~MinStack3() {
    clear();
}

template <typename ValueType>
int MinStack3<ValueType>::size() const {
    return count;
}

template <typename ValueType>
bool MinStack3<ValueType>::isEmpty() const {
    return count == 0;
}

template <typename ValueType>
void MinStack3<ValueType>::clear() {
    while (count > 0) {
        pop();
    }
}


template <typename ValueType>
void MinStack3<ValueType>::push(ValueType value) {

    Node *cp = new Node;
    cp->data = value;

//    if (first == nullptr) {
//        cp->min = value;
//    } else {
//        cp->min = std::min(value, first->min);
//    }

    // this works even if first == nullptr
    cp->next = first;
    first = cp;

    count++;

    if (mstack.isEmpty()) {
        mstack.push(value);
    } else {
        if (value <= mstack.peek()) {
            mstack.push(value);
        }
    }
}

template <typename ValueType>
ValueType MinStack3<ValueType>::peek() const {
    if (first != nullptr) {
        return first->data;
    } else {
        throw "stack is empty";
    }
}

template <typename ValueType>
ValueType MinStack3<ValueType>::min() const {
    return mstack.peek();
//    if (first != nullptr) {
//        return first->min;
//    } else {
//        throw "stack is empty";
//    }
}

template <typename ValueType>
ValueType MinStack3<ValueType>::pop() {
    if (first != nullptr) {

        // store tmp variables
        ValueType res = first->data;
        Node *tmp = first;

        // update first (now it points to
        // the 2nd element)
        first = first->next;

        // clear popped Node
        delete tmp;
        count--;

        // handle min stack
        if (!mstack.isEmpty() && res == mstack.peek()) {
            mstack.pop();
        }

        return res;
    }


}

#endif //INC_2_MIN_STACK_MINSTACK3_H
