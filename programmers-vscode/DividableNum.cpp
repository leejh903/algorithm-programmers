#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

class DividableNum {
    public:
    vector<int> solution(vector<int> arr, int divisor) {
        vector<int> answer;

        for(int i = 0; i < arr.size(); i++){
            if(arr[i] % divisor == 0){
                answer.push_back(arr[i]);
            }
        }

        sort(answer.begin(), answer.end());
        if(answer.empty()) {
            answer.push_back(-1);
        }

        return answer;
    }
};

int main(){
    DividableNum dividableNum;
    vector<int> answer;
    vector<int> arr = {3,2,6};
    int divider = 10;
    answer = dividableNum.solution(arr, divider);

    for(int &x : answer){
        cout << x << " ";
    }
    return 0;
}
