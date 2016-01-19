//
//  main.cpp
//  permutation
//
//  Created by Ilya Rudyak on 1/19/16.
//  Copyright © 2016 Ilya Rudyak. All rights reserved.
//

#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

bool is_permute(string &s, string &s2);

int main(int argc, const char * argv[]) {
    
    
    string s = "hello";
    string s2 = "ehllo";
    cout << is_permute(s, s2) << endl;
    return 0;
}


bool is_permute(string &s, string &s2) {
    
    sort(s.begin(), s.end());
    sort(s2.begin(), s2.end());
    return s == s2;
    
}























