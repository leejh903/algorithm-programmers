#include <vector>
using namespace std;

long long solution(int N) {
    bool d[N+1];  // 소수 체크할 수 있는 배열 생성
    long long answer = 0;

    if(N <= 1) {
        return 0;
    }

    for(int i = 2; i <= N; i++) {
        d[i] = true;  // 소수 체크할 수 있는 배열 true로 채워넣기
    }

    for(int x = 2; x <= N; x++) {
        if(d[x]) {  // 소수일 때
            answer += x;
            for(int y = x; y <= N; y += x) {  // 해당 소수의 배수는 false 처리
                d[y] = false;
            }
        }
    }
    return answer;
}

int main() {  // for test
    printf("%lld\n", solution(20));
    return 0;
}