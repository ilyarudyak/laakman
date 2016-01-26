//
// Created by Ilya Rudyak on 1/26/16.
//

#ifndef ANIMALS_ANIMALQUEUE_H
#define ANIMALS_ANIMALQUEUE_H

#include "Animal.h"
#include <list>

class AnimalQueue {

public:
    AnimalQueue();
    ~AnimalQueue();
    int size();
    void enqueue(Animal animal);
    Animal dequeueAny();
    Animal dequeueDog();

private:
    std::list<Animal> animals;

};


#endif //ANIMALS_ANIMALQUEUE_H



















