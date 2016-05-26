#include <iostream>
#include "Parens.h"
#include "MagicIndex.h"

using namespace std;


int main() {

    // test 9.3 magic index
    vector<int> v = {-10, -9, -8, 3, 30};
    MagicIndex mi(v);
    mi.findMagicIndex();

    // test 9.6 valid (matching) parenths
//    Parens parenths;
//    parenths.generate(3);

    return 0;
}


















