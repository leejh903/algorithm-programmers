#include <string>
#include <vector>
#include <iostream>

using namespace std;

class programmers_2016{
    public:
    string solution(int a, int b) {
        int monthLength[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        string dayName[] = {"SUN","MON","TUE","WED","THU","FRI","SAT"};

        string answer = "";
        int firstDay = 5;

        for(int i = 0; i < a-1; i++){
            firstDay = firstDay + monthLength[i];
        }
        firstDay = firstDay + (b-1);
        answer = dayName[firstDay % 7];

        return answer;
    }
};

int main(){
    programmers_2016 test;
    string answer = test.solution(5,24);

    cout << answer;

    return 0;
}