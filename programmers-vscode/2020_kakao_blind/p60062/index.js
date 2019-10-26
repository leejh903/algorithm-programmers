var _n, _weak, _dist;

function solution(n, weak, dist) {
    var answer = 0;
    _n = n;
    _weak = weak;
    _dist = dist;

    let visited = Array(weak.length).fill(false);

    for (let i = 0; i < weak.length; i++) {
        if (visited[i]) continue;

        travel(i, i);
    }

    return answer;
}

function travel(head, tail) {
    
}

function calculateCost(index, direction) {
    if (direction === 'left') {
        if (index === 0) return weak[index] + n - weak[weak.length - 1];
        return weak[index] - weak[index - 1];
    }
    if (direction === 'right') {
        if (index === weak.length - 1) return n - weak[index] + weak[0];
        return weak[index + 1] - weak[index];
    }
}

let n = 12;
let weak = [1, 5, 6, 10];
let dist = [1, 2, 3, 4];
solution(n, weak, dist);