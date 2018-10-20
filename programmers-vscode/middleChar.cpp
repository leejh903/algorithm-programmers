#include <string>
#include <vector>
#include <iostream>

using namespace std;

class middleChar{
    public:
    string solution(string s) {
        string answer = "";

        if(s.length() % 2){  // 홀수
            answer = s[s.length()/2];
        } else {
            answer.push_back(s[s.length()/2-1]);
            answer.push_back(s[s.length()/2]);
        }
        return answer;
    }
};

int main(){
    middleChar middlechar;
    cout << middlechar.solution("qwer");

    return 0;
}