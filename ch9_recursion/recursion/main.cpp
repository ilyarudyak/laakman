#include <iostream>

using namespace std;

void parenths(string acc, int leftSize,
              int rightSize, int count) {

    cout << leftSize << " " << rightSize << " "
    << "c=" << count << " " << acc << endl;

    if (leftSize == 0 && rightSize == 0) {
        cout << acc << endl;
    }

    if (count == 0) {
            if (leftSize > 0) {
                parenths(acc + "(", --leftSize, rightSize, ++count);
            }
        } else {
            if (leftSize > 0) {
                parenths(acc + "(", --leftSize, rightSize, ++count);
                parenths(acc + ")", leftSize, --rightSize, --count);
            }
            else {
                parenths(acc + ")", leftSize, --rightSize, --count);
            }
        }

}

void parenths(int n) {
    parenths("", n, n, 0);
}

int main() {
    parenths(3);
    return 0;
}


















