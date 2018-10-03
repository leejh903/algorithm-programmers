#include <string>
#include <iostream>
#include <vector>
using namespace std;

class StringToInteger {
public:
    int solution(string s) {
        int answer = 0;
        answer = stoi(s);
        return answer;
    }
};

int main() {
    string s = "-12345";
    StringToInteger stringToInteger;
    cout << stringToInteger.solution(s) << '\n';
    return 0;
}