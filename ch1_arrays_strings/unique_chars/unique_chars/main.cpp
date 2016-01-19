//
//  main.cpp
//  unique_chars
//
//  Created by Ilya Rudyak on 1/19/16.
//  Copyright © 2016 Ilya Rudyak. All rights reserved.
//

#include <iostream>
#include <string>
#include <vector>
using namespace std;



bool is_chars_unique(string s);

int main(int argc, const char * argv[]) {
    
    
    string s = "helLo";
    cout << is_chars_unique(s) << endl;
    return 0;
}


bool is_chars_unique(string s) {
    
    vector<bool> chars(256, false);
    
    for (char ch: s) {
        if (chars[ch]) {
            return true;
        } else {
            chars[ch] = true;
        }
    }
    return false;
}















