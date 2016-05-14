//
// Created by Ilya Rudyak on 5/13/16.
//

#ifndef CH3_LINKED_LIST_LINKEDLIST_H
#define CH3_LINKED_LIST_LINKEDLIST_H

#include <iostream>
#include "Node.h"
#include "Stack.h"
#include <set>
using namespace std;


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

    // 2.1 remove duplicates using set
    void removeDup();

    // 2.5 add 2 LL 7 -> 1 -> 6 and 5 -> 9 -> 2
    // 612 + 295 = 912, 2 -> 1 -> 9
    void sum(LinkedList<T> &list1, LinkedList<T> &list2);

    // 2.7 check if LL is palindrome
    void reverse();
    bool operator==(LinkedList<T> &other);
    bool isPalindrome();


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
template <typename T> bool LinkedList<T>::isPalindrome() {
    
    Stack<int> stack;
    Node<T> *cur = head;
    for (int i = 0; i < size() / 2; ++i) {
        stack.push(cur->data);
        cur = cur->next;
    }

    int i;
    if (size() % 2 == 0) { i = size() / 2; }
    else { i = size() / 2 + 1; cur = cur->next; }

    for (; i < size(); ++i) {
        if (stack.pop() != cur->data) {
            return false;
        }
        cur = cur->next;
    }

    return true;
}

template <typename T> void LinkedList<T>::sum(LinkedList<T> &list1, LinkedList<T> &list2) {

    int carry = 0, sum;
    Node<T> *cur1 = list1.head;
    Node<T> *cur2 = list2.head;
    for (; cur1 != nullptr, cur2 != nullptr;
           cur1 = cur1->next, cur2 = cur2->next) {
        sum = (cur1->data + cur2->data) % 10;
        addFront(sum + carry);
        carry = (cur1->data + cur2->data) / 10;
    }
    if (carry > 0) {
        addFront(carry);
    }
}

template <typename T> void LinkedList<T>::removeDup() {

    if (empty()) { return; }

    set<int> elements;
    elements.insert(head->data);
    Node<T> *cur = head;
    Node<T> *tmp;

    while (cur->next != nullptr) {
        if (elements.count(cur->next->data) == 1) {
            // remove element
            tmp = cur->next;
            cur->next =cur->next->next;
            delete tmp;
            // no cur advance here
        } else {
            elements.insert(cur->next->data);
            cur = cur->next;
        }
    }
}




#endif //CH3_LINKED_LIST_LINKEDLIST_H
















