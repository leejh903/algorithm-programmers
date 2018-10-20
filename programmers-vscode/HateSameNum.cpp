#include <vector>
#include <iostream>

using namespace std;

class HateSameNum{
    public:
    vector<int> solution(vector<int> arr) 
    {
        vector<int> answer;
        for(int i = 0; i < arr.size(); i++){
            if(answer.empty() || arr[i] != answer.back()){
                answer.push_back(arr[i]);
            }
        }

        return answer;
    }
};

int main(){
    HateSameNum hatesameNum;
    vector<int> answer;
    vector<int> arr = {4,4,4,3,3};
    answer = hatesameNum.solution(arr);
    for(int &x : answer){
        cout << x << ' ';
    }
    return 0;
}