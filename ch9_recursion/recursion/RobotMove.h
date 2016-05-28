//
// Created by Ilya Rudyak on 5/27/16.
//

#ifndef RECURSION_ROBOTMOVE_H
#define RECURSION_ROBOTMOVE_H

#include <utility>
#include <iostream>
#include <vector>

using namespace std;

class RobotMove {
public:

    RobotMove(const pair<int, int> &finish, pair<int, int> spot) :
            start(make_pair(0, 0)), finish(finish), countPath(0) {
        int x = finish.first;
        int y = finish.second;
        offLimitSpots.resize((unsigned long) (x + 1), vector<bool>((unsigned long) (y + 1), true));
        offLimitSpots[spot.first][spot.second] = false;
    }

    void move() {
        move(start);
        cout << "# of paths = " << countPath << endl;
    }

    void showSpots() {
        for (int i = 0; i <= finish.first; ++i) {
            for (int j = 0; j <= finish.second; ++j) {
                cout << offLimitSpots[i][j] << " ";
            }
            cout << endl;
        }
    }

private:
    pair<int, int> start;
    pair<int, int> finish;
    int countPath;
    vector<vector<bool>> offLimitSpots;

    bool isFinish(pair<int, int> current) {
        return  current.first == finish.first &&
                current.second == finish.second;
    }

    void move(pair<int, int> cur) {

        cout << cur.first << " " << cur.second << endl;
        if (isFinish(cur)) {
            countPath++;
            return;
        }
        if ((cur.first < finish.first) && offLimitSpots[cur.first + 1][cur.second]) {
            move(make_pair(cur.first + 1, cur.second    ));
        }
        if ((cur.second < finish.second) && offLimitSpots[cur.first][cur.second + 1]) {
            move(make_pair(cur.first    , cur.second + 1));
        }
    }

};

#endif //RECURSION_ROBOTMOVE_H





















