function solution(n, build_frame) {
    let bridges = Array(n + 2).fill(null).map(() => Array(n + 1).fill(false));
    let stands = Array(n + 2).fill(null).map(() => Array(n + 1).fill(false));

    function canInstallStand(x, y) {
        if (y === 0) return true;  // 바닥 위
        if (((x !== 0) && bridges[y][x - 1]) || bridges[y][x]) return true;  // 보의 한쪽 끝
        if (stands[y - 1][x]) return true;  // 다른 기둥 위
        return false;
    }

    function canRemoveStand(x, y) {
        if ((x !== 0 && bridges[y + 1][x - 1]) && !bridges[y + 1][x]) return false;  // 왼쪽 보 있고, 오른쪽 보 없을 때
        if (!(x !== 0 && bridges[y + 1][x - 1]) && bridges[y + 1][x]) return false;  // 왼쪽 보 없고, 오른쪽 보 있을 때
        return true;
    }

    function canInstallBridge(x, y) {
        if ((x !== 0 && x < n - 1 && bridges[y][x - 1]) && bridges[y][x + 1]) return true;  // 양 옆에 보가 있는 경우
        if (stands[y - 1][x] || stands[y - 1][x + 1]) return true;  // 왼쪽 또는 오른쪽에 기둥이 있는 경우
        return false;
    }

    function canRemoveBridge(x, y) {
        if (((x !== 0 && stands[y - 1][x - 1]) || stands[y - 1][x]) &&  // 왼쪽 보 버틸 수 있는 경우
            (stands[y - 1][x + 1] || stands[y - 1][x + 2])) return true;  // 오른쪽 보 버틸 수 있는 경우
        return false;
    }

    for (const element of build_frame) {
        let x = element[0];
        let y = element[1];

        if (element[2] === 0) {   // is stand
            if (element[3] === 0) {  // want to remove stand
                if (canRemoveStand(x, y)) stands[y][x] = false;
            }
            if (element[3] === 1) {  // want to install stand
                if (canInstallStand(x, y)) stands[y][x] = true;
            }
        }
        if (element[2] === 1) {  // is bridge
            if (element[3] === 0) {  // want to remove bridge
                if (canRemoveBridge(x, y)) bridges[y][x] = false;
            }
            if (element[3] === 1) {  // want to install bridge
                if (canInstallBridge(x, y)) bridges[y][x] = true;
            }
        }
    }

    let answer = [];
    for (let i = 0; i < n + 1; i++) {
        for (let j = 0; j < n + 1; j++) {
            if (stands[j][i]) {
                answer.push([i, j, 0]);
            }
            if (bridges[j][i]) {
                answer.push([i, j, 1]);
            }
        }
    }
    return answer;
}

// test case 1
let n = 5;
// let build_frame = [[1, 0, 0, 1], [1, 1, 1, 1], [2, 1, 0, 1], [2, 2, 1, 1], [5, 0, 0, 1], [5, 1, 0, 1], [4, 2, 1, 1], [3, 2, 1, 1]];
let build_frame = [[0, 0, 0, 1], [2, 0, 0, 1], [4, 0, 0, 1], [0, 1, 1, 1], [1, 1, 1, 1], [2, 1, 1, 1], [3, 1, 1, 1], [2, 0, 0, 0], [1, 1, 1, 0], [2, 2, 0, 1]];
console.log(solution(n, build_frame));
