//
//  main.cpp
//  reverse_string
//
//  Created by Ilya Rudyak on 1/19/16.
//  Copyright © 2016 Ilya Rudyak. All rights reserved.
//

#include <iostream>
#include <string>
using namespace std;

string sreverse(string s);

int main() {
    
    string s = "hello";
    cout << sreverse(s) << endl;
    return 0;
}


string sreverse(string s) {
    
    if (s.length() == 0) {
        return "";
    }
    
    return s.back() + sreverse(s.substr(0, s.length() - 1));
}