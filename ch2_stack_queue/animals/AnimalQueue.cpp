#include "AnimalQueue.h"
#include <iostream>
AnimalQueue::AnimalQueue() {

}

AnimalQueue::~AnimalQueue() {
}

int AnimalQueue::size() {
    return (int) animals.size();
}

void AnimalQueue::enqueue(Animal animal) {
    animals.push_front(animal);
}

Animal AnimalQueue::dequeueAny() {
    auto it = animals.end();
    it--;
    return *it;
}

Animal AnimalQueue::dequeueDog() {
    auto it = animals.end();
    it--;
    for (; it != --animals.begin() ; it--) {

        std::cout << it->getName() << std::endl;
        if (it->getType() == "dog") {
            Animal animal = *it;
            animals.erase(it);
            return animal;
        }
    }

    return Animal("", "");
}





























