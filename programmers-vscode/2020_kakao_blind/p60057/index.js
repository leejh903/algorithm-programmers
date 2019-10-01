function solution(s) {
    var min = s.length;
    for (let charLength = 1; charLength <= Math.floor(s.length / 2); charLength++) {
        let firstHit = true;
        let previous;
        let temp = 0;
        for (let index = 0; index < Math.floor(s.length / charLength); index++) {
            if(previous === undefined) previous = s.slice(index, index + charLength);
            let next = s.slice(index + charLength, index + (charLength* 2));
            console.log(`previous: ${previous}, next: ${next}, temp: ${temp}`);    
            if(next === '' || next.length !== charLength) break;
            if (previous === next) {
                if (firstHit) {
                    firstHit = false;
                    temp += previous.length + 1;  // 1 means count number
                }
            } else {
                previous = next;
                temp++;
                firstHit = true;
            }
        }
        console.log(`charLength(${charLength}): ${temp}`);
        min = Math.min(min, temp);
    }
    return min;
}

console.log(solution('abcdxyzxyz'));