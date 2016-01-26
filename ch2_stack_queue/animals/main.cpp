#include <iostream>
#include "Animal.h"
#include "AnimalQueue.h"
using namespace std;

int main() {

    Animal chappy("dog", "chappy");
    Animal terminator("dog", "terminator");
    Animal lola("cat", "lola");

    AnimalQueue queue;
    queue.enqueue(lola);
    queue.enqueue(chappy);
    queue.enqueue(terminator);

    cout << queue.dequeueDog().getName() << endl;
    cout << queue.dequeueDog().getName() << endl;

    return 0;
}