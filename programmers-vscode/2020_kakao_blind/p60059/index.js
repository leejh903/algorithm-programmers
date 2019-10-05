function solution(key, lock) {
    var answer = false;

    const range = lock.length + key.length - 1;
    for (let rotateCount = 0; rotateCount < 4; rotateCount++) {
        key = rotateMatrix(key);

        for (let i = 0; i < range; i++) {
            for (let j = 0; j < range; j++) {

                let extendedlock = extendlock(key.length, lock);
                let pass = false;
                for (let keyRow = 0; keyRow < key.length; keyRow++) {
                    for (let keyCol = 0; keyCol < key.length; keyCol++) {
                        const lockRow = keyRow + i;
                        const lockCol = keyCol + j;

                        const lockVal = extendedlock[lockRow][lockCol];
                        const keyVal = key[keyRow][keyCol];

                        // out of lock boundary: it should be considered
                        if (lockRow < key.length - 1 || lockCol < key.length - 1
                            || lockRow >= lock.length + key.length - 1 || lockCol >= lock.length + key.length - 1) continue;

                        if (lockVal === 0 && keyVal === 1) extendedlock[lockRow][lockCol] = keyVal;
                        if (lockVal === 1 && keyVal === 1) pass = true;  // conflict case
                    }
                }

                if (pass) continue;  // conflict case cannot be an answer
                if (isValid(key.length - 1, lock.length, extendedlock)) return true;
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

// check lock is all covered by 1
function isValid(lockStart, lockLength, extendedlock) {
    for (let row = lockStart; row < lockStart + lockLength; row++) {
        for (let col = lockStart; col < lockStart + lockLength; col++) {
            if (extendedlock[row][col] === 0) return false;
        }
    }
    return true;
}

// extend Matrix to check all case
function extendlock(keyLength, lock) {
    const range = lock.length + (2 * (keyLength - 1));
    let arr = Array(range).fill(null).map(() => Array(range).fill(0));
    for (let i = 0; i < lock.length; i++) {
        for (let j = 0; j < lock.length; j++) {
            let row = i + keyLength - 1;
            let col = j + keyLength - 1;
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

// let lock = [
//     [1, 1, 1, 1, 1, 1, 1],
//     [1, 1, 1, 1, 1, 1, 1],
//     [1, 1, 1, 1, 1, 1, 0],
//     [1, 1, 1, 1, 1, 1, 1],
//     [1, 1, 1, 1, 0, 1, 1],
//     [1, 1, 1, 1, 1, 1, 1],
//     [1, 1, 1, 1, 1, 1, 1],
// ]
// let key = [[1, 0, 0], [0, 0, 0], [0, 0, 1]];
// console.log(solution(key, lock));