#include <iostream>
#include "Parens.h"
#include "MagicIndex.h"
#include "Staircase.h"
#include "RobotMove.h"
#include "Coins.h"

using namespace std;


int main() {

    // test 9.1 staircase
//    Staircase staircase(5);
//    staircase.countWays();
//    cout << "# of ways = " << staircase.getWayCount() << endl;
//
//    cout << "# of ways = " << staircase.countWaysDP() << endl;

    // test 9.2 robot move
//    RobotMove rm(make_pair(2, 2), make_pair(0, 1));
//    rm.showSpots();
//    rm.move();

    // test 9.3 magic index
//    vector<int> v = {-10, -9, -8, 3, 30};
//    MagicIndex mi(v);
//    mi.findMagicIndex();

    // test 9.6 valid (matching) parenths
//    Parens parenths;
//    parenths.generate(3);

    // test 9.8 coins
    Coins coins(25);
//    coins.represent2();
//    cout << "count=" << coins.getCount() << endl;
    coins.represent4();
    cout << "count=" << coins.getCount() << endl;

    return 0;
}


















