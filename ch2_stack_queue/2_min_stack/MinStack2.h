//
// Created by Ilya Rudyak on 1/24/16.
//

#ifndef INC_2_MIN_STACK_MINSTACK2_H
#define INC_2_MIN_STACK_MINSTACK2_H

# include <algorithm>

template <typename ValueType>
class MinStack2 {

public:
    MinStack2();
    ~MinStack2();

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
        Node *next;
    };

    Node *first;
    Node *mfirst;
    int count;

};

template <typename ValueType>
MinStack2<ValueType>::MinStack2() {
    first = nullptr;
    mfirst = nullptr;
    count = 0;
}

template <typename ValueType>
MinStack2<ValueType>::~MinStack2() {
    clear();
}

template <typename ValueType>
int MinStack2<ValueType>::size() const {
    return count;
}

template <typename ValueType>
bool MinStack2<ValueType>::isEmpty() const {
    return count == 0;
}

template <typename ValueType>
void MinStack2<ValueType>::clear() {
    while (count > 0) {
        pop();
    }
}

template <typename ValueType>
void MinStack2<ValueType>::push(ValueType value) {

    Node *cp = new Node;
    cp->data = value;
    cp->next = first;
    first = cp;
    count++;

    Node *mp = new Node;
    if (mfirst == nullptr) {
        mp->data = value;
        mp->next = mfirst;
        mfirst = mp;
    } else {
        if (value <= mfirst->data) {
            mp->data = value;
            mp->next = mfirst;
            mfirst = mp;
        }
    }

}

template <typename ValueType>
ValueType MinStack2<ValueType>::peek() const {
    if (first != nullptr) {
        return first->data;
    } else {
        throw "stack is empty";
    }
}

template <typename ValueType>
ValueType MinStack2<ValueType>::min() const {
    if (mfirst != nullptr) {
        return mfirst->data;
    } else {
        throw "stack is empty";
    }
}

template <typename ValueType>
ValueType MinStack2<ValueType>::pop() {
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
        if (res == mfirst->data) {
            Node *tmp2 = mfirst;
            mfirst = mfirst->next;
            delete tmp2;
        }


        return res;
    }
}

#endif //INC_2_MIN_STACK_MINSTACK2_H
