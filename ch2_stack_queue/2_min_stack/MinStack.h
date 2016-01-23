//
// Created by Ilya Rudyak on 1/23/16.
//

#ifndef INC_2_MIN_STACK_MINSTACK_H
#define INC_2_MIN_STACK_MINSTACK_H

# include <algorithm>

template <typename ValueType>
class MinStack {

public:
    MinStack();
    ~MinStack();

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
        ValueType min;
        Node *next;
    };

    Node *first;
    int count;
};

template <typename ValueType>
MinStack<ValueType>::MinStack() {
    first = nullptr;
    count = 0;
}

template <typename ValueType>
MinStack<ValueType>::~MinStack() {
    clear();
}

template <typename ValueType>
int MinStack<ValueType>::size() const {
    return count;
}

template <typename ValueType>
bool MinStack<ValueType>::isEmpty() const {
    return count == 0;
}

template <typename ValueType>
void MinStack<ValueType>::clear() {
    while (count > 0) {
        pop();
    }
}


template <typename ValueType>
void MinStack<ValueType>::push(ValueType value) {

    Node *cp = new Node;
    cp->data = value;

    if (first == nullptr) {
        cp->min = value;
    } else {
        cp->min = std::min(value, first->min);
    }

    // this works even if first == nullptr
    cp->next = first;
    first = cp;

    count++;
}

template <typename ValueType>
ValueType MinStack<ValueType>::peek() const {
    if (first != nullptr) {
        return first->data;
    } else {
        throw "stack is empty";
    }
}

template <typename ValueType>
ValueType MinStack<ValueType>::min() const {
    if (first != nullptr) {
        return first->min;
    } else {
        throw "stack is empty";
    }
}

template <typename ValueType>
ValueType MinStack<ValueType>::pop() {
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

        return res;
    }
}

#endif //INC_2_MIN_STACK_MINSTACK_H
