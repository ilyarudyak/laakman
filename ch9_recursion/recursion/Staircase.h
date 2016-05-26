//
// Created by Ilya Rudyak on 5/26/16.
//

#ifndef RECURSION_STAIRCASE_H
#define RECURSION_STAIRCASE_H

#include <iostream>
using namespace std;

class Staircase {
public:

    Staircase(int n) : n(n), wayCount(0) { }

    void countWays() {
        countWays("", n);
    }


    int getWayCount() const {
        return wayCount;
    }

private:
    int n;
    int wayCount;

    void countWays(string way, int k) {
        if (k == 0) {
            cout << way << endl;
            wayCount++;
            return;
        }

        if (k >= 3) {
            countWays(way + "3", k - 3);
            countWays(way + "2", k - 2);
            countWays(way + "1", k - 1);
        } else if (k >= 2) {
            countWays(way + "2", k - 2);
            countWays(way + "1", k - 1);
        } else if (k >= 1) {
            countWays(way + "1", k - 1);
        }


    }

};

#endif //RECURSION_STAIRCASE_H
















