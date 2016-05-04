#include <iostream>
#include <vector>
using namespace std;

void magic(vector<int> &A, int left, int right) {

    cout << left << " " << right;

    if (left > right) {
        return;
    }

    int mid = left + (right - left) / 2;
    cout << " " << mid << endl;
    if (A[mid] == mid) {
        cout << mid << endl;
    } else if (A[mid] < mid) {
        magic(A, mid + 1, right);
    } else {
        magic(A, left, mid - 1);
    }

}
void magic(vector<int> &A) {
     magic(A, 0, (int) A.size() - 1);
}

int magic2(vector<int> &A, int left, int right) {


    if (left > right) {
        return -1;
    }

    int mid = (left + right) / 2;
    if (A[mid] == mid) {
        return mid;
    } else if (A[mid] < mid) {
        return magic2(A, mid + 1, right);
    } else {
        return magic2(A, left, mid - 1);
    }

}
int magic2(vector<int> &A) {
    magic2(A, 0, 8);
}



int main() {

    vector<int> A = {-1, 0, 1, 2, 3, 5, 30, 40, 50};
    cout << magic2(A) << endl;
    return 0;
}