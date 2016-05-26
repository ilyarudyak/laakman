//
// Created by Ilya Rudyak on 5/26/16.
//

#ifndef RECURSION_PARENTS_H
#define RECURSION_PARENTS_H

#include <string>
#include <iostream>

using namespace std;

class Parenths {
public:

    void generate(int n) {
        generate("", 0, 0, n);
    }

private:
    void generate (string acc, int left, int right, int n) {

        if (left == n && right == n) {
            cout << acc << " " << endl;
            return;
        }

        if (left < n && right < n) {
            generate(acc + "(", left + 1, right, n);
            if (left > right) {
                generate(acc + ")", left, right + 1, n);
            }
        } else if (left == n && right < n) {
            generate(acc + ")", left, right + 1, n);
        }
    }

};

#endif //RECURSION_PARENTS_H






















