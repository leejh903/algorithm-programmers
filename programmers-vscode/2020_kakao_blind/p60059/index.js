function solution(key, lock) {
    var answer = false;

    const range = lock.length + key.length - 1;
    for (let rotateCount = 0; rotateCount < 4; rotateCount++) {
        key = rotateMatrix(key);

        for (let i = 0; i < range; i++) {
            for (let j = 0; j < range; j++) {

                let extendedlock = extendlock(lock.length + (2 * (key.length - 1)), lock);

                let pass = false;
                for (let keyRow = 0; keyRow < key.length; keyRow++) {
                    for (let keyCol = 0; keyCol < key.length; keyCol++) {
                        const lockRow = keyRow + i;
                        const lockCol = keyCol + j;

                        const lockVal = extendedlock[lockRow][lockCol];
                        const keyVal = key[keyRow][keyCol];

                        // if(rotateCount == 0 && i == 3 && j == 3) {
                        //     console.log(`lockRow: ${lockRow}, lockCol: ${lockCol}`);
                        //     console.log(`lockVal: ${lockVal}, keyVal: ${keyVal}`);
                        // }

                        if (lockVal === 0 && keyVal === 1 
                            && (lockRow >= key.length - 1) && (lockRow < 2 * key.length - 1) 
                            && (lockCol >= key.length - 1) && (lockCol < 2 * key.length - 1)
                            ) extendedlock[lockRow][lockCol] = keyVal;
                        if (lockVal === 1 && keyVal === 1) {
                            pass = true;
                            break;
                        }
                    }
                    if (pass) break;
                }


                // if(rotateCount == 0 && i == 3 && j == 4) {
                //     print(key);
                //     print(extendedlock);
                // }

                if (pass) continue;
                if (isValid(key.length - 1, lock.length, extendedlock)) {
                    // console.log(i + ' ' + j);
                    // print(extendedlock);
                    return true;
                }

            }
        }
    }

    return answer;
}

function print(arr) {
    for (let i = 0; i < arr.length; i++) {
        console.log(arr[i]);
    }
}

function isValid(lockStart, lockLength, extendedlock) {
    for (let row = lockStart; row < lockStart + lockLength; row++) {
        for (let col = lockStart; col < lockStart + lockLength; col++) {
            if (extendedlock[row][col] === 0) return false;
        }
    }
    return true;
}

function extendlock(range, lock) {
    let arr = Array(range).fill(null).map(() => Array(range).fill(0));
    for (let i = 0; i < lock.length; i++) {
        for (let j = 0; j < lock.length; j++) {
            let row = i + lock.length - 1;
            let col = j + lock.length - 1;
            arr[row][col] = lock[i][j];
        }
    }
    return arr;
}

function flipMatrix(matrix) {
    return matrix[0].map((column, index) => (
        matrix.map(row => row[index])
    ))
}

function rotateMatrix(matrix) {
    return flipMatrix(matrix.reverse())
}

// let key = [[0, 0, 0], [1, 0, 0], [0, 1, 1]];
// let lock = [[1, 1, 1], [1, 1, 0], [1, 0, 1]];
// console.log(solution(key, lock));