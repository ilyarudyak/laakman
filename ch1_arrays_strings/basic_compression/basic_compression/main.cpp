//
//  main.cpp
//  basic_compression
//
//  Created by Ilya Rudyak on 1/19/16.
//  Copyright © 2016 Ilya Rudyak. All rights reserved.
//

#include <iostream>
#include <string>
using namespace std;

string compress(string s);

int main() {
    
    string s = "aabcccccaaa";
    cout << compress(s) << endl;
    
    return 0;
}


string compress(string s) {
    
    string cs = "";
    int count = 1;
    char temp = s[0];
    for (int i = 1; i < s.length(); i++) {
        if (s[i] == temp) {
            count++;
        } else {
            cs += temp + to_string(count);
            count = 1;
            temp = s[i];
        }
    }
    
    cs += temp + to_string(count);
    return cs;
}












