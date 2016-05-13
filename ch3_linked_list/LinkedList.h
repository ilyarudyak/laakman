//
// Created by Ilya Rudyak on 5/13/16.
//

#ifndef CH3_LINKED_LIST_LINKEDLIST_H
#define CH3_LINKED_LIST_LINKEDLIST_H

#include <iostream>
using namespace std;

template <typename T> struct Node {
    T data;
    Node* next;
};

template <typename T> class LinkedList {

public:
    LinkedList();
    ~LinkedList();

    bool empty() const;
    int size() const ;

    const T& getFront() const;
    void addFront(const T&);
    void removeFront();

    void show();

    // 2.7 check if LL is palindrome
    void reverse();
    bool operator==(LinkedList<T> &other);


private:
    Node<T>* head;
    int n;
};

template <typename T> LinkedList<T>::LinkedList() {
    head = nullptr;
    n = 0;
}
template <typename T> LinkedList<T>::~LinkedList() {
    while (!empty()) {
        removeFront();
    };
}

template <typename T> bool LinkedList<T>::empty() const {
    return head == nullptr;
}
template <typename T> int LinkedList<T>::size() const {
    return n;
}

template <typename T> const T& LinkedList<T>::getFront() const {
    if (empty()) { return nullptr; }
    else { return head->data; }
}
template <typename T> void LinkedList<T>::addFront(const T &t) {
    Node<T>* newNode = new Node<T>;
    newNode->data = t;

    // this code works even if head == nullptr
    newNode->next = head;
    head = newNode;
    n++;
}
template <typename T> void LinkedList<T>::removeFront() {
    if (empty()) { return; }
    Node<T>* oldHead = head;
    head = head->next;
    delete oldHead;
    n--;
}

template <typename T> void LinkedList<T>::show() {
    if (empty()) {
        cout << "list is empty..." << endl;
        return;
    }
    Node<T>* cur;
    for (cur = head; cur->next != nullptr ; cur = cur->next) {
        cout << cur->data << "->";
    }
    cout << cur->data << endl;
}

template <typename T> void LinkedList<T>::reverse() {

    if (empty()) { return; }

    Node<T> *cur = head;
    Node<T> *prev = nullptr;

    while (cur != nullptr) {
        Node<T> *tmp = cur->next;
        cur->next = prev;
        prev = cur;
        cur = tmp;
    }

    head = prev;
}

template <typename T> bool LinkedList<T>::operator==(LinkedList<T> &other) {

    if (size() != other.size()) { return false; }

    Node<T> * cur = head;
    Node<T> * cur2 = other.head;

    for (; cur != nullptr, cur2 != nullptr;
           cur = cur->next, cur2 = cur2->next ) {
        if (cur->data != cur2->data) {
            return false;
        }
    }

    return true;
}




#endif //CH3_LINKED_LIST_LINKEDLIST_H
















