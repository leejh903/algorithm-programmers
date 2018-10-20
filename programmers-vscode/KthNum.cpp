#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;

    for (int i = 0; i < commands.size(); i++) {
        vector<int> temp;
        int startIndex = commands[i][0] - 1;
        int endIndex = commands[i][1] - 1;
        int nthIndex = commands[i][2] - 1;
        for(int j = startIndex; j <= endIndex; j++) {
            temp.push_back(array[j]);
        }
        sort(temp.begin(), temp.end());
        answer.push_back(temp[nthIndex]);
    }

    return answer;
}

int main() {
    vector<int> array = {1, 5, 2, 6, 3, 7, 4};
    vector<vector<int>> commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
    vector<int> answer = solution(array, commands);
    for(int i = 0; i < answer.size(); i++) {
        cout << answer[i] << " ";
    }
    cout << '\n';
    return 0;
}