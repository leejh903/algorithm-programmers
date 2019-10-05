function solution(p) {
    var answer = converter(p);
    return answer.trim();
}

function converter(w) {
    if (isEmtpy(w)) return '';

    const index = findDivIndex(w);
    const u = w.slice(0, index);
    const v = w.slice(index);

    if(isCorrect(u)) return u + converter(v);
    else {
        let str = '';
        str += '(';
        str += converter(v);
        str += ')';
        str += processU(u);
        return str;
    }

}

function processU(u) {
    // 앞뒤 자르고 뒤집기
    u = u.slice(1, u.length - 1);
    let newU = '';
    for (let i = 0; i < u.length; i++) {
        if(u[i] === '(') newU += ')';
        if(u[i] === ')') newU += '(';
    }
    return newU;
}

function isCorrect(u) {
    const arr = u.split('');
    let stack = [];
    for (let i = 0; i < arr.length; i++) {
        const element = arr[i];
        if (element === '(') stack.push(element);
        if (element === ')') {
            if (stack.pop() !== '(') return false;
        }
    }
    return isEmtpy(stack);
}

function findDivIndex(w) {
    let left = 0, right = 0;
    let index = 0;
    for (index = 0; index < w.length; index++) {
        const element = w[index];
        if (element === ')') right++;
        if (element === '(') left++;
        if (left === right) break;
    }
    return index + 1;
}

function isEmtpy(s) {
    return s.length == 0;
}