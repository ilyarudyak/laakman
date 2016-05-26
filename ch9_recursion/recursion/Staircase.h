//
// Created by Ilya Rudyak on 5/26/16.
//

#ifndef RECURSION_STAIRCASE_H
#define RECURSION_STAIRCASE_H

#include <iostream>
#include <vector>
using namespace std;

class Staircase {
public:

    Staircase(int n) : n(n), wayCount(0) {
        map.resize((unsigned long) (n + 1), -1);
    }

    void countWays() {
        countWays("", n);
    }
    int countWaysDP() {
        return countWaysDP(n);
    }


    int getWayCount() const {
        return wayCount;
    }

private:
    int n;
    int wayCount;
    vector<int> map;

    void countWays(string way, int k) {

        // this idea is from solution - we
        // may skip 3 cases below
        if (k < 0) { return; }

        if (k == 0) {
            cout << way << endl;
            wayCount++;
            return;
        }

//        if (k >= 3) {
            countWays(way + "3", k - 3);
            countWays(way + "2", k - 2);
            countWays(way + "1", k - 1);
//        } else if (k >= 2) {
//            countWays(way + "2", k - 2);
//            countWays(way + "1", k - 1);
//        } else if (k >= 1) {
//            countWays(way + "1", k - 1);
//        }


    }
    int countWaysDP(int k) {
        if (k < 0) {
            return 0;
        } else if (k == 0) {
            return 1;
        } else if (map[k] > -1) {
            return map[k];
        } else {
            map[k] = countWaysDP(k - 1) +
                     countWaysDP(k - 2) +
                     countWaysDP(k - 3);
            return map[k];
        }
    }

};

#endif //RECURSION_STAIRCASE_H
















