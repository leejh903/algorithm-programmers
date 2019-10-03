function solution(s) {
    var min = s.length;

    for (let charLength = 1; charLength <= Math.floor(s.length / 2); charLength++) {

        let temp = 0;
        let firstHit = true;
        for (let pointer = 0; pointer < s.length; pointer++) {
            let previous = s.slice(pointer, pointer + charLength)
            let next = s.slice(pointer + charLength, pointer + (charLength * 2));

            if (next.length < charLength) {
                console.log(`temp: ${temp}, previous: ${previous}, next: ${next}`);
                if (!firstHit) temp += next.length;
                if (firstHit) temp += previous.length + next.length;
                break;
            }

            if (previous === next) {
                if (firstHit) {
                    temp += previous.length + 1;
                }
                firstHit = false;
                pointer += previous.length - 1  // for문에서 +1 증가하기 때문;
            }

            if (previous !== next) {
                if(!firstHit) {
                    pointer += previous.length - 1  // for문에서 +1 증가하기 때문;
                }
                else temp++;
                firstHit = true;
            }

        }

        console.log(charLength + ' ' + temp);
        min = Math.min(min, temp);
    }

    return min;
}

console.log(solution('xababcdcdababcdcd'));