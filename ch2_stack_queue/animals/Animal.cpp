#include "Animal.h"

Animal::Animal(std::string animalName) {
    name = animalName;
}

Animal::~Animal() {

}

std::string Animal::getName() {
    return name;
}
