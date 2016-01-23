//
// We create 2 stacks in one array
// (instead of 3 in the exercise)
//

#ifndef INC_1_3STACKS_MULTISTACK_H
#define INC_1_3STACKS_MULTISTACK_H

template <typename ValueType>
class MultiStack {

public:
    MultiStack();
    ~MultiStack();

    int size(int stack) const;
    bool isEmpty(int stack) const;
    void clear(int stack);

    void push(int stack, ValueType value);
    ValueType pop(int stack);
    ValueType peek(int stack) const;


private:

    static const int INITIAL_CAPACITY = 1;
    static const int NUMBER_OF_STACKS = 2;
    ValueType *array;
    int singleCapacity;
    int count0, count1;

    void expandCapacity();
};

template <typename ValueType>
MultiStack<ValueType>::MultiStack() {
    singleCapacity = INITIAL_CAPACITY;
    array = new ValueType[NUMBER_OF_STACKS * singleCapacity];
    count0 = 0;
    count1 = 0;
}

template <typename ValueType>
MultiStack<ValueType>::~MultiStack() {
    delete[] array;
}

template <typename ValueType>
int MultiStack<ValueType>::size(int stack) const {
    switch (stack) {
        case 0:
            return count0;
        case 1:
            return count1;
        default:
            throw "illegal argument";
    }
}

template <typename ValueType>
bool MultiStack<ValueType>::isEmpty(int stack) const {
    switch (stack) {
        case 0:
            return count0 == 0;
        case 1:
            return count1 == 0;
        default:
            throw "illegal argument";
    }
}

template <typename ValueType>
void MultiStack<ValueType>::clear(int stack) {
    switch (stack) {
        case 0:
            count0 = 0;
            break;
        case 1:
            count1 = 0;
            break;
        default:
            throw "illegal argument";
    }
}

template <typename ValueType>
void MultiStack<ValueType>::push(int stack, ValueType value) {
    if (count0 == singleCapacity || count1 == singleCapacity) {
        expandCapacity();
    }
    switch (stack) {
        case 0:
            array[count0++] = value;
            break;
        case 1:
            array[singleCapacity + count1] = value;
            count1++;
            break;
        default:
            throw "illegal argument";
    }
}

/*
 * Implementation notes: pop, peek
 * -------------------------------
 * These functions checks for an empty stack and reports an error
 * if there is no top element.
 */

template <typename ValueType>
ValueType MultiStack<ValueType>::pop(int stack) {
    if (isEmpty(stack)) throw "pop: Attempting to pop an empty stack";
    switch (stack) {
        case 0:
            count0--;
            return array[count0];
        case 1:
            count1--;
            return array[singleCapacity + count1];
        default:
            throw "illegal argument";
    }
}

template <typename ValueType>
ValueType MultiStack<ValueType>::peek(int stack) const {
    if (isEmpty(stack)) throw "peek: Attempting to peek at an empty stack";
    switch (stack) {
        case 0:
            return array[count0 - 1];
        case 1:
            return array[singleCapacity + count1 - 1];
        default:
            throw "illegal argument";
    }
}

template <typename ValueType>
void MultiStack<ValueType>::expandCapacity() {
    ValueType *oldArray = array;
    singleCapacity *= 2;
    array = new ValueType[ 2 * singleCapacity];
    for (int i = 0; i < count0; i++) {
        array[i] = oldArray[i];
    }
    for (int i = singleCapacity; i < singleCapacity + count1; i++) {
        array[i] = oldArray[i];
    }
    delete[] oldArray;
}

#endif //INC_1_3STACKS_MULTISTACK_H















