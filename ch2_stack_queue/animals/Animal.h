//
// Created by Ilya Rudyak on 1/26/16.
//

#ifndef ANIMALS_ANIMAL_H
#define ANIMALS_ANIMAL_H

#include <string>

class Animal {

public:
    Animal(std::string type, std::string name);
    ~Animal();
    std::string getName();
    std::string getType();

private:
    std::string type;
    std::string name;
};


#endif //ANIMALS_ANIMAL_H
