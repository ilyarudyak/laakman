#include "Animal.h"

Animal::Animal(std::string animalType,
               std::string animalName) {
    type = animalType;
    name = animalName;
}

Animal::~Animal() {

}

std::string Animal::getName() {
    return name;
}

std::string Animal::getType() {
    return type;
}
