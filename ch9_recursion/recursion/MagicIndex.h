//
// Created by Ilya Rudyak on 5/26/16.
//

#ifndef RECURSION_MAGICINDEX_H
#define RECURSION_MAGICINDEX_H

#include <vector>
#include <iostream>

using namespace std;

class MagicIndex {

public:

    MagicIndex(const vector<int> &v) : v(v) { }

    void findMagicIndex() {
        findMagicIndex(0, (int) (v.size() - 1));
    }

private:
    vector<int> v;
    void findMagicIndex(int i, int j) {

        cout << "i=" << i << " j=" << j << " ";

        if (i > j) {
            return;
        }

        int mid = (i + j) / 2;

        cout << " mid=" << mid << endl;

        if (v[mid] == mid) {
            cout << "magic=" << i << endl;
            return;
        } else if (v[mid] < mid) {
            findMagicIndex(mid + 1, j);
        } else /* v[i] > i */ {
            findMagicIndex(i, mid - 1);
        }
    }

};

#endif //RECURSION_MAGICINDEX_H















