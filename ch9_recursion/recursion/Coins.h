//
// Created by Ilya Rudyak on 5/27/16.
//

#ifndef RECURSION_CENTS_H
#define RECURSION_CENTS_H

#include <vector>
#include <iostream>
#include <map>

using namespace std;

class Coins {
public:
    const vector<int> coins = {1, 5, 10, 25};
    const map<char, int> coinsMap = {
            {'q', 25},
            {'d', 10},
            {'n', 5},
            {'p', 1}
    };

    Coins(int n) : N(n), count(0) { }

    void represent() {
        represent(0, 0, 0, 0, N);
    }
    void represent2() {
        for (int p = 0; p <= N; ++p) {
            for (int n = 0; n <= N / 5; ++n) {
                for (int d = 0; d <= N / 10; ++d) {
                    for (int q = 0; q <= N / 25; ++q) {
                        if ((p + 5 * n + 10 * d + 25 * q) == N) {
                            cout << "p=" << p << " n=" << n
                            << " d=" << d << " q=" << q << endl;
                            count++;
                        }
                    }
                }
            }
        }
    }
    void represent3() {
        represent3(0, 0, 0, 0, 0);
    }
    void change() {
        string coinStr("qdnp");
        change("", coinStr, N);
    }

    int getCount() const {
        return count;
    }


    void setCount(int count) {
        this->count = count;
    }

private:
    int N;
    int count;

    void represent(int p, int n, int d, int q, int k) {
        cout << "p=" << p << " n=" << n
        << " d=" << d << " q=" << q << " k=" << k << endl;
        if (k < 0) return;
        if (k == 0) {
            cout << "p=" << p << " n=" << n
            << " d=" << d << " q=" << q << endl;
            count++;
            return;
        }

        represent(p    , n    , d    , q + 1, k - 25);
        represent(p    , n    , d + 1, q    , k - 10);
        represent(p    , n + 1, d    , q    , k - 5 );
        represent(p + 1, n    , d    , q    , k - 1 );
    }
    void represent3(int p, int n, int d, int q, int sum) {

        if (sum > N) return;
        if (sum == N) {
            cout << "p=" << p << " n=" << n
            << " d=" << d << " q=" << q << endl;
            count++;
            return;
        }

        represent3(p    , n    , d    , q + 1, sum + 25);
        represent3(p    , n    , d + 1, q    , sum + 10);
        represent3(p    , n + 1, d    , q    , sum + 5 );
        represent3(p + 1, n    , d    , q    , sum + 1 );
    }

    int getValue(char ch) {
        switch (ch) {
            case 'q':
                return 25;
            case 'd':
                return 10;
            case 'n':
                return 5;
            case 'p':
                return 1;
            default:
                return 0;
        }
    }
    void change(string acc, string coinsStr, int sum) {

//        cout << acc << " " << coinsStr << endl;

        if (coinsStr.size() == 1) {
//            cout << acc << "-" << sum << endl;
            count++;
            return;
        }

        char ch = coinsStr[0];
        int value = getValue(ch);
//        cout << ch << " " << value << " " << sum / value << endl;
        for (int i = sum / value; i >= 0; --i) {
            change(acc + "-" + to_string(i), coinsStr.substr(1), sum - i * value);
        }
    }




};

#endif //RECURSION_CENTS_H



















