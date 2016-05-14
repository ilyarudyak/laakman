//
// Created by Ilya Rudyak on 5/13/16.
//

#ifndef CH3_LINKED_LIST_STACK_H
#define CH3_LINKED_LIST_STACK_H

#include "Node.h"
#include "LinkedList.h"

template <typename T> class Stack {
public:
    Stack();
    ~Stack();

    T& pop();
    void push(const T&);

    void show();

private:
    Node<T> *top;
    int n;
};

template <typename T> Stack<T>::Stack() { }
template <typename T> Stack<T>::~Stack() { }

template <typename T> T& Stack<T>::pop() {
    Node<T> *tmp = top;
    T t = top->data;
    top = top->next;
    delete tmp;
    n--;
    return t;
}
template <typename T> void Stack<T>::push(const T& t) {
    Node<T>* newNode = new Node<T>;
    newNode->data = t;

    // this code works even if head == nullptr
    newNode->next = top;
    top = newNode;
    n++;
}

template <typename T> void Stack<T>::show() {
    Node<T> *cur = top;
    while (cur != nullptr) {
        std::cout << cur->data << " ";
        cur = cur->next;
    }
}

#endif //CH3_LINKED_LIST_STACK_H














