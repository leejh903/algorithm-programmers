#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

class ArrangeStrings{
    public:
    vector<string> solution(vector<string> strings, int n) {
        vector<string> answer;
        
        for(int i = 0; i < strings.size(); i++){
            char temp = strings[i][n];
            string str(1, temp);
            strings[i].insert(0, str);
        }

        sort(strings.begin(), strings.end());

        for(int i = 0; i < strings.size(); i++){
            answer.push_back(strings[i].erase(0, 1));
        }

        return answer;
    }
};

int main(){
    ArrangeStrings arrageStrings;
    vector<string> strings = {"abce", "abcd", "cdx"};
    vector<string> answer;
    int n = 2;
    answer = arrageStrings.solution(strings, n);

    for(string &x : answer){
        cout << x << " ";
    }
    return 0;
}
