function solution(s) {
    var min = s.length;

    for (let charLength = 1; charLength <= Math.floor(s.length / 2); charLength++) {

        let hit = 1;
        let previous = s.slice(0, charLength);
        let newStr = '';
        for (let pointer = charLength; pointer < s.length; pointer += charLength) {
            let next = s.slice(pointer, pointer + charLength);

            if (previous === next) {
                hit++;
            }

            if (previous !== next) {
                if (hit != 1) newStr += (String(hit) + previous);
                else newStr += previous;

                previous = next;
                hit = 1;
            }

        }
        if (hit != 1) newStr += (String(hit) + previous);
        else newStr += previous;

        // console.log(newStr);
        min = Math.min(min, newStr.length);
    }

    return min;
}

// console.log(solution('xababcdcdababcdcd'));