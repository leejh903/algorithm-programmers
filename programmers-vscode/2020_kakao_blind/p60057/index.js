function solution(s) {
    var min = s.length;

    for (let charLength = 1; charLength <= Math.floor(s.length / 2); charLength++) {

        let temp = 0;
        let hit = 0;
        let previous = '';
        for (let pointer = 0; pointer < s.length; pointer += charLength) {
            let next = s.slice(pointer, pointer + charLength);

            console.log(`temp: ${temp}, previous: ${previous}, next: ${next}`);

            if (previous === next) {
                hit++;
            }

            if (previous !== next) {
                previous = next;
                temp += next.length;
                
                if(hit != 0) temp += String(hit).length;
                hit = 0;
            }

        }
        if(hit != 0) temp += String(hit).length;

        min = Math.min(min, temp);
    }

    return min;
}

console.log(solution('aaaaaaaaaaaaaaaaaaa'));