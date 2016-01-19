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

string sreverse(string &s);
void sreverse2(string &s);
void swap(string &s, int i, int j);

int main() {
    
    string s = "hello";
    sreverse2(s);
    cout << s << endl;
    return 0;
}


string sreverse(string &s) {
    
    if (s.length() == 0) {
        return "";
    }
    
    string sub = s.substr(0, s.length() - 1);
    return s.back() + sreverse(sub);
}

void swap(string &s, int i, int j) {
    
    char tmp = s[i];
    s[i] = s[j];
    s[j] = tmp;
}

void sreverse2(string &s) {
    
    for (int i = 0; i < s.length() / 2; i++) {
        swap(s, i, (int) s.length() - 1 - i);
    }
    
    

}

















