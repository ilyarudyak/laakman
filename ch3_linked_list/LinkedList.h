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
    int getSize() const ;

    const T& getFront() const;
    void addFront(const T&);
    void removeFront();

    void show();


private:
    Node<T>* head;
    int size;
};

template <typename T> LinkedList<T>::LinkedList() {
    head = nullptr;
    size = 0;
}
template <typename T> LinkedList<T>::~LinkedList() {
    while (!empty()) {
        removeFront();
    };
}

template <typename T> bool LinkedList<T>::empty() const {
    return head == nullptr;
}
template <typename T> int LinkedList<T>::getSize() const {
    return size;
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
    size++;
}
template <typename T> void LinkedList<T>::removeFront() {
    if (empty()) { return; }
    Node<T>* oldHead = head;
    head = head->next;
    delete oldHead;
    size--;
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

#endif //CH3_LINKED_LIST_LINKEDLIST_H
















